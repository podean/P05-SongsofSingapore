package com.example.potran.p05_songsofsingapore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    ListView lvSongs;
    ArrayList<Song> songs;
    ArrayAdapter aaSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        lvSongs = (ListView) findViewById(R.id.listViewSong);
        final DBHelper db = new DBHelper(ShowActivity.this);

        songs = db.getAllSongs();
        aaSongs = new SongAdapter(ShowActivity.this, R.layout.row, songs);
        lvSongs.setAdapter(aaSongs);

        db.close();




    }
}
