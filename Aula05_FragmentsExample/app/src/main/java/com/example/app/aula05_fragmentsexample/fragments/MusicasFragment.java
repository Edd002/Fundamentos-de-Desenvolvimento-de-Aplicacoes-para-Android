package com.example.app.aula05_fragmentsexample.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.app.aula05_fragmentsexample.util.AudioPlayer;
import com.example.app.transportadora.aula05_fragmentsexample.R;

public class MusicasFragment extends Fragment {

    Button buttonPlay;
    Button buttonStop;

    public MusicasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_musicas, container, false);

        buttonPlay = view.findViewById(R.id.buttonPlay);
        buttonStop = view.findViewById(R.id.buttonStop);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AudioPlayer.playAudio(getContext(), R.raw.fantasia);

                try {
                    Vibrator vib = (Vibrator) getContext().getSystemService(getContext().VIBRATOR_SERVICE);
                    vib.vibrate(100);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AudioPlayer.stopAudio();
            }
        });

        return view;
    }
}