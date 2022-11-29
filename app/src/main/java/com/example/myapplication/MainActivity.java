package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends Activity implements View.OnClickListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("MAIN_ACT_ONCREATE", "START");
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.v("MAIN_ACT_ONCREATE", "Получаем данные из RegistrationActivity");
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        Log.v("MAIN_ACT_ONCREATE", "Выводим email на экран");
        binding.hello.setText("Hello, " + email);
        Log.v("MAIN_ACT_ONCREATE", "Присваиваем обработчик кнопке Make a Photo");
        binding.photo.setOnClickListener(this);
        Log.i("MAIN_ACT_ONCREATE", "END");
    }

    private static final int MAKE_PHOTO_REQUEST = 1;

    @Override
    public void onClick(View view) {
        Log.i("MAIN_ACT_ONCLICK", "START");
        Log.v("MAIN_ACT_ONCLICK", "Запускаем MediaStore");
        Intent intent;
        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, MAKE_PHOTO_REQUEST);
        Log.i("MAIN_ACT_ONCLICK", "END");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.i("MAIN_ACT_onActivityResult", "START");
        Log.v("MAIN_ACT_onActivityResult", "requestCode = " + requestCode +
                ", resultCode = " + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MAKE_PHOTO_REQUEST && resultCode == RESULT_OK) {
            Log.v("MAIN_ACT_onActivityResult", "Получение данных");
            Bundle extras = data.getExtras();
            Bitmap thumbnailBitmap = (Bitmap) extras.get("data");
            Log.v("MAIN_ACT_onActivityResult", "Загрузка фотографии");
            binding.image.setImageBitmap(thumbnailBitmap);
        } else {
            Log.w("MAIN_ACT_onActivityResult", "Данные НЕ получены!!");
        }
        Log.i("MAIN_ACT_onActivityResult", "END");
    }

}
