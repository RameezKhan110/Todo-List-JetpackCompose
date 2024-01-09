package com.example.memomate.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {
    @Insert
    suspend fun createNote(notes: Notes)

    @Query("SELECT * From Notes")
    fun getAllNotes(): LiveData<List<Notes>>

    @Update
    suspend fun updateNote(note: Notes)

    @Delete
    suspend fun deleteNote(note: Notes)
}