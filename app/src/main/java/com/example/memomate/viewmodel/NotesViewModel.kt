package com.example.memomate.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memomate.ApplicationClass
import com.example.memomate.repository.NotesRepository
import com.example.memomate.room.Notes
import com.example.memomate.room.NotesDatabase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NotesViewModel : ViewModel() {

    private val dao = NotesDatabase.getDatabase(ApplicationClass.getContext()).notesDao()
    private val notesRepo = NotesRepository(dao)

    fun createNote(note: Notes) = viewModelScope.launch {
        notesRepo.createNote(note)
    }

    val getNotes = flow<List<Notes>> {
        val notesList = notesRepo.getAllNotes()
        emit(notesList)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
}