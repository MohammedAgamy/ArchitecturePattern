package com.example.event

import com.example.data.model.NoteModel

data class NoteState(
    val isLoading: Boolean = false,
    var notes: List<NoteModel> = emptyList(),
    val error: String? = null
)