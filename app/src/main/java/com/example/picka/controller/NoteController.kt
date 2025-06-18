package com.example.picka.controller

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.picka.model.Note

open class NoteController : ViewModel() {
    protected val _notes = mutableStateListOf<Note>()
    val notes: List<Note> = _notes

    // Data default
    init {
        _notes.addAll(
            listOf(
                Note(1, "Rekayasa Perangkat Lunak", "Lorem ipsum is placeholder text...", "24/02/2025"),
                Note(2, "Pemrograman Seluler", "Lorem ipsum is placeholder text...", "25/02/2025"),
                Note(3, "Praktik Profesional Global", "Lorem ipsum is placeholder text...", "26/02/2025"),
                Note(4, "Internet Of Things", "Lorem ipsum is placeholder text...", "27/02/2025"),
                Note(5, "TASKK", "Lorem ipsum is placeholder text...", "01/03/2025"),
                Note(6, "Another", "Fooooddd", "03/03/2025")
            )
        )
    }

    fun addNote(note: Note) {
        val id = (_notes.maxOfOrNull { it.id } ?: 0) + 1
        _notes.add(note.copy(id = id))
    }

    fun updateNote(note: Note) {
        val index = _notes.indexOfFirst { it.id == note.id }
        if (index != -1) _notes[index] = note
    }

    fun deleteNote(note: Note) {
        _notes.removeAll { it.id == note.id }
    }

    fun getNoteById(id: Int): Note? = _notes.find { it.id == id }

    companion object {
        // Untuk preview
        fun previewController(): NoteController {
            val controller = NoteController()
            controller._notes.addAll(
                listOf(
                    Note(1, "Judul Preview 1", "Isi Preview 1", "15/06/2025"),
                    Note(2, "Judul Preview 2", "Isi Preview 2", "15/06/2025")
                )
            )
            return controller
        }
    }
}