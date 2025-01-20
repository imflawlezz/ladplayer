package com.imflawlezz.ladplayer;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
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
                "Ощзф - Artisrtyt 1",
                "Jopa 2 - yrArtist 2",
                "Ssdfg - Artrtist 3",
                "Sdfdfh - Artirtst 4",
                "1242353457 - Artyrtirst 2",
                "weteryrtyi - Artiyrst 3",
                "qwery - Artist rtyr4",
                "wery sori - Arrtytist 2",
                "cumball - Artist 3rtyrty",
                "safdsdghfghj 4 - Aryreyist 4",
                "dsfkjghdkjiuy8i - xcvr 5 sdjfghjskdgjsdg sdfghsdgfjhgsdf"
        );

        AppBarLayout appBarLayout = findViewById(R.id.appBar);
        ImageButton buttonPlay = findViewById(R.id.buttonPlay);
        ImageButton buttonShuffle = findViewById(R.id.buttonShuffle);
        ImageButton buttonUtilPlay = findViewById(R.id.buttonUtilPlay);
        ImageButton buttonUtilShuffle = findViewById(R.id.buttonUtilShuffle);
        ShapeableImageView playlistImage = findViewById(R.id.playlistImage);

        appBarLayout.addOnOffsetChangedListener((appBarLayout1, verticalOffset) -> {
            int totalScrollRange = appBarLayout1.getTotalScrollRange();

            float collapsePercentage = Math.abs(verticalOffset) / (float) totalScrollRange;

            if (collapsePercentage == 1.0f) {
                buttonPlay.setVisibility(View.GONE);
                buttonPlay.animate().alpha(0f).setDuration(300).start();

                buttonShuffle.setVisibility(View.GONE);
                buttonShuffle.animate().alpha(0f).setDuration(300).start();

                buttonUtilPlay.setVisibility(View.VISIBLE);
                buttonUtilPlay.animate().alpha(1f).setDuration(300).start();

                buttonUtilShuffle.setVisibility(View.VISIBLE);
                buttonUtilShuffle.animate().alpha(1f).setDuration(300).start();

            } else {
                buttonPlay.setVisibility(View.VISIBLE);
                buttonPlay.animate().alpha(1f).setDuration(100).start();

                buttonShuffle.setVisibility(View.VISIBLE);
                buttonShuffle.animate().alpha(1f).setDuration(100).start();

                buttonUtilPlay.setVisibility(View.GONE);
                buttonUtilPlay.animate().alpha(0f).setDuration(300).start();

                buttonUtilShuffle.setVisibility(View.GONE);
                buttonUtilShuffle.animate().alpha(0f).setDuration(300).start();
            }

            float scale = 1 - (collapsePercentage * 0.5f);
            playlistImage.setScaleX(scale);
            playlistImage.setScaleY(scale);
            playlistImage.setAlpha(1 - collapsePercentage);
        });


        PlaylistAdapter adapter = new PlaylistAdapter(playlist);

        recyclerView.setAdapter(adapter);
    }
}
