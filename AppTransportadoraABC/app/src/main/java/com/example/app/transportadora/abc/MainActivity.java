package com.example.app.transportadora.abc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editDistanciaKm;
    EditText editPrecoLitroCombustivel;
    TextView txtResultadoCreditoFrete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editDistanciaKm = findViewById(R.id.editDistanciaKm);
        editPrecoLitroCombustivel = findViewById(R.id.editPrecoLitroCombustivel);
        txtResultadoCreditoFrete = findViewById(R.id.txtResultadoCreditoFrete);
    }

    public void calcularCreditoFrete(View view) {
        float resultado = 0.0f;
        resultado = calcular(Float.parseFloat(editDistanciaKm.getText().toString()), Float.parseFloat(editPrecoLitroCombustivel.getText().toString()));
        txtResultadoCreditoFrete.setText(String.format("Crédito necessário - R$: %.2f", resultado));
    }

    public static float calcular(float distanciaKm, float precoLitroCombustivel) {
        return (distanciaKm / 10) * precoLitroCombustivel * 2.0f * 1.1f;
    }
}