package com.example.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewmodel(application: Application) : AndroidViewModel(application)
{
val data:LiveData<List<Notes>>
val repo:noterepository
init{
    val dao=NotesDatabase.getDatabase(application).notesDao()
      repo=noterepository(dao)
      data=repo.allnotes
}
    fun delete(note:Notes)=viewModelScope.launch(Dispatchers.IO){
        repo.delete(note)
    }
    fun insert(note: Notes)=viewModelScope.launch(Dispatchers.IO) {
        repo.insert(note)
    }



}