package com.example.belajartajdwid;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class BelajarMenu extends Fragment implements View.OnClickListener{


    public BelajarMenu() {
        // Required empty public constructor
    }

    private MediaPlayer suaraButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        suaraButton = MediaPlayer.create(getActivity(),R.raw.button);
        View view = inflater.inflate(R.layout.fragment_belajar_menu, container, false);

        //declare all the button
        ImageButton btnHijaiyah = view.findViewById(R.id.ibHijaiyah);
        ImageButton btnUmmi = view.findViewById(R.id.ibUmmi);
        ImageButton btnSugra = view.findViewById(R.id.ibQalqalah);
        ImageButton btnMim = view.findViewById(R.id.ibMim);
        ImageButton btnNun = view.findViewById(R.id.ibNun);
        ImageButton btnBack = view.findViewById(R.id.btnBack);

        btnHijaiyah.setOnClickListener(this);
        btnUmmi.setOnClickListener(this);
        btnSugra.setOnClickListener(this);
        btnMim.setOnClickListener(this);
        btnNun.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        return view;
    }
    //method to release MediaPlayer
    private void mpRelease() {
        if (suaraButton!=null){
            suaraButton.release();
            suaraButton = null;
        }
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ibHijaiyah) {
            suaraButton.start();
            Intent intent = new Intent(getActivity(), Hijaiyah.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.ibUmmi) {
            suaraButton.start();
            Intent intent = new Intent(getActivity(), Ummi.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.ibQalqalah) {
            suaraButton.start();
            Intent intent = new Intent(getActivity(), Qalqalah.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.ibNun) {
            suaraButton.start();
            NunSukun mNunSukun = new NunSukun();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, mNunSukun, mNunSukun.getClass().getSimpleName());
            mFragmentTransaction.addToBackStack(null)
                    .commit();
        }
        else if (view.getId() == R.id.ibMim) {
            suaraButton.start();
            MimSukun mMimSukun = new MimSukun();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, mMimSukun, mMimSukun.getClass().getSimpleName());
            mFragmentTransaction.addToBackStack(null)
                    .commit();

        }
        else if (view.getId() == R.id.btnBack) {
            suaraButton.start();
            getActivity().finish();
        }

    }

    //method when activity destroyed
    @Override
    public void onDestroy() {
        mpRelease();
        super.onDestroy();
    }
}
