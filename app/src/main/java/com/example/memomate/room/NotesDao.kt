package com.example.memomate.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    @Insert
    suspend fun createNote(notes: Notes)

    @Query("SELECT * From Notes")
    suspend fun getAllNotes(): List<Notes>

    @Update
    suspend fun updateNote(note: Notes)

    @Delete
    suspend fun deleteNote(note: Notes)

    @Query("SELECT * FROM Notes WHERE id = :id")
    fun getNoteById(id: Int): Flow<Notes>
}