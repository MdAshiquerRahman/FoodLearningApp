package com.example.practice.screen

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.practice.R
import com.example.practice.viewmodel.VideoViewModel


@Composable
fun PostScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: VideoViewModel = viewModel()
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var selectedVideoUri by remember { mutableStateOf<Uri?>(null) }
    var selectedThumbnailUri by remember { mutableStateOf<Uri?>(null) }

    val context = LocalContext.current
    val token = viewModel.authViewModel.getToken(context)
    val focusManager = LocalFocusManager.current

    val isUploading by viewModel.isLoading.observeAsState(false) // Manage upload and fetch state

    val videoPickerLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        selectedVideoUri = uri
    }
    val thumbnailPickerLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        selectedThumbnailUri = uri
    }

    var isSearching by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CustomTopBar(
                isSearching = isSearching,
                searchQuery = searchQuery,
                onSearchQueryChange = { searchQuery = it },
                onBackClick = { navController.popBackStack() },
                onSearchClick = { isSearching = true },
                title = "Post Video",
                onCloseClick = {
                    isSearching = false
                    searchQuery = ""
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                // Screen Title
                Text(
                    text = "Create a Post",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Title Field
                TitleField(
                    context = context,
                    description = title,
                    onValueChange = { title = it }
                )

                // Description Field
                DescriptionField(
                    context = LocalContext.current,
                    description = description,
                    onValueChange = { description = it },
                )

                Spacer(modifier = Modifier.height(8.dp))

                // File Picker Section
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Video Picker
                    IconButton(
                        onClick = { videoPickerLauncher.launch("video/*")
                                    focusManager.clearFocus()
                                  },
                        modifier = Modifier.size(64.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_movie),
                            contentDescription = "Select Video",
                            tint = Color.Blue,
                            modifier = Modifier.size(48.dp)
                        )
                    }

                    // Thumbnail Picker
                    IconButton(
                        onClick = { thumbnailPickerLauncher.launch("image/*") },
                        modifier = Modifier.size(64.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_image),
                            contentDescription = "Select Thumbnail",
                            tint = Color.Green,
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }

                // Display Selected Files
                selectedVideoUri?.let {
                    Text(
                        text = "Selected Video: ${it.lastPathSegment}",
                        style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
                selectedThumbnailUri?.let {
                    Text(
                        text = "Selected Thumbnail: ${it.lastPathSegment}",
                        style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Post Button
                Button(
                    onClick = {
                        if (title.isNotEmpty() && description.isNotEmpty() &&
                            selectedVideoUri != null && selectedThumbnailUri != null
                        ) {
                            viewModel.postVideos(
                                context = context,
                                token = token.toString(),
                                title = title,
                                description = description,
                                video_file = selectedVideoUri,
                                thamnail = selectedThumbnailUri
                            )
                        } else {
                            Toast.makeText(context, "All fields are required!", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    enabled = !isUploading // Disable button during upload and fetch process
                ) {
                    if (isUploading) {
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier.size(24.dp) // Small indicator inside button
                        )
                    } else {
                        Text(text = "Post", fontSize = 18.sp)
                    }
                }
            }
        }
    }
}



@Composable
fun DescriptionField(context: Context, description: String, onValueChange: (String) -> Unit) {
    var isError by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = description,
        onValueChange = {
            if (it.length <= 3000) {
                onValueChange(it)
                isError = it.lines().size > 30
            } else {
                Toast.makeText(context, "Description cannot exceed 300 characters", Toast.LENGTH_SHORT).show()
                isError = true
            }
        },
        maxLines = 3,
        label = { Text("Description") },
        modifier = Modifier.fillMaxWidth(),
        isError = isError,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = if (isError) Color.Red else Color.Blue,
            unfocusedIndicatorColor = if (isError) Color.Red else Color.Gray,
        )
    )
}

@Composable
fun TitleField(context: Context, description: String, onValueChange: (String) -> Unit) {
    var isError by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = description,
        onValueChange = {
            if (it.length <= 25) {
                onValueChange(it)
                isError = it.lines().size > 1
            } else {
                Toast.makeText(context, "Title cannot exceed 25 characters", Toast.LENGTH_SHORT).show()
                isError = true
            }
        },
        maxLines = 1,
        label = { Text("Title") },
        modifier = Modifier.fillMaxWidth(),
        isError = isError,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = if (isError) Color.Red else Color.Blue,
            unfocusedIndicatorColor = if (isError) Color.Red else Color.Gray,
        )
    )
}


