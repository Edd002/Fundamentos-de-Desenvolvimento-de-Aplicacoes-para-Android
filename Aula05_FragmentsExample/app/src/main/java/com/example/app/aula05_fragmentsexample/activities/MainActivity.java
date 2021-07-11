package com.example.app.aula05_fragmentsexample.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import com.example.app.aula05_fragmentsexample.fragments.AboutFragment;
import com.example.app.transportadora.aula05_fragmentsexample.R;
import com.example.app.aula05_fragmentsexample.fragments.MusicasFragment;

public class MainActivity extends AppCompatActivity {

    AboutFragment aboutFragment;
    MusicasFragment musicasFragment;

    Button buttonSobre;
    Button buttonMusicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aboutFragment = new AboutFragment();
        musicasFragment = new MusicasFragment();

        buttonSobre = findViewById(R.id.buttonSobre);
        buttonMusicas = findViewById(R.id.buttonMusicas);

        buttonSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, aboutFragment);
                transaction.commit();

                try {
                    Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vib.vibrate(200);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });

        buttonMusicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, musicasFragment);
                transaction.commit();
            }
        });
    }
}