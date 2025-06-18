package com.example.picka.controller

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.picka.model.Folder

open class FolderController : ViewModel() {
    private val _folders = mutableStateListOf<Folder>()
    val folders: List<Folder> = _folders

    init {
        _folders.addAll(
            listOf(
                Folder(1, "STUDIEEES"),
            )
        )
    }

    open fun addFolder(folder: Folder) {
        val id = (_folders.maxOfOrNull { it.id } ?: 0) + 1
        _folders.add(folder.copy(id = id))
    }

    open fun updateFolder(folder: Folder) {
        val index = _folders.indexOfFirst { it.id == folder.id }
        if (index != -1) _folders[index] = folder
    }

    open fun deleteFolder(folder: Folder) {
        _folders.removeAll { it.id == folder.id }
    }

    open fun searchFolders(query: String): List<Folder> {
        return _folders.filter { it.name.contains(query, ignoreCase = true) }
    }
}