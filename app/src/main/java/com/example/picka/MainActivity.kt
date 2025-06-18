package com.example.picka

import AppContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.picka.controller.FolderController
import com.example.picka.controller.NoteController
import com.example.picka.ui.theme.PickaTheme

class MainActivity : ComponentActivity() {
    private val noteController = NoteController() // Inisialisasi langsung NoteController
    private val folderController: FolderController by viewModels() // Inisialisasi FolderController sebagai ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PickaTheme {
                AppContent(
                    noteController = noteController,
                    folderController = folderController
                )
            }
        }
    }
}