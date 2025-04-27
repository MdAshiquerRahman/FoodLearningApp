package com.example.practice.api.dataclass.history

data class Video(
    val description: String,
    val id: Int,
    val is_favorited: Boolean,
    val thamnail: String,
    val title: String,
    val total_dislikes: Int,
    val total_likes: Int,
    val uploaded_at: String,
    val uploaded_by: String,
    val video_file: String
)