package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), clickHandler {
    lateinit var viewmodel: NoteViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleView.layoutManager=LinearLayoutManager(this)
        val adapter=recycleAdapter(this,this)
        recycleView.adapter=adapter
        viewmodel=ViewModelProvider(this,
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewmodel::class.java)

        viewmodel.data.observe(this, Observer {
        list->list?.let{
            adapter.update(it)
        }
        })


    }
    override fun onItemclick(notes: Notes) {
          viewmodel.delete(notes)
        Toast.makeText(this,"${notes.text}deleted",Toast.LENGTH_SHORT).show()
    }

    fun Submit(view: View) {
        val note=edit.text.toString()
        if(note.isNotEmpty())
        {
            viewmodel.insert(Notes(note))
            Toast.makeText(this,"${note}added",Toast.LENGTH_SHORT).show()
        }
    }
}