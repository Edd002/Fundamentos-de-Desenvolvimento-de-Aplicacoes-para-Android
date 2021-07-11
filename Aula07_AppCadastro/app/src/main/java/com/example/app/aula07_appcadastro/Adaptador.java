package com.example.app.aula07_appcadastro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyPagerViewHolder> {

    List<Slide> slides = new ArrayList<>();

    public Adaptador(List<Slide> slides) {
        this.slides = slides;
    }

    @Override
    public MyPagerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slide, parent, false);
        return new MyPagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyPagerViewHolder holder, int position) {
        Slide slide = slides.get(position);
        holder.tutorialTxtDescricao.setText(slide.getDescricao());
        holder.tutorialImg.setImageResource(slide.getImgRes());
    }

    @Override
    public int getItemCount() {
        return slides.size();
    }

    public class MyPagerViewHolder extends RecyclerView.ViewHolder {

        ImageView tutorialImg;
        TextView tutorialTxtDescricao;

        public MyPagerViewHolder(View itemView) {
            super(itemView);

            tutorialImg = itemView.findViewById(R.id.tutorialImg);
            tutorialTxtDescricao = itemView.findViewById(R.id.tutorialTxtDescricao);
        }
    }
}
