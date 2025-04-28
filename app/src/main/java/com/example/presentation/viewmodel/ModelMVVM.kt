package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.NoteModel
import com.example.domain.AddNoteUseCase
import com.example.domain.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ModelMVVM @Inject constructor(
    private val addUseCase: AddNoteUseCase, private val getAllNotesUseCase: GetAllNotesUseCase
) : ViewModel() {


    private val _addNoteState = MutableStateFlow<List<NoteModel>>(emptyList())
    val addNoteState: StateFlow<List<NoteModel>> = _addNoteState


    fun addNote(noteModel: NoteModel) {
        viewModelScope.launch {
            try {
                addUseCase(noteModel)
                _addNoteState.value += noteModel
            } catch (e: Exception) {
                _addNoteState.value += noteModel
            }
        }
    }


    fun getAllNote() {
        viewModelScope.launch {
            _addNoteState.value = getAllNotesUseCase()
        }
    }
}

