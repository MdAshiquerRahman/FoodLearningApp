package com.example.practice.api.dataclass.likedislike

data class LikeStatusResponse(
    val liked: Boolean,
    val total_likes: Int
)

data class DislikeStatusResponse(
    val disliked: Boolean,
    val total_dislikes: Int
)

