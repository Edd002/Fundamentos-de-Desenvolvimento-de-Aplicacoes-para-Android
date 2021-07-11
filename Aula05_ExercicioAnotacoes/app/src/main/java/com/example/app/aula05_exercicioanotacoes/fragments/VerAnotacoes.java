package com.example.app.aula05_exercicioanotacoes.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.app.transportadora.aula05_exercicioanotacoes.R;

public class VerAnotacoes extends Fragment {

    private EditText editVerAnotacao;
    private View view;

    public VerAnotacoes() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ver_anotacoes, container, false);
        return view;
    }

    @Override
    public void onStart() { // Executado quando a activity está ativa para o usuário porém ainda não permite interação
        super.onStart();

        editVerAnotacao = view.findViewById(R.id.editVerAnotacao);

        SharedPreferences shared = view.getContext().getSharedPreferences("Dados", 0);
        editVerAnotacao.setText(shared.getString("anotacao", "Nenhuma anotação encontrada."));
    }
}