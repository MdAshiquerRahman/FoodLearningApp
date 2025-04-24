package com.example.practice.screen



import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.pages.post.RecipePostsCard
import com.example.practice.viewmodel.AuthViewModel
import com.example.practice.viewmodel.VideoViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    videoViewModel: VideoViewModel,
    modifier: Modifier = Modifier,
) {
    val isLoading = videoViewModel.isLoading.observeAsState(false)
    val errorMessage = videoViewModel.errorMessage.observeAsState(null)
    val context = LocalContext.current

    var isSearching by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    var showVideoTutorials by remember { mutableStateOf(false) }

    // Fetch videos and favorites
    LaunchedEffect(Unit) {
        videoViewModel.fetchVideos()
        videoViewModel.fetchFavoriteVideos(token = videoViewModel.authViewModel.getToken(context).toString())
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Explore") },
                actions = {
                    if (isSearching) {
                        TextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            placeholder = { Text("Search...") },
                            singleLine = true,
                            trailingIcon = {
                                IconButton(onClick = {
                                    isSearching = false
                                    searchQuery = ""
                                }) {
                                    Icon(Icons.Default.Close, contentDescription = "Close")
                                }
                            }
                        )
                    } else {
                        IconButton(onClick = {
                            isSearching = true
                            showVideoTutorials = true // Trigger VideoTutorials on Search click
                        }) {
                            Icon(Icons.Default.Search, contentDescription = "Search")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when {
                isLoading.value -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                !errorMessage.value.isNullOrEmpty() -> {
                    Text(
                        text = "Error: ${errorMessage.value}",
                        modifier = Modifier.padding(16.dp),
                        color = MaterialTheme.colorScheme.error
                    )
                }
                else -> {
                        VideoTutorials(
                            navController = navController,
                            modifier = modifier,
                            videoViewModel = videoViewModel,
                            searchQuery = searchQuery
                        )
                    }
                }
            }
        }
    }


@Composable
fun VideoTutorials(
    navController: NavController,
    modifier: Modifier = Modifier,
    videoViewModel: VideoViewModel,
    searchQuery: String
) {
    val videoList = videoViewModel.videoList.observeAsState(emptyList())
    val isLoading = videoViewModel.isLoading.observeAsState(false)
    val favoriteVideoList = videoViewModel.favoriteVideoList.observeAsState(emptyList())
    val showDialog = remember { mutableStateOf(false) }

    // Filter videos based on search
    val filteredVideos = videoList.value.filter {
        it.title.contains(searchQuery, ignoreCase = true) || searchQuery.isBlank()
    }

    // Show empty state dialog if no videos
    LaunchedEffect(isLoading.value, videoList.value) {
        if (!isLoading.value && videoList.value.isEmpty()) {
            showDialog.value = true
        }
    }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("Database Empty") },
            text = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("No videos found. Post a video to get started!")
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Warning",
                        modifier = modifier.size(50.dp)
                    )
                }
            },
            confirmButton = {
                Button(onClick = {
                    showDialog.value = false
                    navController.navigate("post")
                }) {
                    Text("Go to Post Screen")
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
        items(filteredVideos) { video ->
            val isFavorite = favoriteVideoList.value.any { it.id == video.id }
            Box(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            ) {
                RecipePostsCard(
                    navController = navController,
                    title = video.title,
                    description = video.description,
                    author = video.uploaded_by ?: "Unknown",
                    totalLikes = video.total_likes,
                    totalDislikes = video.total_dislikes,
                    videoUrl = video.video_file,
                    videoId = video.id,
                    thumbnailUrl = video.thamnail,
                    isFavorite = isFavorite
                )
            }
        }
    }
}

