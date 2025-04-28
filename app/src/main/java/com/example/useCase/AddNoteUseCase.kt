package com.example.useCase

import com.example.data.NoteModel
import com.example.repo.RepoNote
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val repoNote: RepoNote
) {
        suspend operator fun invoke(noteModel: NoteModel){
            repoNote.add(noteModel)
        }
}