package com.example.memomate.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memomate.repository.NotesRepository
import com.example.memomate.room.Notes
import com.example.memomate.room.NotesDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NotesViewModel : ViewModel() {

    private val dao = NotesDatabase.getDatabase().notesDao()
    private val notesRepo = NotesRepository(dao)

    private val _currentNote = MutableStateFlow<Notes?>(null)
    val currentNote: StateFlow<Notes?> = _currentNote


    fun createNote(note: Notes) = viewModelScope.launch {
        notesRepo.createNote(note)
    }

    val getNotes = flow {
        val notesList = notesRepo.getAllNotes()
        emit(notesList)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun getNoteById(id: Int) = viewModelScope.launch {
        notesRepo.getNoteById(id).collect {
            _currentNote.value = it
        }
    }
}