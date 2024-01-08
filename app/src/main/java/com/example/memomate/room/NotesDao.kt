package com.example.memomate.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {
    @Insert
    fun createNote(notes: Notes)

    @Query("SELECT * From Notes")
    fun getAllNotes(): List<Notes>

    @Update
    fun updateNote(note: Notes)

    @Delete
    fun deleteNote(note: Notes)
}