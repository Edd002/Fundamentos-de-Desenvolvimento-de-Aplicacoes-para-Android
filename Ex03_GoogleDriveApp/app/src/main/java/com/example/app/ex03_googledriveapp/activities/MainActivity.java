package com.example.app.ex03_googledriveapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.app.ex03_googledriveapp.R;
import com.example.app.ex03_googledriveapp.adapters.Adaptador;
import com.example.app.ex03_googledriveapp.model.Diretorio;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<Diretorio> diretorios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        criarDiretorios();
        Adaptador adaptador = new Adaptador(diretorios);
        recyclerView.setAdapter(adaptador);
    }

    private void criarDiretorios() {
        Diretorio diretorio;

        diretorio = new Diretorio("Musicas", "Criado em 01/01/2021", true);
        diretorios.add(diretorio);

        diretorio = new Diretorio("Filmes", "Criado em 01/02/2021", true);
        diretorios.add(diretorio);

        diretorio = new Diretorio("Documentos", "Criado em 01/03/2021", true);
        diretorios.add(diretorio);

        diretorio = new Diretorio("Tutoriais", "Criado em 01/04/2021", false);
        diretorios.add(diretorio);

        diretorio = new Diretorio("Jogos", "Criado em 01/05/2021", true);
        diretorios.add(diretorio);

        diretorio = new Diretorio("Dados", "Criado em 02/01/2021", false);
        diretorios.add(diretorio);

        diretorio = new Diretorio("Clientes", "Criado em 02/02/2021", true);
        diretorios.add(diretorio);

        diretorio = new Diretorio("Planilhas", "Criado em 02/03/2021", true);
        diretorios.add(diretorio);

        diretorio = new Diretorio("Cursos", "Criado em 02/04/2021", true);
        diretorios.add(diretorio);
    }
}