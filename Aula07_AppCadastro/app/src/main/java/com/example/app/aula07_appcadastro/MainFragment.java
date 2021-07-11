package com.example.app.aula07_appcadastro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.app.aula07_appcadastro.util.MaskEditUtil;
import com.example.app.aula07_appcadastro.util.Validation;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    EditText txtNome;
    EditText txtEmail;
    EditText txtCpf;
    Spinner spinnerSexo;
    RadioGroup rdGroup;
    RadioButton rdSelected;
    Switch switchManterConectado;
    CheckBox checkBoxOfertas;
    Button btnEnviar;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        txtNome = view.findViewById(R.id.txtNome);
        txtEmail = view.findViewById(R.id.txtEmail);
        txtCpf = view.findViewById(R.id.txtCpf);
        spinnerSexo = view.findViewById(R.id.spinnerSexo);
        rdGroup = view.findViewById(R.id.rdGroup);
        switchManterConectado = view.findViewById(R.id.switchManterConectado);
        checkBoxOfertas = view.findViewById(R.id.checkBoxOfertas);
        btnEnviar = view.findViewById(R.id.btnEnviar);

        txtCpf.addTextChangedListener(MaskEditUtil.mask(txtCpf, MaskEditUtil.FORMAT_CPF));

        List<String> arraySpiner = new ArrayList<>();
        arraySpiner.add("Opção 1");
        arraySpiner.add("Opção 2");
        ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, arraySpiner);
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSexo.setAdapter(adaptadorSpinner);

        addRadioButtons(3, rdGroup);

        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Toast.makeText(getActivity(), "Mudou a opção", Toast.LENGTH_SHORT).show();
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(txtNome.getText())) {
                    txtNome.setError("Escreva o seu nome");
                    txtNome.requestFocus();
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText()).matches()) {
                    txtEmail.setError("Insira um e-mail valido");
                    txtEmail.requestFocus();
                }

                if (!Validation.validarCPF(txtCpf.getText().toString())) {
                    txtCpf.setError("Insira um CPF valido");
                    txtCpf.requestFocus();
                }

                Toast.makeText(getActivity(), "Selecionou " + spinnerSexo.getSelectedItem(), Toast.LENGTH_SHORT).show();

                if (rdGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getActivity(), "Selecione uma opção", Toast.LENGTH_SHORT).show();
                } else {
                    int rdSelectedId = rdGroup.getCheckedRadioButtonId();
                    rdSelected = view.findViewById(rdSelectedId);
                    Toast.makeText(getActivity(), "Selecionou " + rdSelected.getText().toString(), Toast.LENGTH_SHORT).show();
                }

                if (switchManterConectado.isChecked()) {
                    Toast.makeText(getActivity(), "Switch ativado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Switch desativado", Toast.LENGTH_SHORT).show();
                }

                if (checkBoxOfertas.isChecked()) {
                    Toast.makeText(getActivity(), "Checkbox marcado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Checkbox desmarcado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void addRadioButtons(int number, RadioGroup radioGroup) {
        for (int i = 1; i <= number; i++) {
            RadioButton radioButton = new RadioButton(getActivity());
            radioButton.setId(View.generateViewId());
            radioButton.setText("Opção " + radioButton.getId());
            radioGroup.addView(radioButton);
        }
    }
}