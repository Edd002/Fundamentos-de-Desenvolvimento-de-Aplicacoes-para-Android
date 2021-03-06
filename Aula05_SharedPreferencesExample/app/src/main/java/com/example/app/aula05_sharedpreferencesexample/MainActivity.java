package com.example.app.aula05_sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    TextView txtRelatorio;
    EditText editNome;
    String relatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSalvar);
        txtRelatorio = findViewById(R.id.txtRelatorio);
        editNome = findViewById(R.id.editNome);

        // Objeto utilizado para manter os dados (persistir) mesmo após o aplicativo ser finalizado
        SharedPreferences shared = getSharedPreferences("Dados", 0);
        relatorio = shared.getString("nome", "Nenhum nome encontrado.");
        txtRelatorio.setText(relatorio);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editNome.getText() != null && editNome.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Preencha o campo nome.", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString("nome", editNome.getText().toString());
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Dado salvo com sucesso.", Toast.LENGTH_SHORT).show();
                    relatorio = editNome.getText().toString();
                    txtRelatorio.setText(relatorio);
                    editNome.getText().clear();
                }
            }
        });
    }
}