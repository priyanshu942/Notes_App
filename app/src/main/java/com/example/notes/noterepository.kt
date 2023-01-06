package com.example.notes

import androidx.lifecycle.LiveData

class noterepository(private val noteDAO: NoteDAO) {
    val allnotes :LiveData<List<Notes>> = noteDAO.fetchall()

    suspend fun  insert(note:Notes){
        noteDAO.insert(note)
    }
    suspend fun delete(note: Notes)
    {
        noteDAO.delete(note)
    }
}
