package com.example.app.aula07_appcadastro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TutorialFragment extends Fragment {

    TextView txtPularTutorial;
    ViewPager2 viewPager2;
    MainFragment mainFragment;

    List<Slide> slides = new ArrayList<>();

    public TutorialFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutorial, container, false);

        txtPularTutorial = view.findViewById(R.id.txtPularTutorial);
        viewPager2 = view.findViewById(R.id.viewPager2);

        criarSlides();
        Adaptador adaptador = new Adaptador(slides);
        viewPager2.setAdapter(adaptador);

        //viewPager2.setOrientation(viewPager2.ORIENTATION_VERTICAL);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            // Chamado quando o slide é passado
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            // Chamado quando um novo slide é selecionado
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                int tamanho = slides.size();
                if (position == tamanho - 1) {
                    txtPularTutorial.setText("Iniciar");
                    //Toast.makeText(getActivity(), "Chegou no último item", Toast.LENGTH_SHORT).show();
                } else {
                    txtPularTutorial.setText("Pular Tutorial");
                }
            }

            // Chamado quando o estado do slide é alterado
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        txtPularTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFragment = new MainFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, mainFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    void criarSlides() {
        Slide slide = new Slide(R.drawable.ic_baseline_looks_one_24, "Slide 1");
        slides.add(slide);

        slide = new Slide(R.drawable.ic_baseline_looks_two_24, "Slide 2");
        slides.add(slide);

        slide = new Slide(R.drawable.ic_baseline_looks_3_24, "Slide 3");
        slides.add(slide);
    }
}