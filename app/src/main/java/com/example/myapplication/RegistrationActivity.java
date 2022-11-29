package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityRegistrationBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("REG_ACT_ONCREATE", "START");
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.v("REG_ACT_ONCREATE", "Присваиваем обработчик кнопке Register");
        binding.register.setOnClickListener(this);
        Log.i("REG_ACT_ONCREATE", "END");
    }

    @Override
    public void onClick(View view) {
        Log.i("REG_ACT_ONCLICK", "START");
        Intent intent;
        Log.v("REG_ACT_ONCLICK", "Создание переменных с данными из EditText");
        String email = String.valueOf(binding.email.getText());
        String password = String.valueOf(binding.password.getText());
        switch (view.getId()) {
            case R.id.register:
                Log.v("REG_ACT_ONCLICK", "Нажата кнопка регистрация");
                if (password.length() <= 8) {
                    Toast.makeText(this, "Пароль должен содержать больше 8 символов!", Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    Log.v("REG_ACT_ONCLICK", "Пароль больше 8 символов");
                    if (email.equals("rickroll@gmail.com")) {
                        if (!password.equals("RickAstley")) {
                            Toast.makeText(this, "Неверный пароль!", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                }
                Log.v("REG_ACT_ONCLICK", "Запуск Главного Экрана");
                intent = new Intent(RegistrationActivity.this, MainActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);
                Log.i("REG_ACT_ONCLICK", "END");
        }
    }
}