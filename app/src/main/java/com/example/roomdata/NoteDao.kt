package com.example.roomdata

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insert(note: Note)

    @Delete
    suspend fun delete (note: Note)

    @Query("Select * from note_table oder by id Asc")
    fun getAllNotes():List<Note>
}