package com.example.belajartajdwid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Level3Activity extends AppCompatActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_level3);


        suaraButton = MediaPlayer.create(this, R.raw.button);

        ImageButton back = findViewById(R.id.btnBack);
        back.setOnClickListener(this);

        btn1 = findViewById(R.id.btnSatu1);
        btn2 = findViewById(R.id.btnSatu2);
        btn3 = findViewById(R.id.btnSatu3);
        btn4 = findViewById(R.id.btnSatu4);
        btn5 = findViewById(R.id.btnSatu5);

        // Save Data
        getSharedPref();

        if (num >= 10) {
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
        if (num >= 11) {
            button2Unlock();
        }
        if (num >= 12) {
            button3Unlock();
        }
        if (num >= 13) {
            button4Unlock();
        }
        if (num >= 14) {
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
            intent.putExtra("Question", 10);
            if (11 > num){
                intent.putExtra("num", 11);
            }else intent.putExtra("num", num);
            startActivity(intent);
        } else if (view.getId() == R.id.btnSatu2) {
            suaraButton.start();
            Intent intent = new Intent(this, QuisActivity.class);
            intent.putExtra("Question", 11);
            if (12 > num){
                intent.putExtra("num", 12);
            }else intent.putExtra("num", num);
            startActivity(intent);
        } else if (view.getId() == R.id.btnSatu3) {
            suaraButton.start();
            Intent intent = new Intent(this, QuisActivity.class);
            intent.putExtra("Question", 12);
            if (13 > num){
                intent.putExtra("num", 13);
            }else intent.putExtra("num", num);
            startActivity(intent);
        } else if (view.getId() == R.id.btnSatu4) {
            suaraButton.start();
            Intent intent = new Intent(this, QuisActivity.class);
            intent.putExtra("Question", 13);
            if (14 > num){
                intent.putExtra("num", 14);
            }else intent.putExtra("num", num);
            startActivity(intent);
        } else if (view.getId() == R.id.btnSatu5) {
            suaraButton.start();
            Intent intent = new Intent(this, QuisActivity.class);
            intent.putExtra("Question", 14);
            if (15 > num){
                intent.putExtra("num", 15);
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
//        editor.putInt("VALUE_NUM_3",num2);
//        editor.apply();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        mpRelease();
        super.onBackPressed();
    }
}
