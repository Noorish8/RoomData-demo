package com.example.roomdata

import androidx.lifecycle.LiveData

class NoteRepository (private val noteDao:NoteDao) {

    val allNotes: List<Note> =noteDao.getAllNotes()
    suspend fun insert(note:Note){
        noteDao.insert(note)
    }
    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
}