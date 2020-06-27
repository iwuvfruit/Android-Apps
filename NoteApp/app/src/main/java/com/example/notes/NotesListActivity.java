package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.notes.adapters.NotesRecyclerAdapter;
import com.example.notes.models.Note;
import com.example.notes.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class NotesListActivity extends AppCompatActivity {

    private static final String TAG = "NotesListActivity"; //log t: identifier

    //filter using the tag, notesListActivity

    private void someRandomMethod(){
        String string = "this does something";
        int someInteger =2;
        Log.e(TAG, "some random method "+ string);
        //using logs will help you what's going on, will print it on logcat
        //it's like leaving breadcrumb, it's like println
        //logd: debug
        //loge: error-redline
        //can filter by application or can filter only by package

    }
    //android lifecycle event

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "destroyed");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "resumed");
    }

    //UI component
    private RecyclerView mRecyclerView;

    //vars
    //not ui or widget
    private ArrayList<Note> mNotes = new ArrayList<>();
    private NotesRecyclerAdapter mNoteRecyclerAdapter;


    //we use onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
//        Log.d(TAG, "onCreate: this is a test log output. "); //log d: prints the log referencing tag
        mRecyclerView = findViewById(R.id.recyclerView); //connecting the layout with activity
        //need reference to view for findViewById but activity has findView by default
        Note note = new Note("some title", "some content", "some time");
//        Note note2 = new Note();
//        note2.setTitle("some other title");
//        note2.setContent("some there content");
//        note2.setTimestamp("we are manually setting it here with empty constructor");
//
//        Log.d(TAG, "onCreate: my note" + note.toString());
        initRecycleView();
        insertFakeNotes();
    }

    private void insertFakeNotes(){
        for(int i =0; i < 1000; i++) {
            Note note = new Note();
            note.setTitle("title" + i);
            note.setContent("content" + i);
            note.setTimestamp("jan");
            mNotes.add(note);
        }
        mNoteRecyclerAdapter.notifyDataSetChanged();

    }
    //to set up recycle view
    private void initRecycleView(){
        //layout manager, such as grid or linear
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mNoteRecyclerAdapter = new NotesRecyclerAdapter(mNotes);
//        mRecyclerView.setAdapter(mNoteRecyclerAdapter);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);
        mRecyclerView.setAdapter(mNoteRecyclerAdapter);

    }
}