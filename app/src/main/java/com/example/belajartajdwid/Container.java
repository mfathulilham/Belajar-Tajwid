package com.example.belajartajdwid;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Container extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        BelajarMenu mBelajarMenu = new BelajarMenu();
        mFragmentTransaction.add(R.id.frame_container, mBelajarMenu, BelajarMenu.class.getSimpleName());
        mFragmentTransaction.commit();


    }



}
