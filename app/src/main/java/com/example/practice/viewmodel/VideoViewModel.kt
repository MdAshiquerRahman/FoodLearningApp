package com.example.practice.viewmodel


import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.api.AuthRetrofitInstance
import com.example.practice.api.dataclass.video.UploadVideos
import kotlinx.coroutines.launch
import retrofit2.Response
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.practice.api.dataclass.likedislike.DislikeStatusResponse
import com.example.practice.api.dataclass.likedislike.LikeStatusResponse
import com.example.practice.api.dataclass.video.FavoriteVideos
import com.example.practice.api.dataclass.video.FavoriteVideosItem
import com.example.practice.api.dataclass.video.UploadVideosItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException


class VideoViewModel : ViewModel() {
    // LiveData for storing video list
    private val _videoList = MutableLiveData<List<UploadVideosItem>>()
    val videoList: LiveData<List<UploadVideosItem>> = _videoList

    // Fetch favorite videos
    private val _favoriteVideoList = MutableLiveData<List<FavoriteVideosItem>>()
    val favoriteVideoList: LiveData<List<FavoriteVideosItem>> = _favoriteVideoList

    // LiveData for loading state
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    // LiveData for error messages
    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private val _likeStatus = MutableStateFlow<LikeStatusResponse?>(null)
    val likeStatus: StateFlow<LikeStatusResponse?> = _likeStatus

    private val _dislikeStatus = MutableStateFlow<DislikeStatusResponse?>(null)
    val dislikeStatus: StateFlow<DislikeStatusResponse?> = _dislikeStatus


    val authViewModel: AuthViewModel = AuthViewModel()


    // Post videos directly from API
    fun postVideos(
        context: Context,
        token: String,
        title: String,
        description: String,
        video_file: Uri?,
        thamnail: Uri?
    ) {
        if (video_file == null || thamnail == null) {
            _errorMessage.value = "Video or thumbnail file is missing."
            return
        }

        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val contentResolver = context.contentResolver

                val titleRequest = title.toRequestBody("text/plain".toMediaType())
                val descriptionRequest = description.toRequestBody("text/plain".toMediaType())

                val videoPart = video_file.let {
                    val inputStream = contentResolver.openInputStream(it)!!
                    val requestBody = inputStream.readBytes().toRequestBody("video/*".toMediaTypeOrNull())
                    inputStream.close()
                    MultipartBody.Part.createFormData("video_file", "video.mp4", requestBody)
                }

                val thumbnailPart = thamnail.let {
                    val inputStream = contentResolver.openInputStream(it)!!
                    val requestBody = inputStream.readBytes().toRequestBody("image/*".toMediaTypeOrNull())
                    inputStream.close()
                    MultipartBody.Part.createFormData("thamnail", "thamnail.jpg", requestBody)
                }

                val response = AuthRetrofitInstance.api.uploadVideo(
                    token = "Token $token",
                    title = titleRequest,
                    description = descriptionRequest,
                    video = videoPart,
                    thumbnail = thumbnailPart
                )

                handleApiResponse(response) {
                    fetchVideos() // Refresh video list on success
                }

            } catch (e: IOException) {
                Log.e("PostVideosError", "Network error: ${e.localizedMessage}", e)
                _errorMessage.value = "Network error occurred. Please try again."
            } catch (e: Exception) {
                Log.e("PostVideosError", "Error: ${e.localizedMessage}", e)
                _errorMessage.value = "An unexpected error occurred. Please try again."
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun <T> handleApiResponse(response: Response<T>, onSuccess: () -> Unit) {
        if (response.isSuccessful) {
            onSuccess()
        } else {
            val errorBody = response.errorBody()?.string()
            _errorMessage.value = errorBody ?: "Unexpected error occurred"
        }
    }


//    private fun handleApiResponse(response: Response<UploadVideosItem>, onSuccess: () -> Unit) {
//        if (response.isSuccessful) {
//            onSuccess()
//        } else {
//            val errorBody = response.errorBody()?.string()
//            _errorMessage.value = errorBody ?: "Unexpected error occurred"
//        }
//    }
//
//    private fun handleApiResponseUnit(response: Response<Unit>, onSuccess: () -> Unit) {
//        if (response.isSuccessful) {
//            onSuccess()
//        } else {
//            val errorBody = response.errorBody()?.string()
//            _errorMessage.value = errorBody ?: "Unexpected error occurred"
//        }
//    }


    // Fetch videos directly from the API
    fun fetchVideos() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // Fetch videos from API without checking login status
                val response: Response<UploadVideos> = AuthRetrofitInstance.api.getVideos()
                if (response.isSuccessful) {
                    _videoList.value = response.body() ?: emptyList()
                    _errorMessage.value = null
                } else {
                    _errorMessage.value = "Error fetching videos: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    // Fetch videos directly from the API
    fun fetchFavoriteVideos(token: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // Fetch videos from API without checking login status
                val response: Response<FavoriteVideos> = AuthRetrofitInstance.api.getFavorite(
                    token = "Token $token"
                )
                if (response.isSuccessful) {
                    _favoriteVideoList.value = response.body() ?: emptyList()
                    _errorMessage.value = null
                } else {
                    _errorMessage.value = "Error fetching videos: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getFavoriteVideos(videoId: Int, token: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = AuthRetrofitInstance.api.makeFavorite(
                    token = "Token $token",
                    videoId = videoId
                )
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    _errorMessage.value = "Error: ${response.code()} - ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun likeVideo(videoId: Int, token: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = AuthRetrofitInstance.api.likeVideo(
                    token = "Token $token",
                    videoId = videoId
                )
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    _errorMessage.value = "Error: ${response.code()} - ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun dislikeVideo(videoId: Int, token: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = AuthRetrofitInstance.api.dislikeVideo(
                    token = "Token $token",
                    videoId = videoId
                )
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    _errorMessage.value = "Error: ${response.code()} - ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getLikeStatus(videoId: Int, token: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = AuthRetrofitInstance.api.getLikeStatus(
                    token = "Token $token",
                    videoId = videoId
                )
                if (response.isSuccessful) {
                    _likeStatus.value = response.body()
                } else {
                    _errorMessage.value = "Error: ${response.code()} - ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getDislikeStatus(videoId: Int, token: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = AuthRetrofitInstance.api.getDislikeStatus(
                    token = "Token $token",
                    videoId = videoId
                )
                if (response.isSuccessful) {
                    _dislikeStatus.value = response.body()
                } else {
                    _errorMessage.value = "Error: ${response.code()} - ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }


//
//    fun updateDislike(videoId: Int, token: String, onSuccess: () -> Unit) {
//        viewModelScope.launch {
//            _isLoading.value = true
//            try {
//                val response = AuthRetrofitInstance.api.updateDislike(
//                    token = "Token $token",
//                    videoId = videoId
//                )
//                if (response.isSuccessful) {
//                    onSuccess()
//                } else {
//                    _errorMessage.value = "Error: ${response.code()} - ${response.message()}"
//                }
//            } catch (e: Exception) {
//                _errorMessage.value = "An error occurred: ${e.localizedMessage}"
//            } finally {
//                _isLoading.value = false
//            }
//        }
//    }



}


