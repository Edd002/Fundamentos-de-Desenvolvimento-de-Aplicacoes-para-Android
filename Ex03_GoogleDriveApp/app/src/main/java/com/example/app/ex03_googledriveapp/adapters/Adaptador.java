package com.example.app.ex03_googledriveapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.app.ex03_googledriveapp.R;
import com.example.app.ex03_googledriveapp.model.Diretorio;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder> {

    private List<Diretorio> diretorios = new ArrayList<>();

    public Adaptador(List<Diretorio> diretorios) {
        this.diretorios = diretorios;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Diretorio diretorio = diretorios.get(position);
        holder.txtDataCriacao.setText(diretorio.getDirModDescription());
        holder.txtNomeDiretorio.setText(diretorio.getDirName());
        if (!diretorio.isDir()) {
            holder.imgIcon.setImageResource(R.drawable.ic_baseline_insert_drive_file_24);
        }
        holder.posicao = position;
    }

    @Override
    public int getItemCount() {
        return diretorios.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtNomeDiretorio;
        TextView txtDataCriacao;
        ImageView imgIcon;
        ImageView imgMore;
        int posicao;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtNomeDiretorio = itemView.findViewById(R.id.txtNomeDiretorio);
            txtDataCriacao = itemView.findViewById(R.id.txtDataCriacao);
            imgIcon = itemView.findViewById(R.id.imgIcon);
            imgMore = itemView.findViewById(R.id.imgMore);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Deseja abrir " + diretorios.get(posicao).getDirName() + "?", Toast.LENGTH_SHORT).show();
                }
            });

            imgMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Mais informações", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
