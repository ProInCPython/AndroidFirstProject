package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        binding.buttonEnter.setOnClickListener(view -> {
            String email = binding.inputEmail.getInputText();
            String password = binding.inputPassword.getInputText();
            Toast.makeText(getContext(), "email: "+email+", пароль: "+password, Toast.LENGTH_SHORT).show();
        });
        return binding.getRoot();
    }
}
