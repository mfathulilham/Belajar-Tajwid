package com.example.belajartajdwid;


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
public class MimSukun extends Fragment implements View.OnClickListener {


    public MimSukun() {
        // Required empty public constructor
    }

    private MediaPlayer suaraButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mim_sukun, container, false);
        suaraButton = MediaPlayer.create(getActivity(),R.raw.button);

        ImageButton btnMimi = view.findViewById(R.id.ibMimi);
        ImageButton btnIksyafawi = view.findViewById(R.id.ibIkhsyafawi);
        ImageButton btnIdzsyafawi = view.findViewById(R.id.ibIdzsyafawi);
        ImageButton btnBack = view.findViewById(R.id.btnBack);

        btnMimi.setOnClickListener(this);
        btnIdzsyafawi.setOnClickListener(this);
        btnIksyafawi.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ibMimi) {
            suaraButton.start();
            IdgamMimi mIdgamMimi = new IdgamMimi();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, mIdgamMimi, mIdgamMimi.getClass().getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
        else if (view.getId() == R.id.ibIkhsyafawi) {
            suaraButton.start();
            IkhfaSyafawi mIkhfaSyafawi = new IkhfaSyafawi();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, mIkhfaSyafawi, mIkhfaSyafawi.getClass().getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
        else if (view.getId() == R.id.ibIdzsyafawi) {
            suaraButton.start();
            IdzharSyafawi mIdzharSyafawi = new IdzharSyafawi();
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.frame_container, mIdzharSyafawi, mIdzharSyafawi.getClass().getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
        else if (view.getId() == R.id.btnBack) {
            suaraButton.start();
            getActivity().getSupportFragmentManager().popBackStack();
        }
    }
}
