package com.example.mobapps_lab7;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton carImage, policeImage;
    private MediaPlayer carSound, policeSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carImage = findViewById(R.id.car_image);
        policeImage = findViewById(R.id.police_image);

        carSound = MediaPlayer.create(this, R.raw.sound1);
        policeSound = MediaPlayer.create(this, R.raw.sound2);

        carImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPlayButton(carSound, policeSound);
            }
        });

        policeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPlayButton(policeSound, carSound);
            }
        });
    }

    private void soundPlayButton(MediaPlayer sound1, MediaPlayer sound2) {
        if (sound1.isPlaying()) {
            sound1.pause();
            sound1.seekTo(0);
            sound1.setLooping(false);
        }
        if (sound2.isPlaying()) {
            sound2.pause();
            sound2.seekTo(0);
            sound2.setLooping(false);
        }

        sound1.start();
        sound1.setLooping(true);
    }
}