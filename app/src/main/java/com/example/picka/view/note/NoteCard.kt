package com.example.picka.view.note

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.picka.model.Note
import com.example.picka.ui.theme.PickaTheme

@Composable
fun NoteCard(note: Note, onClick: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD9D9D9)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(note.title, style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(4.dp))
            Text(note.content, maxLines = 3, overflow = TextOverflow.Ellipsis)
            Spacer(Modifier.height(6.dp))
            Text(note.date, fontSize = 10.sp, color = Color.Gray)
            Spacer(Modifier.height(6.dp))
            Button(onClick = onDelete, modifier = Modifier.align(Alignment.End)) {
                Text("Delete")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteCardPreview() {
    PickaTheme {
        NoteCard(
            note = Note(1, "Contoh Judul", "Isi catatan contoh yang panjang biar keliatan...", "15/06/2025"),
            onClick = {},
            onDelete = {}
        )
    }
}