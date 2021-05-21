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
public class Idgam extends Fragment implements View.OnClickListener {


    public Idgam() {
        // Required empty public constructor
    }

    private MediaPlayer suaraButton, suaraButton1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_idgam, container, false);
        getActivity().stopService(new Intent(getActivity(), SoundService.class));

        suaraButton = MediaPlayer.create(getActivity(), R.raw.idgam_bigunnah);
        suaraButton1 = MediaPlayer.create(getActivity(), R.raw.idgam_bilagunnah);

        Button btnPlay = view.findViewById(R.id.play);
        Button btnPause = view.findViewById(R.id.pause);
        Button btnPlay1 = view.findViewById(R.id.play1);
        Button btnPause1 = view.findViewById(R.id.pause1);

        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnPlay1.setOnClickListener(this);
        btnPause1.setOnClickListener(this);
        return view;
    }

    private void mpRelease() {
        if (suaraButton != null) {
            suaraButton.release();
            suaraButton = null;
        }
    }

    private void mpPause() {
        if (suaraButton != null) {
            suaraButton.pause();
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
        } else if (view.getId() == R.id.pause) {
            if (suaraButton.isPlaying()) {
                mpPause();
            }
        } else if (view.getId() == R.id.play1) {
            suaraButton1.start();
        } else if (view.getId() == R.id.pause1) {
            if (suaraButton1 != null) {
                if (suaraButton1.isPlaying()) {
                    suaraButton1.pause();
                }
            }
        }
    }
}
