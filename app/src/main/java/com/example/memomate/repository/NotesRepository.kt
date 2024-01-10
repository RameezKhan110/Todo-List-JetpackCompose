package com.example.memomate.repository

import androidx.lifecycle.LiveData
import com.example.memomate.room.Notes
import com.example.memomate.room.NotesDao
import kotlinx.coroutines.flow.Flow

class NotesRepository(private val notesDao: NotesDao) {
    suspend fun createNote(note: Notes) {
        notesDao.createNote(notes = note)
    }

    suspend fun getAllNotes(): List<Notes> {
        return notesDao.getAllNotes()
    }

    fun getNoteById(id: Int): Flow<Notes> {
        return notesDao.getNoteById(id)
    }

    suspend fun updateNote(note: Notes) {
        return notesDao.updateNote(note)
    }

    suspend fun deleteNote(note: Notes) {
        return notesDao.deleteNote(note)
    }
}