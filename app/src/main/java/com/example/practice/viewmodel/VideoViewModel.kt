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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException


class VideoViewModel : ViewModel() {
    private val _videoList = MutableLiveData<List<UploadVideosItem>>()
    val videoList: LiveData<List<UploadVideosItem>> = _videoList

    private val _favoriteVideoList = MutableLiveData<List<FavoriteVideosItem>>()
    val favoriteVideoList: LiveData<List<FavoriteVideosItem>> = _favoriteVideoList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private val _likeStatus = MutableStateFlow<LikeStatusResponse?>(null)
    val likeStatus: StateFlow<LikeStatusResponse?> = _likeStatus

    private val _dislikeStatus = MutableStateFlow<DislikeStatusResponse?>(null)
    val dislikeStatus: StateFlow<DislikeStatusResponse?> = _dislikeStatus

    val authViewModel: AuthViewModel = AuthViewModel()

    fun postVideos(
        context: Context,
        token: String,
        title: String,
        description: String,
        video_file: Uri?,
        thamnail: Uri?,
        onSuccess: () -> Unit = {}
    ) {
        if (video_file == null || thamnail == null) {
            _errorMessage.value = "Video or thumbnail file is missing."
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            _errorMessage.postValue(null)

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
                    fetchVideos()
                    onSuccess()
                }

            } catch (e: IOException) {
                _errorMessage.postValue("Network error occurred. Please try again.")
            } catch (e: Exception) {
                _errorMessage.postValue("An unexpected error occurred. Please try again.")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    private fun <T> handleApiResponse(response: Response<T>, onSuccess: () -> Unit) {
        if (response.isSuccessful) {
            onSuccess()
        } else {
            val errorBody = response.errorBody()?.string()
            _errorMessage.postValue(errorBody ?: "Unexpected error occurred")
        }
    }

    fun fetchVideos() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            try {
                val response: Response<UploadVideos> = AuthRetrofitInstance.api.getVideos()
                if (response.isSuccessful) {
                    _videoList.postValue(response.body() ?: emptyList())
                    _errorMessage.postValue(null)
                } else {
                    _errorMessage.postValue("Error fetching videos: ${response.message()}")
                }
            } catch (e: Exception) {
                _errorMessage.postValue("An error occurred: ${e.localizedMessage}")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    fun fetchFavoriteVideos(token: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AuthRetrofitInstance.api.getFavorite("Token $token")
                if (response.isSuccessful) {
                    _favoriteVideoList.postValue(response.body() ?: emptyList())
                    Log.d("FavoriteVideos", "Fetched: ${response.body()}")
                } else {
                    Log.e("FavoriteVideos", "Error fetching: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("FavoriteVideos", "Exception: ${e.localizedMessage}")
            }
        }
    }

    fun getFavoriteVideos(videoId: Int, token: String, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            try {
                val response = AuthRetrofitInstance.api.makeFavorite(
                    token = "Token $token",
                    videoId = videoId
                )
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    _errorMessage.postValue("Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                _errorMessage.postValue("An error occurred: ${e.localizedMessage}")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    fun likeVideo(videoId: Int, token: String, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            try {
                val response = AuthRetrofitInstance.api.likeVideo(
                    token = "Token $token",
                    videoId = videoId
                )
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    _errorMessage.postValue("Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                _errorMessage.postValue("An error occurred: ${e.localizedMessage}")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    fun dislikeVideo(videoId: Int, token: String, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            try {
                val response = AuthRetrofitInstance.api.dislikeVideo(
                    token = "Token $token",
                    videoId = videoId
                )
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    _errorMessage.postValue("Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                _errorMessage.postValue("An error occurred: ${e.localizedMessage}")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    fun deleteVideo(videoId: Int, token: String, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            try {
                val response = AuthRetrofitInstance.api.deleteVideo(
                    token = "Token $token",
                    videoId = videoId
                )
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    _errorMessage.postValue("Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                _errorMessage.postValue("An error occurred: ${e.localizedMessage}")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    fun getLikeStatus(videoId: Int, token: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            try {
                val response = AuthRetrofitInstance.api.getLikeStatus(
                    token = "Token $token",
                    videoId = videoId
                )
                if (response.isSuccessful) {
                    _likeStatus.value = response.body()
                } else {
                    _errorMessage.postValue("Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                _errorMessage.postValue("An error occurred: ${e.localizedMessage}")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    fun getDislikeStatus(videoId: Int, token: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            try {
                val response = AuthRetrofitInstance.api.getDislikeStatus(
                    token = "Token $token",
                    videoId = videoId
                )
                if (response.isSuccessful) {
                    _dislikeStatus.value = response.body()
                } else {
                    _errorMessage.postValue("Error: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                _errorMessage.postValue("An error occurred: ${e.localizedMessage}")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }
}



