package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class recycleAdapter(private val context: Context,private val listner:clickHandler): RecyclerView.Adapter<recycleAdapter.noteviewholder>() {

    val allnotes=ArrayList<Notes>()
inner class noteviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
val textview :TextView=itemView.findViewById(R.id.text)
    val delete:ImageView=itemView.findViewById(R.id.del)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteviewholder {
       val viewholder= noteviewholder(LayoutInflater.from(context).inflate(R.layout.item,parent,false))
        viewholder.delete.setOnClickListener{

        listner.onItemclick(allnotes[viewholder.adapterPosition])
        }
        return viewholder

    }

    override fun onBindViewHolder(holder: noteviewholder, position: Int) {
        val currentNote=allnotes[position]
        holder.textview.text=currentNote.text

    }

    override fun getItemCount(): Int {
        return allnotes.size
    }
    fun update(newlist:List<Notes>)
    {
        allnotes.clear()
        allnotes.addAll(newlist)
        notifyDataSetChanged()
    }
}

interface clickHandler
{
fun onItemclick(notes: Notes)
}