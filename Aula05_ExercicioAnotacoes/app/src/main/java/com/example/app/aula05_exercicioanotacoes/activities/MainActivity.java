package com.example.app.aula05_exercicioanotacoes.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.app.aula05_exercicioanotacoes.fragments.CriarAnotacoes;
import com.example.app.aula05_exercicioanotacoes.fragments.VerAnotacoes;
import com.example.app.transportadora.aula05_exercicioanotacoes.R;

public class MainActivity extends AppCompatActivity {

    CriarAnotacoes aboutFragment;
    VerAnotacoes musicasFragment;

    Button buttonSobre;
    Button buttonMusicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aboutFragment = new CriarAnotacoes();
        musicasFragment = new VerAnotacoes();

        buttonSobre = findViewById(R.id.buttonCriarAnotacoes);
        buttonMusicas = findViewById(R.id.buttonVerAnotacoes);

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