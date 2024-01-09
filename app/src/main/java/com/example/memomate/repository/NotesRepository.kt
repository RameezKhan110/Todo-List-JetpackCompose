package com.example.memomate.repository

import com.example.memomate.room.Notes
import com.example.memomate.room.NotesDao

class NotesRepository(private val notesDao: NotesDao) {
    suspend fun createNote(note: Notes) {
        notesDao.createNote(notes = note)
    }
}