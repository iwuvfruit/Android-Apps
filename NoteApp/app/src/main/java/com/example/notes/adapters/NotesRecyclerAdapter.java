package com.example.notes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.R;
import com.example.notes.models.Note;

import java.util.ArrayList;

//1.create view holder
//2. extend
//3. write abstract methods
//4, reference them with viewholder, layout

//this is fundamental, most apps will have list of something
//recycle view only shows a specific notes to optimize memory
//it holds view in temporary view memory with view holder class

//extending the view holder I just created
//need a data structure to hold these notes

//must declare abstract method for recycler view adapter class, alt enter to see
public class NotesRecyclerAdapter extends  RecyclerView.Adapter<NotesRecyclerAdapter.Viewholder> {

    private ArrayList<Note> mNotes = new ArrayList<>(); //prepend notes with m because it's a global variable

    public NotesRecyclerAdapter(ArrayList<Note> notes) {
        this.mNotes = notes; //notes is a local variable
    }

    //must use these methods if using recycler view
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //creating/instantiating viewholder object
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_note_list_itemx, viewGroup, false);
        return new Viewholder(view);
        //basically every recycle view is same, data type and layout woulbe the only different part
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewHolder,  int i) {
        //this will be called for every entry in the list
        //reference viewholder=> referencing from global variable and get timestamp
        viewHolder.timestamp.setText(mNotes.get(i).getTimestamp());
        viewHolder.title.setText(mNotes.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mNotes.size();  //return number of notes in the list, return arraylist
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView title, timestamp;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            //        using the id from layout file, we connect them
            title = itemView.findViewById(R.id.note_title);
            timestamp = itemView.findViewById(R.id.note_timestamp);
        }
    }
}
