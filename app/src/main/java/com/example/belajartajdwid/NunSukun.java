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
public class NunSukun extends Fragment implements View.OnClickListener{


    public NunSukun() {
        // Required empty public constructor
    }

    private MediaPlayer suaraButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nun_sukun, container, false);
        suaraButton = MediaPlayer.create(getActivity(),R.raw.button);

        ImageButton btnIdzhar = view.findViewById(R.id.ibIdzhar);
        ImageButton btnIkhfa = view.findViewById(R.id.ibIkhfa);
        ImageButton btnIqlab = view.findViewById(R.id.ibIqlab);
        ImageButton btnIdgam = view.findViewById(R.id.ibIdgam);
        ImageButton btnBack = view.findViewById(R.id.btnBack);

        btnIdgam.setOnClickListener(this);
        btnIdzhar.setOnClickListener(this);
        btnIkhfa.setOnClickListener(this);
        btnIqlab.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ibIkhfa) {
            suaraButton.start();
            Ikhfa mIkhfa = new Ikhfa();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, mIkhfa, mIkhfa.getClass().getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
        else if (view.getId() == R.id.ibIdgam) {
            suaraButton.start();
            Idgam mIdgam = new Idgam();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, mIdgam, mIdgam.getClass().getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
        else if (view.getId() == R.id.ibIdzhar) {
            suaraButton.start();
            Idzhar mIdzhar = new Idzhar();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, mIdzhar, mIdzhar.getClass().getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
        else if (view.getId() == R.id.ibIqlab) {
            suaraButton.start();
            Iqlab mIqlab = new Iqlab();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, mIqlab, mIqlab.getClass().getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
        else if (view.getId() == R.id.btnBack) {
            suaraButton.start();
            getActivity().getSupportFragmentManager().popBackStack();
        }
    }
}
