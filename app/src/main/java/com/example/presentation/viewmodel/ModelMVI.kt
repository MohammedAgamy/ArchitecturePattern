package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.NoteModel
import com.example.domain.AddNoteUseCase
import com.example.domain.GetAllNotesUseCase
import com.example.event.NoteIntent
import com.example.event.NoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ModelMVI @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase, private val getAllNotesUseCase: GetAllNotesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(NoteState())
    val state: StateFlow<NoteState> = _state

    fun processIntent(noteIntent: NoteIntent) {
        when (noteIntent) {
            is NoteIntent.AddName -> addNote(noteIntent.noteModel)
            NoteIntent.LoadNotes -> getAllNoteMVI()
        }
    }

    private fun addNote(noteModel: NoteModel) {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                isLoading = true
            )

            try {
                addNoteUseCase(noteModel)
                val updatedList = _state.value.notes + noteModel
                _state.value = NoteState(notes = updatedList)

            } catch (e: Exception) {
                _state.value = _state.value.copy(error = "Failed to add note")
            }
        }
    }

    fun getAllNoteMVI() {
        viewModelScope.launch {
            _state.value.notes = getAllNotesUseCase()
        }
    }
}