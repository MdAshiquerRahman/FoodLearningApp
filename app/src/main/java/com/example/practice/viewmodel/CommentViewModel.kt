package com.example.practice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.api.AuthRetrofitInstance
import com.example.practice.api.dataclass.comment.CommentRequest
import com.example.practice.api.dataclass.comment.CommentResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okio.IOException

class CommentViewModel : ViewModel() {

    private val _commentList = MutableLiveData<List<CommentResponse>>()
    val commentList: LiveData<List<CommentResponse>> = _commentList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    val authViewModel: AuthViewModel = AuthViewModel()

    // Post comment function
    fun postComment(token: String, videoId: Int, text: String) {
        viewModelScope.launch(Dispatchers.IO) { // Execute in IO dispatcher
            _isLoading.postValue(true)
            _errorMessage.postValue(null) // Clear any previous errors
            try {
                val request = CommentRequest(video = videoId, text = text)

                // Make the POST request with the token for authentication
                val response = AuthRetrofitInstance.api.postComment(
                    token = "Token $token",
                    comment = request
                )

                if (response.isSuccessful) {
                    // Update LiveData for UI success handling
                    fetchComments() // Optionally refresh comments
                } else {
                    _errorMessage.postValue("Error posting comment: ${response.message()}")
                }
            } catch (e: IOException) {
                _errorMessage.postValue("Network error: ${e.localizedMessage}")
            } catch (e: Exception) {
                _errorMessage.postValue("Unexpected error: ${e.localizedMessage}")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    // Fetch comments function
    fun fetchComments() {
        viewModelScope.launch(Dispatchers.IO) { // Execute in IO dispatcher
            _isLoading.postValue(true)
            try {
                val response = AuthRetrofitInstance.api.getComments()
                if (response.isSuccessful) {
                    _commentList.postValue(response.body() ?: emptyList())
                    _errorMessage.postValue(null)
                } else {
                    _errorMessage.postValue("Error fetching comments: ${response.message()}")
                }
            } catch (e: IOException) {
                _errorMessage.postValue("Network error: ${e.localizedMessage}")
            } catch (e: Exception) {
                _errorMessage.postValue("An error occurred: ${e.localizedMessage}")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }
}