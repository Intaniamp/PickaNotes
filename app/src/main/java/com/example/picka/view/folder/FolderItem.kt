package com.example.picka.view.folder

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.picka.model.Folder

@Composable
fun FolderItem(folder: Folder, onClick: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(folder.name, style = MaterialTheme.typography.titleMedium)
            Text(
                text = "Delete",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.clickable { onDelete() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFolderItem() {
    FolderItem(
        folder = Folder(name = "Folder Example", id = 0), // Menambahkan id di sini
        onClick = {},
        onDelete = {}
    )
}