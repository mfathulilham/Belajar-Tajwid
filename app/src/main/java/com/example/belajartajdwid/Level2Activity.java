package com.example.belajartajdwid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Level2Activity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer suaraButton;
    private int num;
    public ImageButton btn1;
    public ImageButton btn2;
    public ImageButton btn3;
    public ImageButton btn4;
    public ImageButton btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        suaraButton = MediaPlayer.create(this, R.raw.button);

        ImageButton back = findViewById(R.id.btnBack);
        back.setOnClickListener(this);

        btn1 = findViewById(R.id.btnSatu1);
        btn2 = findViewById(R.id.btnSatu2);
        btn3 = findViewById(R.id.btnSatu3);
        btn4 = findViewById(R.id.btnSatu4);
        btn5 = findViewById(R.id.btnSatu5);

        getSharedPref();
        if (num >= 5) {
            button1Unlock();
        }
    }

    private void getSharedPref() {
        SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
        if (mPrefs != null){
            num = mPrefs.getInt("VALUE_NUM",0);
        }
    }
    private void button1Unlock() {
        btn1.setBackgroundResource(R.drawable.img1);
        btn1.setOnClickListener(this);
    }
    private void button2Unlock() {
        btn2.setBackgroundResource(R.drawable.img2);
        btn2.setOnClickListener(this);
    }
    private void button3Unlock() {
        btn3.setBackgroundResource(R.drawable.img3);
        btn3.setOnClickListener(this);
    }
    private void button4Unlock() {
        btn4.setBackgroundResource(R.drawable.img4);
        btn4.setOnClickListener(this);
    }
    private void button5Unlock() {
        btn5.setBackgroundResource(R.drawable.img5);
        btn5.setOnClickListener(this);
    }


    private void unlockButton() {

        if (num >= 6) {
            button2Unlock();
        }
        if (num >= 7) {
            button3Unlock();
        }
        if (num >= 8) {
            button4Unlock();
        }
        if (num >= 9) {
            button5Unlock();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        getSharedPref();
        unlockButton();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSatu1) {
            suaraButton.start();
            Intent intent = new Intent(this, QuisActivity.class);
            intent.putExtra("Question", 5);
            if (6 > num){
                intent.putExtra("num", 6);
            }else intent.putExtra("num", num);
            startActivity(intent);

        } else if (view.getId() == R.id.btnSatu2) {
            suaraButton.start();
            Intent intent = new Intent(this, QuisActivity.class);
            intent.putExtra("Question", 6);
            if (7 > num){
                intent.putExtra("num", 7);
            }else intent.putExtra("num", num);
            startActivity(intent);
        } else if (view.getId() == R.id.btnSatu3) {
            suaraButton.start();
            Intent intent = new Intent(this, QuisActivity.class);
            intent.putExtra("Question", 7);
            if (8 > num){
                intent.putExtra("num", 8);
            }else intent.putExtra("num", num);
            startActivity(intent);
        } else if (view.getId() == R.id.btnSatu4) {
            suaraButton.start();
            Intent intent = new Intent(this, QuisActivity.class);
            intent.putExtra("Question", 8);
            if (9 > num){
                intent.putExtra("num", 9);
            }else intent.putExtra("num", num);
            startActivity(intent);
        } else if (view.getId() == R.id.btnSatu5) {
            suaraButton.start();
            Intent intent = new Intent(this, QuisActivity.class);
            intent.putExtra("Question", 9);
            if (10 > num){
                intent.putExtra("num", 10);
            }else intent.putExtra("num", num);
            startActivity(intent);
        } else if (view.getId() == R.id.btnBack) {
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
//        SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
//        SharedPreferences.Editor editor = mPrefs.edit();
//        editor.putInt("VALUE_NUM",num);
//        editor.apply();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        mpRelease();
        super.onBackPressed();
    }
}