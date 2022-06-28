package com.example.roomdata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapater(private val context: Context, private val listener:INotesRVAdapter):RecyclerView.Adapter<NoteRVAdapater.NoteViewHolder>() {
      val allNotes =ArrayList<Note>()
    inner class NoteViewHolder(itemView:View):RecyclerView.ViewHolder(itemView ){
        val txtView = itemView.findViewById<TextView>(R.id.txt_name)
        val button = itemView.findViewById<Button>(R.id.btn_submit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
   val viewHolder= NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.button.setOnClickListener {
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote =allNotes[position]
        holder.txtView.text=currentNote.text

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }
    fun updateList(newList:List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

}
interface INotesRVAdapter {
    fun onItemClicked(note: Note)
}