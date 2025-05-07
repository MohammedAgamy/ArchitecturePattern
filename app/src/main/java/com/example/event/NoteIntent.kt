package com.example.event

import com.example.data.model.NoteModel

sealed class NoteIntent {
    data class AddName(val noteModel: NoteModel) : NoteIntent()
    data object LoadNotes : NoteIntent()
}