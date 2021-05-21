package com.example.belajartajdwid;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultAnswer extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer suaraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_answer);

        suaraButton = MediaPlayer.create(this,R.raw.button);

        int mScore = getIntent().getExtras().getInt("score");


        Button btnLanjut = findViewById(R.id.btnLanjut);
        TextView tvScore = findViewById(R.id.tvScore);

        btnLanjut.setOnClickListener(this);

        tvScore.setText(String.valueOf(mScore));
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onDestroy() {
        suaraButton.release();
        suaraButton = null;
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLanjut) {
            suaraButton.start();
            super.onBackPressed();
        }
    }
}
