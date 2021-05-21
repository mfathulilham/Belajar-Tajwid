package com.example.belajartajdwid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Qalqalah extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer suaraButton,suaraButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qalqalah);
        stopService(new Intent(getApplicationContext(), SoundService.class));
        suaraButton = MediaPlayer.create(this, R.raw.qalqalah_sugra);
        suaraButton1 = MediaPlayer.create(this, R.raw.qalqalah_qubra);

        Button btnPlay = findViewById(R.id.play);
        Button btnPause = findViewById(R.id.pause);
        Button btnPlay1 = findViewById(R.id.play1);
        Button btnPause1 = findViewById(R.id.pause1);

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnPlay1.setOnClickListener(this);
        btnPause1.setOnClickListener(this);

    }

    private void mpPause() {
        if (suaraButton != null) {
            suaraButton.pause();
        }
    }

    private void mpRelease() {
        if (suaraButton != null) {
            suaraButton.release();
            suaraButton = null;
        }
    }

    @Override
    protected void onDestroy() {
        mpRelease();
        startService(new Intent(getApplicationContext(), SoundService.class));
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.play) {
            suaraButton.start();
        } else if (view.getId() == R.id.pause) {
            if (suaraButton.isPlaying()) {
                mpPause();
            }
        } else if (view.getId() == R.id.play1) {
            suaraButton1.start();
        } else if (view.getId() == R.id.pause1) {
            if (suaraButton1 != null) {
                if (suaraButton1.isPlaying()) {
                    suaraButton1.pause();
                }
            }
        }
    }
}
