package com.example.domain

import com.example.data.model.NoteModel
import com.example.data.repo.RepoNote
import javax.inject.Inject
// using RepoNote not impL
class AddNoteUseCase @Inject constructor(
    private val repoNote: RepoNote
) {
        suspend operator fun invoke(noteModel: NoteModel){
            repoNote.add(noteModel)
        }

}