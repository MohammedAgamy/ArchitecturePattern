package com.example.domain

import com.example.data.model.NoteModel
import com.example.data.repo.RepoNote
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(private val repoNote: RepoNote) {
    suspend operator fun invoke(): List<NoteModel> {
        return repoNote.showAll()
    }
}