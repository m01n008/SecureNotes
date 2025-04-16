package com.m01n008.securenotes.presentation.notes

data class NotesState(
    val notesList: List<Note> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val isLocked: Boolean = false
)
