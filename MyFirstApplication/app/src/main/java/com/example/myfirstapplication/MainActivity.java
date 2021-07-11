package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtNome;
    EditText edtIdade;
    TextView txtRelatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.editNome);
        edtIdade = findViewById(R.id.editIdade);
        txtRelatorio = findViewById(R.id.txtRelatorio);
    }

    public void verificar(View view) {
        int idade = Integer.parseInt(edtIdade.getText().toString());
        if (this.possoAposentar(idade)) {
            txtRelatorio.setText(edtNome.getText() + " pode aposentar.");
        } else {
            txtRelatorio.setText(edtNome.getText() + " ainda não pode aposentar.");
        }
    }

    // Atalho para testes unitários: Ctrl + Shift + T
    public static boolean possoAposentar(int idade) {
        if (idade >= 65) {
            return true;
        } else {
            return false;
        }
    }

    public static double calcular(double x) {
        return x * 2;
    }
}