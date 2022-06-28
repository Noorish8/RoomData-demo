package com.example.roomdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), INotesRVAdapter {
    lateinit var viewModel: NoteViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter:NoteRVAdapater
    lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.btn_submit)
        recyclerView=findViewById(R.id.recyclerview)
        viewModel =ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)

    //updat view model
      viewModel.allNotes.observe(this, Observer {list ->
          list?.let {
              adapter.updateList(it)

          }

      })
        recyclerView.adapter=NoteRVAdapater(this,this)
    }

    override fun onItemClicked(note: Note) {
     viewModel.deleteNote(note)
        Toast.makeText(this,"${note.text} Deleted",Toast.LENGTH_LONG).show()
    }

    fun submitData(view: View) {
       val noteText = button.text.toString()
        if (noteText.isEmpty()){
            viewModel.insertNote(Note(noteText))
        }
    }
//    fun submitData (view:View){
//        val noteText =input
//    }
}