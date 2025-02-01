package com.imflawlezz.ladplayer;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.imflawlezz.ladplayer.Classes.QueueBottomSheetFragment;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_activity_layout); // Make sure this is the correct layout

        ImageButton buttonQueue = findViewById(R.id.buttonQueue);
        buttonQueue.setOnClickListener(view -> {
            QueueBottomSheetFragment queueFragment = new QueueBottomSheetFragment();
            queueFragment.show(getSupportFragmentManager(), queueFragment.getTag());
        });
    }


}