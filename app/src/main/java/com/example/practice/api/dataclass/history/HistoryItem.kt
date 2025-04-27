package com.example.practice.api.dataclass.history

data class HistoryItem(
    val id: Int,
    val video: Video,
    val watched_at: String
)