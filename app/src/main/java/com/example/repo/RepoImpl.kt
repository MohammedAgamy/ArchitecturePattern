package com.example.repo

import com.example.data.NoteModel
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepoImpl @Inject constructor():RepoNote {

    private val notes = mutableListOf<NoteModel>()

    override suspend fun add(noteModel: NoteModel) {
        notes.add(noteModel)
    }

    override suspend fun delete(notId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun showAll(): List<NoteModel> {
        TODO("Not yet implemented")
    }
}