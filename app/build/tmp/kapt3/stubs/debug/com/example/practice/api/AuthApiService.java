package com.example.practice.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0013J(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ$\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0013J(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\b\b\u0001\u0010 \u001a\u00020!H\u00a7@\u00a2\u0006\u0002\u0010\"J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0013J(\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ(\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\'\u001a\u00020(H\u00a7@\u00a2\u0006\u0002\u0010)J\u001e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010 \u001a\u00020+H\u00a7@\u00a2\u0006\u0002\u0010,JJ\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010.\u001a\u00020/2\b\b\u0001\u00100\u001a\u00020/2\n\b\u0003\u00101\u001a\u0004\u0018\u0001022\n\b\u0003\u00103\u001a\u0004\u0018\u00010/H\u00a7@\u00a2\u0006\u0002\u00104JJ\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u00107\u001a\u00020/2\b\b\u0001\u00108\u001a\u00020/2\n\b\u0001\u00109\u001a\u0004\u0018\u0001022\n\b\u0001\u0010:\u001a\u0004\u0018\u000102H\u00a7@\u00a2\u0006\u0002\u0010;J\u001e\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006="}, d2 = {"Lcom/example/practice/api/AuthApiService;", "", "addToHistory", "Lretrofit2/Response;", "", "token", "", "videoId", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteVideo", "dislikeVideo", "getComments", "Lcom/example/practice/api/dataclass/comment/Comments;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDislikeStatus", "Lcom/example/practice/api/dataclass/likedislike/DislikeStatusResponse;", "getFavorite", "Lcom/example/practice/api/dataclass/video/FavoriteVideos;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLikeStatus", "Lcom/example/practice/api/dataclass/likedislike/LikeStatusResponse;", "getUserInfo", "Lcom/example/practice/api/dataclass/profile/ProfileResponse;", "getVideos", "Lcom/example/practice/api/dataclass/video/UploadVideos;", "getWatchHistory", "", "Lcom/example/practice/api/dataclass/history/HistoryItem;", "likeVideo", "login", "Lcom/example/practice/api/dataclass/login/LoginResponse;", "request", "Lcom/example/practice/api/dataclass/login/LoginRequest;", "(Lcom/example/practice/api/dataclass/login/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "makeFavorite", "postComment", "Lcom/example/practice/api/dataclass/comment/CommentResponse;", "comment", "Lcom/example/practice/api/dataclass/comment/CommentRequest;", "(Ljava/lang/String;Lcom/example/practice/api/dataclass/comment/CommentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerUser", "Lcom/example/practice/api/dataclass/signup/SignUpRequest;", "(Lcom/example/practice/api/dataclass/signup/SignUpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserInfo", "username", "Lokhttp3/RequestBody;", "email", "profile_picture", "Lokhttp3/MultipartBody$Part;", "userId", "(Ljava/lang/String;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/MultipartBody$Part;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadVideo", "Lcom/example/practice/api/dataclass/video/UploadVideosItem;", "title", "description", "video", "thumbnail", "(Ljava/lang/String;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/MultipartBody$Part;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyToken", "app_debug"})
public abstract interface AuthApiService {
    
    @retrofit2.http.POST(value = "auth/registration/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object registerUser(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.practice.api.dataclass.signup.SignUpRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "auth/user/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object verifyToken(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.practice.api.dataclass.profile.ProfileResponse>> $completion);
    
    @retrofit2.http.POST(value = "auth/login/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.practice.api.dataclass.login.LoginRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.practice.api.dataclass.login.LoginResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/videos/upload-videos/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getVideos(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.practice.api.dataclass.video.UploadVideos>> $completion);
    
    @retrofit2.http.Multipart()
    @retrofit2.http.POST(value = "api/videos/upload-videos/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object uploadVideo(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Part(value = "title")
    @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody title, @retrofit2.http.Part(value = "description")
    @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody description, @retrofit2.http.Part()
    @org.jetbrains.annotations.Nullable()
    okhttp3.MultipartBody.Part video, @retrofit2.http.Part()
    @org.jetbrains.annotations.Nullable()
    okhttp3.MultipartBody.Part thumbnail, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.practice.api.dataclass.video.UploadVideosItem>> $completion);
    
    @retrofit2.http.POST(value = "api/videos/toggle-favorite/{video-id}/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object makeFavorite(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "video-id")
    int videoId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.POST(value = "api/videos/toggle-like/{video-id}/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object likeVideo(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "video-id")
    int videoId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.POST(value = "api/videos/add-to-history/{video-id}/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addToHistory(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "video-id")
    int videoId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "api/videos/watch-history/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getWatchHistory(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.example.practice.api.dataclass.history.HistoryItem>>> $completion);
    
    @retrofit2.http.POST(value = "api/videos/toggle-dislike/{video-id}/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object dislikeVideo(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "video-id")
    int videoId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.DELETE(value = "api/videos/upload-videos/{video-id}/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteVideo(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "video-id")
    int videoId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "api/videos/toggle-like/{video-id}/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLikeStatus(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "video-id")
    int videoId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.practice.api.dataclass.likedislike.LikeStatusResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/videos/toggle-dislike/{video-id}/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getDislikeStatus(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Path(value = "video-id")
    int videoId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.practice.api.dataclass.likedislike.DislikeStatusResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/videos/upload-videos/favorite-videos/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFavorite(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.practice.api.dataclass.video.FavoriteVideos>> $completion);
    
    @retrofit2.http.GET(value = "api/videos/video-comments/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getComments(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.practice.api.dataclass.comment.Comments>> $completion);
    
    @retrofit2.http.POST(value = "api/videos/video-comments/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object postComment(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.example.practice.api.dataclass.comment.CommentRequest comment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.practice.api.dataclass.comment.CommentResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/profile/update/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserInfo(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.practice.api.dataclass.profile.ProfileResponse> $completion);
    
    @retrofit2.http.Multipart()
    @retrofit2.http.PUT(value = "api/profile/update/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateUserInfo(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @retrofit2.http.Part(value = "username")
    @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody username, @retrofit2.http.Part(value = "email")
    @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody email, @retrofit2.http.Part()
    @org.jetbrains.annotations.Nullable()
    okhttp3.MultipartBody.Part profile_picture, @retrofit2.http.Part(value = "UserId")
    @org.jetbrains.annotations.Nullable()
    okhttp3.RequestBody userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.practice.api.dataclass.profile.ProfileResponse>> $completion);
    
    @retrofit2.http.POST(value = "auth/logout/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object logout(@retrofit2.http.Header(value = "Authorization")
    @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}