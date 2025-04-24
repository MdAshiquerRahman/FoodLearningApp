package com.example.practice.viewmodel

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.practice.api.AuthRetrofitInstance
import androidx.core.content.edit
import com.example.practice.api.dataclass.login.LoginRequest
import com.example.practice.api.dataclass.profile.ProfileResponse
import com.example.practice.api.dataclass.signup.SignUpRequest
import com.example.practice.repository.SharedPreferencesHelper
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel : ViewModel() {
    // State variables
    var token by mutableStateOf<String?>(null)
    var userPassword by mutableStateOf("pass")
    var errorMessage by mutableStateOf<String?>(null)
    var registrationSuccess by mutableStateOf(false)
    var isLoading by mutableStateOf(false)
    var profile by mutableStateOf<ProfileResponse?>(null)

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    // Helper function to interpret error responses
    private fun interpretErrorResponse(code: Int): String {
        return when (code) {
            400 -> "Invalid input. Please check your entries and try again."
            401 -> "Incorrect username or password. Please try again."
            403 -> "Access denied. Please contact support for assistance."
            404 -> "Resource not found. Please try again."
            409 -> "Username or email already exists."
            500 -> "Server error. Please try again later."
            else -> "An unexpected error occurred. Please try again."
        }
    }

    fun signUp(username: String, email: String, password1: String, password2: String) {
        viewModelScope.launch(Dispatchers.IO) { // Runs in IO thread context
            if (username.isBlank() || email.isBlank() || password1.isBlank() || password2.isBlank()) {
                errorMessage = "All fields are required."
                return@launch
            }
            if (password1 != password2) {
                errorMessage = "Passwords do not match."
                return@launch
            }

            val request = SignUpRequest(username, email, password1, password2)
            try {
                val response = AuthRetrofitInstance.api.registerUser(request)
                if (response.isSuccessful) {
                    registrationSuccess = true
                } else {
                    errorMessage = interpretErrorResponse(response.code())
                }
            } catch (e: Exception) {
                errorMessage = "An error occurred: ${e.localizedMessage}"
            }
        }
    }

    fun login(username: String, email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) { // Runs in IO thread context
            if (username.isBlank() || email.isBlank() || password.isBlank()) {
                errorMessage = "All fields are required."
                return@launch
            }

            isLoading = true
            try {
                val response = AuthRetrofitInstance.api.login(
                    LoginRequest(username = username, email = email, password = password)
                )
                if (response.isSuccessful) {
                    // Access the `key` property from the response body
                    token = response.body()?.key
                    val userResponse = AuthRetrofitInstance.api.getUserInfo("Token $token")
                    profile = userResponse
                    errorMessage = null
                } else {
                    errorMessage = interpretErrorResponse(response.code())
                }
            } catch (e: Exception) {
                errorMessage = "An error occurred: ${e.localizedMessage}"
            } finally {
                isLoading = false
            }
        }
    }

    fun updateProfile(
        context: Context,
        username: String,
        email: String,
        profile_picture: Uri?,
        userId: String?
    ) {
        viewModelScope.launch(Dispatchers.IO) { // Runs in IO thread context
            if (username.isBlank() || email.isBlank()) {
                errorMessage = "Username and email cannot be empty."
                return@launch
            }

            try {
                val token = getToken(context)
                val contentResolver = context.contentResolver

                val usernamePart = username.toRequestBody("text/plain".toMediaType())
                val emailPart = email.toRequestBody("text/plain".toMediaType())
                val userIdPart = userId?.toRequestBody("text/plain".toMediaType())

                val imagePart = profile_picture?.let {
                    val inputStream = contentResolver.openInputStream(it)!!
                    val fileBytes = inputStream.readBytes()
                    val requestBody = fileBytes.toRequestBody("image/*".toMediaTypeOrNull())
                    MultipartBody.Part.createFormData("profile_picture", "profile.jpg", requestBody)
                }

                val response = AuthRetrofitInstance.api.updateUserInfo(
                    token = "Token $token",
                    username = usernamePart,
                    email = emailPart,
                    profile_picture = imagePart,
                    userId = userIdPart
                )

                if (response.isSuccessful) {
                    // Access the body of the response and assign it to the profile
                    profile = response.body()
                    errorMessage = null
                } else {
                    // Handle error based on response status
                    errorMessage = response.errorBody()?.string() ?: "Failed to update profile. Please try again."
                }
            } catch (e: Exception) {
                errorMessage = "An error occurred: ${e.localizedMessage}"
            }
        }
    }

    fun logout(context: Context) {
        viewModelScope.launch(Dispatchers.IO) { // Runs in IO thread context
            isLoading = true
            try {
                val savedToken = token
                if (!savedToken.isNullOrEmpty()) {
                    val response = AuthRetrofitInstance.api.logout("Token $savedToken")
                    if (response.isSuccessful) {
                        val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
                        sharedPreferences.edit { clear() }
                        _isLoggedIn.value = false
                        token = null
                        profile = null
                    } else {
                        errorMessage = interpretErrorResponse(response.code())
                    }
                } else {
                    errorMessage = "No token found. Unable to log out."
                }
            } catch (e: Exception) {
                errorMessage = "An error occurred: ${e.localizedMessage}"
            } finally {
                isLoading = false
            }
        }
    }

    fun saveUsername(context: Context, username: String) {
        val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        sharedPreferences.edit { putString("username", username) }
    }

    fun getUsername(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        return sharedPreferences.getString("username", null)
    }

    fun saveEmail(context: Context, email: String) {
        val sharedPreferences = context.getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        sharedPreferences.edit { putString("email", email) }
    }

    fun getEmail(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        return sharedPreferences.getString("email", null)
    }

    fun savePassword(context: Context, password: String) {
        val sharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE)
        sharedPreferences.edit { putString("password", password) }
    }

    fun getPassword(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE)
        return sharedPreferences.getString("password", null)
    }

    fun saveToken(context: Context, token: String) {
        SharedPreferencesHelper.save(context, "auth_token", token)
    }

    fun getToken(context: Context): String? {
        return SharedPreferencesHelper.get(context, "auth_token")
    }

    fun isLoggedIn(context: Context): Boolean {
        return !getToken(context).isNullOrEmpty()
    }

    fun checkLoginStatus(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoggedIn.value = isLoggedIn(context)
        }
    }
}