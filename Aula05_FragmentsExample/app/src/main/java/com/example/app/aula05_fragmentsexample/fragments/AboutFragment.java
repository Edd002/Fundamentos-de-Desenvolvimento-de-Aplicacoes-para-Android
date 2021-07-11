package com.example.app.aula05_fragmentsexample.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app.transportadora.aula05_fragmentsexample.R;

import mehdi.sakout.aboutpage.AboutPage;

public class AboutFragment extends Fragment {

    TextView textViewSobre;

    public AboutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        // Importação de biblioteca: https://github.com/medyo/android-about-page
        View aboutPage = new AboutPage(getActivity())
                .isRTL(false)
                .setImage(R.drawable.ic_launcher_background)
                .addGroup("Connect with us")
                .addEmail("aboutt@gmail.com")
                .addWebsite("https://mehdisakout.com/")
                .addFacebook("the.medy")
                .addTwitter("medyo80")
                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addPlayStore("com.ideashower.readitlater.pro")
                .addGitHub("medyo")
                .addInstagram("medyo80")
                .create();

        return aboutPage;
    }
}