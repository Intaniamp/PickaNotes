package com.example.picka.view.note

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.picka.model.Note

@Composable
fun NoteList(notes: List<Note>, onClick: (Note) -> Unit, onDelete: (Note) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(notes) { note ->
            NoteItem(note = note, onClick = { onClick(note) }, onDelete = { onDelete(note) })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteListPreview() {
    val sampleNotes = listOf(
        Note(1, "Judul 1", "Isi catatan pertama", "15/06/2025"),
        Note(2, "Judul 2", "Isi catatan kedua yang lebih panjang", "14/06/2025"),
        Note(3, "Judul 3", "Isi singkat", "13/06/2025")
    )

    NoteList(
        notes = sampleNotes,
        onClick = {},
        onDelete = {}
    )
}