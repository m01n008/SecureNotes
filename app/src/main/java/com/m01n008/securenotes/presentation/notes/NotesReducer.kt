package com.m01n008.securenotes.presentation.notes

fun reduceNote(intent: NotesIntent, state: NotesState): NotesState{
    return when (intent){
        is NotesIntent.AddNote -> {
         if (state.notesList.isEmpty()){
            state.copy(notesList = listOf(Note(intent.heading, intent.body)))
         }
         else{
             state.copy(notesList = state.notesList + Note(intent.heading, intent.body))
         }
          state.copy(error = "Error adding notes")
        }
        is NotesIntent.DeleteNote -> TODO()
        is NotesIntent.EncryptNote -> TODO()
        is NotesIntent.DecryptNote -> TODO()
        is NotesIntent.LockApp -> TODO()
        is NotesIntent.UnlockApp -> TODO()
        NotesIntent.getAllNotes -> {
            state.copy(notesList = state.notesList)
        }
    }
}