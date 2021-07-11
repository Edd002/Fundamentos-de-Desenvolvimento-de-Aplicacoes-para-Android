package com.example.app.aula06_recyclerviewexample.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.app.aula06_recyclerviewexample.Adaptador;
import com.example.app.aula06_recyclerviewexample.Pessoa;
import com.example.app.aula06_recyclerviewexample.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<Pessoa> pessoaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Configurar o tipo de layout a ser utilizado no Recycler View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        criarPessoas();

        // Atribuir adaptador ao RecyclerView
        Adaptador adaptador = new Adaptador(pessoaList);
        recyclerView.setAdapter(adaptador);

        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
    }

    void criarPessoas() {
        Pessoa pessoa;

        pessoa = new Pessoa("Eduardo");
        pessoaList.add(pessoa);

        pessoa = new Pessoa("José");
        pessoaList.add(pessoa);

        pessoa = new Pessoa("Antônio");
        pessoaList.add(pessoa);

        pessoa = new Pessoa("Ana");
        pessoaList.add(pessoa);

        pessoa = new Pessoa("Paula");
        pessoaList.add(pessoa);

        pessoa = new Pessoa("Eliana");
        pessoaList.add(pessoa);

        pessoa = new Pessoa("Raul");
        pessoaList.add(pessoa);
    }
}