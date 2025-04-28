package com.example.data.repo

import com.example.data.model.NoteModel
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepoImpl @Inject constructor(): RepoNote {


    // don't used repoNote in inject (Loop )
    // used instant from repoNote
    private val notes = mutableListOf<NoteModel>()

    override suspend fun add(noteModel: NoteModel) {
        notes.add(noteModel)
    }

    override suspend fun delete(notId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun showAll(): List<NoteModel> {
      return notes
    }
}