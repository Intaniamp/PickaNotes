package com.example.picka.view.note

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.picka.model.Note
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement


@Composable
fun NoteItem(note: Note, onClick: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF2D9C1))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(note.title, style = MaterialTheme.typography.titleMedium, maxLines = 1)
            Spacer(modifier = Modifier.height(4.dp))

            if (note.content.isNotEmpty()) {
                Text(note.content, style = MaterialTheme.typography.bodySmall, maxLines = 3)
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text(note.date, style = MaterialTheme.typography.labelSmall)

            // Spacer tambahan agar delete di bawah
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Delete",
                    color = Color.Red,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier
                        .clickable(onClick = onDelete)
                        .padding(top = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteItemPreview() {
    val sampleNote = Note(
        id = 1,
        title = "Contoh Judul",
        content = "Ini isi catatan yang cukup panjang agar terlihat bagaimana teks ditampilkan di komponen ini.",
        date = "15/06/2025"
    )

    NoteItem(
        note = sampleNote,
        onClick = {},
        onDelete = {}
    )
}