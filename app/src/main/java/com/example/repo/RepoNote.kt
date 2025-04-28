package com.example.repo

import com.example.data.NoteModel

interface RepoNote {
    suspend fun add(noteModel: NoteModel)
    suspend fun delete(notId: Int)
    suspend fun showAll(): List<NoteModel>
}