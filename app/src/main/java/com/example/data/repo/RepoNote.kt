package com.example.data.repo

import com.example.data.model.NoteModel

interface RepoNote {
    suspend fun add(noteModel: NoteModel)
    suspend fun delete(notId: Int)
    suspend fun showAll(): List<NoteModel>
}