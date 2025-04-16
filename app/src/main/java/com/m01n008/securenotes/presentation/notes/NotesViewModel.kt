package com.m01n008.securenotes.presentation.notes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NotesViewModel: ViewModel() {
    private val _state = MutableStateFlow(NotesState())
    val state: StateFlow<NotesState> = _state

    fun dispatch(intent: NotesIntent){
        val newState = reduceNote(intent, _state.value)
        _state.value = newState
    }
}