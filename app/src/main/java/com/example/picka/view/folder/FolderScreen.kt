package com.example.picka.view.folder

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.picka.controller.FolderController
import com.example.picka.model.Folder

@Composable
fun FolderScreen(
    controller: FolderController,
    onFolderClick: (Folder) -> Unit,
    navController: NavController
) {
    var searchQuery by remember { mutableStateOf("") }
    val folders = controller.searchFolders(searchQuery)

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                controller.addFolder(Folder(0, "Folder Baru"))
            }) {
                Text("+")
            }
        }
    ) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .padding(16.dp)) {

            Text("Daftar Folder", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Cari folder...") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            folders.forEach { folder ->
                FolderItem(
                    folder = folder,
                    onClick = { onFolderClick(folder) },
                    onDelete = { controller.deleteFolder(folder) }
                )
            }
        }
    }
}

// Dummy implementation of FolderController for preview purposes
class FakeFolderController : FolderController() {
    // Override searchFolders untuk memberikan data dummy
    override fun searchFolders(query: String): List<Folder> {
        return listOf(
            Folder(id = 1, name = "Folder 1"),
            Folder(id = 2, name = "Folder 2"),
            Folder(id = 3, name = "Folder 3")
        )
    }

    // Override addFolder, updateFolder, and deleteFolder if needed for testing
    override fun addFolder(folder: Folder) {
        // Implementasi dummy
    }

    override fun updateFolder(folder: Folder) {
        // Implementasi dummy
    }

    override fun deleteFolder(folder: Folder) {
        // Implementasi dummy
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFolderScreen() {
    val navController = rememberNavController()
    val fakeController = remember { FakeFolderController() }

    FolderScreen(
        controller = fakeController,
        onFolderClick = {},
        navController = navController
    )
}