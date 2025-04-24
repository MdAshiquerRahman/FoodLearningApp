package com.example.practice.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020&0+J$\u0010,\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020&0+J\u000e\u0010-\u001a\u00020&2\u0006\u0010)\u001a\u00020\bJ\u0006\u0010.\u001a\u00020&J\u0016\u0010\u0018\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\bJ$\u0010/\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020&0+J\u0016\u0010\"\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\bJ*\u00100\u001a\u00020&\"\u0004\b\u0000\u001012\f\u00102\u001a\b\u0012\u0004\u0012\u0002H1032\f\u0010*\u001a\b\u0012\u0004\u0012\u00020&0+H\u0002J$\u00104\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020&0+JJ\u00105\u001a\u00020&2\u0006\u00106\u001a\u0002072\u0006\u0010)\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010;2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020&0+R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001d\u00a8\u0006="}, d2 = {"Lcom/example/practice/viewmodel/VideoViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_dislikeStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/practice/api/dataclass/likedislike/DislikeStatusResponse;", "_errorMessage", "Landroidx/lifecycle/MutableLiveData;", "", "_favoriteVideoList", "", "Lcom/example/practice/api/dataclass/video/FavoriteVideosItem;", "_isLoading", "", "_likeStatus", "Lcom/example/practice/api/dataclass/likedislike/LikeStatusResponse;", "_videoList", "Lcom/example/practice/api/dataclass/video/UploadVideosItem;", "authViewModel", "Lcom/example/practice/viewmodel/AuthViewModel;", "getAuthViewModel", "()Lcom/example/practice/viewmodel/AuthViewModel;", "dislikeStatus", "Lkotlinx/coroutines/flow/StateFlow;", "getDislikeStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "errorMessage", "Landroidx/lifecycle/LiveData;", "getErrorMessage", "()Landroidx/lifecycle/LiveData;", "favoriteVideoList", "getFavoriteVideoList", "isLoading", "likeStatus", "getLikeStatus", "videoList", "getVideoList", "deleteVideo", "", "videoId", "", "token", "onSuccess", "Lkotlin/Function0;", "dislikeVideo", "fetchFavoriteVideos", "fetchVideos", "getFavoriteVideos", "handleApiResponse", "T", "response", "Lretrofit2/Response;", "likeVideo", "postVideos", "context", "Landroid/content/Context;", "title", "description", "video_file", "Landroid/net/Uri;", "thamnail", "app_debug"})
public final class VideoViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.practice.api.dataclass.video.UploadVideosItem>> _videoList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.practice.api.dataclass.video.UploadVideosItem>> videoList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.practice.api.dataclass.video.FavoriteVideosItem>> _favoriteVideoList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.practice.api.dataclass.video.FavoriteVideosItem>> favoriteVideoList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.practice.api.dataclass.likedislike.LikeStatusResponse> _likeStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.practice.api.dataclass.likedislike.LikeStatusResponse> likeStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.practice.api.dataclass.likedislike.DislikeStatusResponse> _dislikeStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.practice.api.dataclass.likedislike.DislikeStatusResponse> dislikeStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.practice.viewmodel.AuthViewModel authViewModel = null;
    
    public VideoViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.practice.api.dataclass.video.UploadVideosItem>> getVideoList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.practice.api.dataclass.video.FavoriteVideosItem>> getFavoriteVideoList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.practice.api.dataclass.likedislike.LikeStatusResponse> getLikeStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.practice.api.dataclass.likedislike.DislikeStatusResponse> getDislikeStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.practice.viewmodel.AuthViewModel getAuthViewModel() {
        return null;
    }
    
    public final void postVideos(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    android.net.Uri video_file, @org.jetbrains.annotations.Nullable()
    android.net.Uri thamnail, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    private final <T extends java.lang.Object>void handleApiResponse(retrofit2.Response<T> response, kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void fetchVideos() {
    }
    
    public final void fetchFavoriteVideos(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    public final void getFavoriteVideos(int videoId, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void likeVideo(int videoId, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void dislikeVideo(int videoId, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void deleteVideo(int videoId, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    public final void getLikeStatus(int videoId, @org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    public final void getDislikeStatus(int videoId, @org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
}