package com.example.event

import com.example.data.NoteModel

sealed class IntentEvent {
    data class AddName(val dataName: NoteModel) : IntentEvent()
}