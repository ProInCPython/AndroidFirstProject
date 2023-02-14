package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentLoginBinding;
import com.example.myapplication.databinding.FragmentRegistrationBinding;

import java.util.Objects;

public class RegistrationFragment extends Fragment {

    private FragmentRegistrationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        binding.buttonEnter.setOnClickListener(view -> {
            String email = binding.regInputEmail.getInputText();
            String password = binding.regInputPassword.getInputText();
            String repeat_password = binding.regInputRepeatPassword.getInputText();
            String name = binding.regInputNickname.getInputText();
            if (!Objects.equals(repeat_password, password)) {
                Toast.makeText(getContext(), "Пароли не совпадают!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Здравствуйте, "+name+"!"+" email: "+email+", пароль: "+password, Toast.LENGTH_SHORT).show();
            }

        });
        return binding.getRoot();
    }
}
