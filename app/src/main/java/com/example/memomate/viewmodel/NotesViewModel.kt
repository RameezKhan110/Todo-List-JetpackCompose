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

    var noteObj: Notes? = null
    val allNotes: List<Notes>? = null

    private val _currentNote = MutableStateFlow<Notes?>(null)
    val currentNote: StateFlow<Notes?> = _currentNote

    private val _getNotes = MutableStateFlow<List<Notes?>>(emptyList())
    val getNotes: StateFlow<List<Notes?>> = _getNotes


    fun createNote(note: Notes) = viewModelScope.launch {
        notesRepo.createNote(note)
    }

    fun getAllNotes() = viewModelScope.launch {
        _getNotes.value = notesRepo.getAllNotes()
    }
//    val getNotes = flow {
//        val notesList = notesRepo.getAllNotes()
//        emit(notesList)
//    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun getNoteById(id: Int) = viewModelScope.launch {
        notesRepo.getNoteById(id).collect {
            _currentNote.value = it
        }
    }

    fun updateNote(note: Notes) = viewModelScope.launch {
        notesRepo.updateNote(note)
    }

    fun deleteNote(note: Notes) = viewModelScope.launch {
        notesRepo.deleteNote(note)
    }
}