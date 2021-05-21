package com.example.belajartajdwid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Hijaiyah extends AppCompatActivity implements View.OnClickListener {


    private MediaPlayer mp = new MediaPlayer();
    private int[] hijaiyahList, btn;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hijaiyah);


        stopService(new Intent(getApplicationContext(), SoundService.class));

        back = findViewById(R.id.btnBack);

        back.setOnClickListener(this);

        hijaiyahList = new int[]{R.raw.alif, R.raw.ba, R.raw.ta, R.raw.tsu, R.raw.jim, R.raw.ha, R.raw.kho,
                R.raw.dal, R.raw.dzal, R.raw.ro, R.raw.zu, R.raw.sin, R.raw.syin, R.raw.shad,
                R.raw.dho, R.raw.thu, R.raw.dzu, R.raw.ain, R.raw.gin, R.raw.fa, R.raw.kof,
                R.raw.kaf, R.raw.lam, R.raw.min, R.raw.nun, R.raw.wawu, R.raw.haa, R.raw.ya};
        btn = new int[]{R.id.btnAlif, R.id.btnBa, R.id.btnTa, R.id.btnTsa, R.id.btnJim, R.id.btnHa, R.id.btnKha, R.id.btnDal, R.id.btnDzal, R.id.btnRa,
                R.id.btnZa, R.id.btnSin, R.id.btnSyin, R.id.btnShad, R.id.btnDhad, R.id.btnTha, R.id.btnZha, R.id.btnAin, R.id.btnGhain, R.id.btnFa,
                R.id.btnQaf, R.id.btnKaf, R.id.btnLam, R.id.btnMim, R.id.btnNun, R.id.btnWaw, R.id.btnHaa, R.id.btnYa};

        for (int a = 0; a < btn.length; a++) {
            ImageButton b = findViewById(btn[a]);
            b.setOnClickListener(this);
        }
    }

    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
        }
    }

    private void mpRelease() {
        mp.release();
        mp = null;
    }

    private void startSound() {
        mp.start();
    }

    @Override
    protected void onDestroy() {
        mpRelease();
        startService(new Intent(getApplicationContext(), SoundService.class));
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
//        for (int c=0;c<hijaiyahList.length;c++){
//            if (view.getId() == btn[c]);
//            mp[c].start();
//        }
        if (view.getId() == R.id.btnBack) {
            super.onBackPressed();
        } else if (view.getId() == R.id.btnAlif) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.alif);
            startSound();
        } else if (view.getId() == R.id.btnBa) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.ba);
            startSound();
        } else if (view.getId() == R.id.btnTa) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.ta);
            startSound();
        } else if (view.getId() == R.id.btnTsa) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.fatah_tsa);
            startSound();
        } else if (view.getId() == R.id.btnJim) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.jim);
            startSound();
        } else if (view.getId() == R.id.btnHa) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.ha);
            startSound();
        } else if (view.getId() == R.id.btnKha) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.kho);
            startSound();
        } else if (view.getId() == R.id.btnDal) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.dal);
            startSound();
        } else if (view.getId() == R.id.btnDzal) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.dzal);
            startSound();
        } else if (view.getId() == R.id.btnRa) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.ro);
            startSound();
        } else if (view.getId() == R.id.btnZa) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.dza);
            startSound();
        } else if (view.getId() == R.id.btnSin) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.sin);
            startSound();
        } else if (view.getId() == R.id.btnSyin) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.syin);
            startSound();
        } else if (view.getId() == R.id.btnShad) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.shad);
            startSound();
        } else if (view.getId() == R.id.btnDhad) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.dho);
            startSound();
        } else if (view.getId() == R.id.btnTha) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.thu);
            startSound();
        } else if (view.getId() == R.id.btnZha) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.dzu);
            startSound();
        } else if (view.getId() == R.id.btnAin) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.ain);
            startSound();
        } else if (view.getId() == R.id.btnGhain) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.gin);
            startSound();
        } else if (view.getId() == R.id.btnFa) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.fa);
            startSound();
        } else if (view.getId() == R.id.btnQaf) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.kof);
            startSound();
        } else if (view.getId() == R.id.btnKaf) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.kaf);
            startSound();
        } else if (view.getId() == R.id.btnLam) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.lam);
            startSound();
        } else if (view.getId() == R.id.btnMim) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.min);
            startSound();
        } else if (view.getId() == R.id.btnNun) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.nun);
            startSound();
        } else if (view.getId() == R.id.btnWaw) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.wawu);
            startSound();
        } else if (view.getId() == R.id.btnHaa) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.haa);
            startSound();
        } else if (view.getId() == R.id.btnYa) {
            stopPlaying();
            mp = MediaPlayer.create(getBaseContext(), R.raw.ya);
            startSound();
        }
    }
}
