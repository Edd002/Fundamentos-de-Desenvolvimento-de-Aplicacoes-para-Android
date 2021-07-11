package com.example.app.aula05_exercicioanotacoes.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.app.transportadora.aula05_exercicioanotacoes.R;

public class CriarAnotacoes extends Fragment {

    private Button btnSalvarAnotacao;
    private EditText editCriarAnotacao;

    public CriarAnotacoes() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.criar_anotacoes, container, false);

        btnSalvarAnotacao = view.findViewById(R.id.btnSalvarAnotacao);
        editCriarAnotacao = view.findViewById(R.id.editCriarAnotacao);

        SharedPreferences shared = view.getContext().getSharedPreferences("Dados", 0);

        btnSalvarAnotacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editCriarAnotacao.getText() != null && editCriarAnotacao.getText().toString().isEmpty()) {
                    Toast.makeText(view.getContext(), "Preencha o campo anotações.", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString("anotacao", editCriarAnotacao.getText().toString());
                    editor.commit();
                    Toast.makeText(view.getContext(), "Dados salvos com sucesso.", Toast.LENGTH_SHORT).show();
                    editCriarAnotacao.getText().clear();
                }
            }
        });

        return view;
    }
}