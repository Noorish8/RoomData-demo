package com.example.roomdata

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
     private val repository:NoteRepository = TODO()
    val allNotes: LiveData<List<Note>> = TODO()
    init {
        val dao=NoteDataBase.getDatabase(application).getNoteDao()
       val  repository =NoteRepository(dao)
        allNotes =repository.allNotes
    }
    //coroutine bacgroung thread
    fun deleteNote(note: Note)=viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }
    fun insertNote(note: Note)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }
}