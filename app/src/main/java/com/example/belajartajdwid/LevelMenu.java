package com.example.belajartajdwid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LevelMenu extends AppCompatActivity implements View.OnClickListener {
    private  MediaPlayer suaraButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_menu);
        suaraButton = MediaPlayer.create(this,R.raw.button);

        ImageButton back = findViewById(R.id.btnBack);
        back.setOnClickListener(this);

        ImageButton btnLevel1 = findViewById(R.id.ibLevel1);
        ImageButton btnLevel2 = findViewById(R.id.ibLevel2);
        ImageButton btnLevel3 = findViewById(R.id.ibLevel3);

        btnLevel1.setOnClickListener(this);
        btnLevel2.setOnClickListener(this);
        btnLevel3.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.ibLevel1){
            suaraButton.start();
            Intent intent = new Intent(this,Level1Activity.class);
            startActivity(intent);
        }else
        if (view.getId()==R.id.ibLevel2){
            suaraButton.start();
            Intent intent = new Intent(this,Level2Activity.class);
            startActivity(intent);
        }else
        if (view.getId()==R.id.ibLevel3){
            suaraButton.start();
            Intent intent = new Intent(this,Level3Activity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btnBack){
            suaraButton.start();
            super.onBackPressed();
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
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        mpRelease();
        super.onBackPressed();
    }
}
