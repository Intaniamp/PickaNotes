package com.example.picka.view.note

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.picka.model.Note
import com.example.picka.controller.NoteController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack // Mengimpor ArrowBack dengan benar
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.ExperimentalMaterial3Api // Pastikan ini diimpor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    noteController: NoteController,
    onEditNote: (Note) -> Unit,
    navController: NavController
) {
    var searchQuery by remember { mutableStateOf("") }

    val filteredNotes = noteController.notes.filter {
        it.title.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "STUDIEEES") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { onEditNote(Note(id = 0, title = "", content = "", date = "")) }) {
                Text(text = "+")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Cari berdasarkan judul") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            NoteList(
                notes = filteredNotes,
                onClick = { onEditNote(it) },
                onDelete = { noteController.deleteNote(it) }
            )

            Text(
                text = "${filteredNotes.size} Notes",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    class DummyController : NoteController() {
        init {
            addNote(Note(id = 1, title = "Judul 1", content = "Isi catatan pertama", date = "15/06/2025"))
            addNote(Note(id = 2, title = "Judul 2", content = "Isi catatan kedua yang lebih panjang", date = "16/06/2025"))
        }
    }

    val dummyController = DummyController()

    // Ganti controller menjadi noteController
    MainScreen(
        noteController = dummyController, // Perbaiki nama parameter di sini
        onEditNote = {},
        navController = rememberNavController() // Menambahkan navController untuk preview
    )
}