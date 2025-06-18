import androidx.compose.runtime.*
import androidx.navigation.*
import androidx.navigation.compose.*
import com.example.picka.controller.FolderController
import com.example.picka.controller.NoteController
import com.example.picka.model.Note
import com.example.picka.view.folder.FolderScreen
import com.example.picka.view.note.MainScreen
import com.example.picka.view.note.AddEditNoteScreen

@Composable
fun AppContent(
    noteController: NoteController,
    folderController: FolderController
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "folders") {

        composable("folders") {
            FolderScreen(
                controller = folderController,
                navController = navController,
                onFolderClick = {
                    navController.navigate("notes")
                }
            )
        }

        composable("notes") {
            MainScreen(
                noteController = noteController,
                navController = navController,
                onEditNote = { note ->
                    navController.navigate("editNote/${note.id}")
                }
            )
        }

        composable(
            "editNote/{noteId}",
            arguments = listOf(navArgument("noteId") { type = NavType.IntType })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt("noteId") ?: 0
            val note = noteController.notes.find { it.id == noteId } ?: Note(0, "", "", "")

            AddEditNoteScreen(
                note = note,
                onSave = {
                    if (it.id == 0) noteController.addNote(it) else noteController.updateNote(it)
                    navController.popBackStack()
                },
                onCancel = {
                    navController.popBackStack()
                }
            )
        }
    }
}
