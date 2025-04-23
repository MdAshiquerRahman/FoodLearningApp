package com.example.practice.screen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a*\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001aH\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0007\u001a\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007\u001aH\u0010\u0014\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0007\u001a\u0018\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007\u001a\u0018\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u0006H\u0007\u001a\u0010\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0006H\u0007\u001ab\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020!2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000fH\u0007\u00a8\u0006&"}, d2 = {"CommentDialog", "", "onDismissRequest", "Lkotlin/Function0;", "onConfirmRequest", "Lkotlin/Function1;", "", "CommentSection", "videoViewModel", "Lcom/example/practice/viewmodel/VideoViewModel;", "title", "description", "videoFile", "thamnail", "totalLikes", "", "totalDislikes", "recipeId", "DescriptionTextWithDialog", "author", "LikeDislikeButtons", "video_file", "videoId", "initialLikes", "initialDislikes", "RecipeDescription", "RecipeTitle", "navController", "Landroidx/navigation/NavController;", "RecipeTutorial", "videoUrl", "TutorialScreen", "modifier", "Landroidx/compose/ui/Modifier;", "recipeTitle", "recipeDescription", "recipeUrl", "recipeThumbnail", "app_debug"})
public final class TurorialScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void RecipeTitle(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @androidx.compose.runtime.Composable()
    public static final void RecipeTutorial(@org.jetbrains.annotations.NotNull()
    java.lang.String videoUrl) {
    }
    
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @androidx.compose.runtime.Composable()
    public static final void CommentSection(@org.jetbrains.annotations.NotNull()
    com.example.practice.viewmodel.VideoViewModel videoViewModel, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String videoFile, @org.jetbrains.annotations.NotNull()
    java.lang.String thamnail, int totalLikes, int totalDislikes, int recipeId) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LikeDislikeButtons(@org.jetbrains.annotations.NotNull()
    com.example.practice.viewmodel.VideoViewModel videoViewModel, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String video_file, @org.jetbrains.annotations.NotNull()
    java.lang.String thamnail, int videoId, int initialLikes, int initialDislikes) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void RecipeDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String description) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DescriptionTextWithDialog(@org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String description) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CommentDialog(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissRequest, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onConfirmRequest) {
    }
    
    @androidx.annotation.OptIn(markerClass = {androidx.media3.common.util.UnstableApi.class})
    @androidx.compose.runtime.Composable()
    public static final void TutorialScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.example.practice.viewmodel.VideoViewModel videoViewModel, @org.jetbrains.annotations.NotNull()
    java.lang.String recipeTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String recipeDescription, @org.jetbrains.annotations.NotNull()
    java.lang.String author, int totalLikes, int totalDislikes, @org.jetbrains.annotations.NotNull()
    java.lang.String recipeUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String recipeThumbnail, int recipeId) {
    }
}