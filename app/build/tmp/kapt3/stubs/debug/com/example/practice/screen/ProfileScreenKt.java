package com.example.practice.screen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u0016\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0006H\u0007\u001a\b\u0010\f\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0006H\u0007\u001a \u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0003\u001a\"\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007\u001a\"\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007\u001a\u0018\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0007\u001a2\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012H\u0007\u001a(\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u001bH\u0007\u001a\u001e\u0010\"\u001a\u00020\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u0015\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)H\u0007\u00a2\u0006\u0002\u0010*\u00a8\u0006+"}, d2 = {"AllText", "", "text", "", "Collects", "collects", "", "DrawerContent", "onLogoutClick", "Lkotlin/Function0;", "Fans", "fans", "FillTheProfile", "Following", "following", "FollowingFansCollects", "History", "navController", "Landroidx/navigation/NavController;", "userName", "viewModel", "Lcom/example/practice/viewmodel/VideoViewModel;", "Post", "PostCollectsHistoryButton", "ProfileScreen", "modifier", "Landroidx/compose/ui/Modifier;", "Lcom/example/practice/viewmodel/AuthViewModel;", "context", "Landroid/content/Context;", "parentNavController", "UserNamePart", "userEmail", "userProfile", "WatchHistoryScreen", "watchHistory", "", "Lcom/example/practice/api/dataclass/history/HistoryItem;", "screenRatioFontSize", "Landroidx/compose/ui/unit/TextUnit;", "font", "", "(F)J", "app_debug"})
public final class ProfileScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @androidx.compose.runtime.Composable()
    public static final void ProfileScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.example.practice.viewmodel.AuthViewModel viewModel, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController parentNavController) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DrawerContent(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLogoutClick) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @androidx.compose.runtime.Composable()
    public static final void UserNamePart(@org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String userEmail, @org.jetbrains.annotations.NotNull()
    java.lang.String userProfile, @org.jetbrains.annotations.NotNull()
    com.example.practice.viewmodel.AuthViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void FollowingFansCollects(int following, int fans, int collects) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void Following(int following) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void Fans(int fans) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void Collects(int collects) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AllText(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void FillTheProfile() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PostCollectsHistoryButton(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    java.lang.String userName) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void Post(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    com.example.practice.viewmodel.VideoViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void WatchHistoryScreen(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.practice.api.dataclass.history.HistoryItem> watchHistory, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void History(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    com.example.practice.viewmodel.VideoViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final long screenRatioFontSize(float font) {
        return 0L;
    }
}