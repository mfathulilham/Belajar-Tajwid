package com.example.belajartajdwid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private  MediaPlayer suaraButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        suaraButton = MediaPlayer.create(this,R.raw.button);

        //start service and play music
        startService(new Intent(MainActivity.this, SoundService.class));

        ImageButton btnBelajar = findViewById(R.id.ibBelajar);
        ImageButton btnTes = findViewById(R.id.ibTes);
        ImageButton btnExit = findViewById(R.id.ibExit);
        ImageButton btnHelp = findViewById(R.id.ibHelp);
        ImageButton btnAbout = findViewById(R.id.ibAbout);

        btnBelajar.setOnClickListener(this);
        btnTes.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        btnHelp.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
    }


    protected void onDestroy() {
        //stop service and stop music
        stopService(new Intent(MainActivity.this, SoundService.class));
        super.onDestroy();
    }

    //when button click
    @Override
    public void onClick(View view) {

            if (view.getId() == R.id.ibBelajar){
                suaraButton.start();
                Intent intent = new Intent(this, Container.class);
                startActivity(intent);
            }
            else if (view.getId() == R.id.ibTes){
                suaraButton.start();
                Intent intent = new Intent(this,LevelMenu.class);
                startActivity(intent);
            }
            else if (view.getId() == R.id.ibHelp){
                suaraButton.start();
                Intent intent = new Intent(this,Help.class);
                startActivity(intent);
            }
            else if (view.getId() == R.id.ibAbout){
                suaraButton.start();
                Intent intent = new Intent(this,About.class);
                startActivity(intent);
            }
            else if (view.getId() == R.id.ibExit){
                suaraButton.start();
                showDialog();
            }
    }

    @Override
    public void onBackPressed(){
        suaraButton.start();
        showDialog();
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Yakin Ingin Keluar  ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                android.os.Process.killProcess(android.os.Process.myPid());
                suaraButton.start();
                mpRelease();
                System.exit(0);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                suaraButton.start();
                dialogInterface.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void mpRelease() {
        if (suaraButton!=null){
            suaraButton.release();
            suaraButton = null;
        }
    }
}
