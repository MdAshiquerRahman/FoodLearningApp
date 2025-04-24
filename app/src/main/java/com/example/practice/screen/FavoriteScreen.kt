package com.example.practice.screen

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.pages.post.RecipePostsCard
import com.example.practice.viewmodel.AuthViewModel
import com.example.practice.viewmodel.VideoViewModel


@Composable
fun FavoriteScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel,
    context: Context
) {
    val videoViewModel: VideoViewModel = viewModel()
    val isLoading = videoViewModel.isLoading.observeAsState(false)
    val errorMessage = videoViewModel.errorMessage.observeAsState(null)

    var isSearching by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    var showVideoTutorials by remember { mutableStateOf(false) }

    // Fetch videos after login status is confirmed
    LaunchedEffect(Unit) {
        videoViewModel.fetchFavoriteVideos(token = viewModel.getToken(context).toString())
    }

    Scaffold(
        topBar = {
            CustomTopBar(
                isSearching = isSearching,
                searchQuery = searchQuery,
                onSearchQueryChange = { searchQuery = it },
                onBackClick = { navController.popBackStack() },
                onSearchClick = {
                    isSearching = true
                    showVideoTutorials = true
                },
                title = "Favorite",
                onCloseClick = {
                    isSearching = false
                    searchQuery = ""
                }
            )
        }
    ) { innerPadding ->
        if (isLoading.value) {
            // Center the CircularProgressIndicator on the screen
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (!errorMessage.value.isNullOrEmpty()) {
            Text(text = "Error: ${errorMessage.value}")
        } else {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding),
            ) {
                FavoriteVideoTutorials(navController, modifier, videoViewModel, true)
            }
        }
    }
}

@Composable
fun FavoriteVideoTutorials(
    navController: NavController,
    modifier: Modifier = Modifier,
    videoViewModel: VideoViewModel,
    dialog: Boolean
) {
    val videoList = videoViewModel.favoriteVideoList.observeAsState(emptyList())
    val isLoading = videoViewModel.isLoading.observeAsState(false)
    val showDialog = remember { mutableStateOf(false) }

    // State to track if loading has been attempted
    var hasAttemptedLoad by remember { mutableStateOf(false) }

    // Only set hasAttemptedLoad to true after loading completes at least once
    if (!isLoading.value && videoList.value.isNotEmpty() && !hasAttemptedLoad) {
        hasAttemptedLoad = true
    }

    // Show AlertDialog only when loading has been attempted and the video list is empty
    if (hasAttemptedLoad && videoList.value.isEmpty() && dialog) {
        showDialog.value = true
    }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("No Favorite Videos") },
            text = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("No videos found. Explore videos to get started!")
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Warning Icon",
                        modifier = modifier.size(50.dp)
                    )
                }
            },
            confirmButton = {
                Button(onClick = {
                    showDialog.value = false
                    navController.navigate("home") // Navigate to home screen
                }) {
                    Text("Explore Videos")
                }
            }
        )
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(videoList.value) { video ->
            Box(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            ) {
                RecipePostsCard(
                    navController = navController,
                    title = video.title,
                    description = video.description,
                    author = video.uploaded_by.toString(),
                    totalLikes = video.total_likes,
                    totalDislikes = video.total_dislikes,
                    videoUrl = video.video_file,
                    videoId = video.id,
                    thumbnailUrl = video.thamnail,
                    isFavorite = true
                )
            }
        }
    }
}