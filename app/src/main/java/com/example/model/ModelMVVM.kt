package com.example.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.NoteModel
import com.example.useCase.AddNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ModelMVVM @Inject constructor(private val addUseCase: AddNoteUseCase) : ViewModel() {


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
}

