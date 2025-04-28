package com.example.event

import com.example.data.model.NoteModel

sealed class IntentEvent {
    data class AddName(val dataName: NoteModel) : IntentEvent()
}