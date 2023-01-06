package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insert(notes: Notes)

   @Delete
    suspend fun delete(notes: Notes)

    @Query("Select * from Notes_table order by id")
     fun fetchall():LiveData<List<Notes>>
}