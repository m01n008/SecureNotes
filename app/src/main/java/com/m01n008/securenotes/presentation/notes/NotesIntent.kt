package com.m01n008.securenotes.presentation.notes

sealed class NotesIntent {
    data class AddNote(val heading: String, val body: String): NotesIntent()
    data class DeleteNote(val note: Note): NotesIntent()
    data class EncryptNote(val note: Note): NotesIntent()
    data class DecryptNote(val note: Note): NotesIntent()
    object LockApp: NotesIntent()
    object UnlockApp: NotesIntent()
    object getAllNotes: NotesIntent()

}