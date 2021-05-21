package com.example.belajartajdwid;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class IdzharSyafawi extends Fragment implements View.OnClickListener{


    public IdzharSyafawi() {
        // Required empty public constructor
    }

    private MediaPlayer suaraButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_idzhar_syafawi, container, false);
        getActivity().stopService(new Intent(getActivity(), SoundService.class));

        suaraButton = MediaPlayer.create(getActivity(), R.raw.izhar_syafawi);
        Button btnPlay = view.findViewById(R.id.play);
        Button btnPause = view.findViewById(R.id.pause);

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);

        return view;
    }

    private void mpRelease() {
        if (suaraButton != null) {
            suaraButton.release();
            suaraButton = null;
        }
    }

    @Override
    public void onDestroy() {
        mpRelease();
        getActivity().startService(new Intent(getActivity(), SoundService.class));
        super.onDestroy();
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.play) {
            suaraButton.start();
        } else {
            if (suaraButton.isPlaying()) {
                suaraButton.pause();
            }
        }
    }
}