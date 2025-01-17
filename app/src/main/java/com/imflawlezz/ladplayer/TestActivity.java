package com.imflawlezz.ladplayer;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.imflawlezz.ladplayer.Adapters.PlaylistAdapter;

import java.util.Arrays;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist_activity_layout);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> playlist = Arrays.asList(
                "Song 1 - Artist 1",
                "Song 2 - Artist 2",
                "Song 3 - Artist 3",
                "Song 4 - Artist 4",
                "Song 2 - Artist 2",
                "Song 3 - Artist 3",
                "Song 4 - Artist 4",
                "Song 2 - Artist 2",
                "Song 3 - Artist 3",
                "Song 4 - Artist 4",
                "Song 5 - Artist 5"
        );

        PlaylistAdapter adapter = new PlaylistAdapter(playlist);

        recyclerView.setAdapter(adapter);
    }
}
