package com.example.belajartajdwid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ummi extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer suaraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ummi);

        stopService(new Intent(getApplicationContext(), SoundService.class));
        suaraButton = MediaPlayer.create(this, R.raw.ummi);

        Button btnPlay = findViewById(R.id.play);
        Button btnPause = findViewById(R.id.pause);

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);

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
        } else {
            if (suaraButton.isPlaying()) {
                suaraButton.pause();
            }
        }
    }
}
