package com.example.belajartajdwid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Level1Activity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer suaraButton;
    private static int num;
    public ImageButton btn1;
    public ImageButton btn2;
    public ImageButton btn3;
    public ImageButton btn4;
    public ImageButton btn5;
//    public ImageButton btn6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        suaraButton = MediaPlayer.create(this,R.raw.button);

        ImageButton back = findViewById(R.id.btnBack);
        back.setOnClickListener(this);

        btn1 = findViewById(R.id.btnSatu1);
        btn2 = findViewById(R.id.btnSatu2);
        btn3 = findViewById(R.id.btnSatu3);
        btn4 = findViewById(R.id.btnSatu4);
        btn5 = findViewById(R.id.btnSatu5);
//        btn6 = findViewById(R.id.btnSatu6);

        btn1.setOnClickListener(this);
        getSharedPref();
    }


    private void getSharedPref() {
        SharedPreferences mPrefs = getSharedPreferences("IDvalue",0);
        if (mPrefs != null){
            num = mPrefs.getInt("VALUE_NUM",0);
        }
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
//    private void button6Unlock() {
//        btn6.setBackgroundResource(R.drawable.img5);
//        btn6.setOnClickListener(this);
//    }
//    private void button6Unlock() {
//        btn6.setBackgroundResource(R.drawable.img5);
//        btn6.setOnClickListener(this);
//    }

    @Override
    protected void onStart() {
        super.onStart();
        getSharedPref();
        if (num >= 1) {
            button2Unlock();
        }
        if (num >= 2) {
            button3Unlock();
        }
        if (num >= 3) {
            button4Unlock();
        }
        if (num >= 4) {
            button5Unlock();
        }
//        else if (num >= 6) {
//            button2Unlock();
//            button3Unlock();
//            button4Unlock();
//            button5Unlock();
//            button6Unlock();
//        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSatu1) {
            suaraButton.start();
            Intent intent = new Intent(this, QuisActivity.class);
            intent.putExtra("Question", 0);
            if (1 > num){
                intent.putExtra("num", 1);
            }else intent.putExtra("num", num);
            startActivity(intent);
        } else if (view.getId() == R.id.btnSatu2) {
            suaraButton.start();
            Intent intent = new Intent(this, QuisActivity.class);
            intent.putExtra("Question", 1);
            if (2 > num){
                intent.putExtra("num", 2);
            }else intent.putExtra("num", num);
            startActivity(intent);
        } else if (view.getId() == R.id.btnSatu3) {
            suaraButton.start();
            Intent intent = new Intent(this, QuisActivity.class);
            intent.putExtra("Question", 2);
            if (3 > num){
                intent.putExtra("num", 3);
            }else intent.putExtra("num", num);
            startActivity(intent);
        } else if (view.getId() == R.id.btnSatu4) {
            suaraButton.start();
            Intent intent = new Intent(this, QuisActivity.class);
            intent.putExtra("Question", 3);
            if (4 > num){
                intent.putExtra("num", 4);
            }else intent.putExtra("num", num);
            startActivity(intent);
        } else if (view.getId() == R.id.btnSatu5) {
            suaraButton.start();
            Intent intent = new Intent(this, QuisActivity.class);
            intent.putExtra("Question", 4);
            if (5 > num){
                intent.putExtra("num",5 );
            }else intent.putExtra("num", num);
            startActivity(intent);
        }
//        else if (view.getId() == R.id.btnSatu6) {
//            suaraButton.start();
//            Intent intent = new Intent(this, QuisActivity.class);
//            intent.putExtra("Question", 5);
//            if (6 > num){
//                intent.putExtra("num", 6);
//            }
//            startActivity(intent);
//        }
        else if (view.getId() == R.id.btnBack) {
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
//        editor.commit();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        mpRelease();
        super.onBackPressed();
    }
}