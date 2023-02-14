package com.example.myapplication.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.adapters.EnterPagerAdapter;
import com.example.myapplication.databinding.ActivityEnterBinding;

public class EnterActivity extends AppCompatActivity {
    ActivityEnterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new Thread(() -> {
            try {
                Thread.sleep(1500);
                runOnUiThread(() -> {
                    binding.mainIcon.setVisibility(View.VISIBLE);
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        binding.pager.setAdapter(new EnterPagerAdapter(getSupportFragmentManager()));
        binding.tabs.setupWithViewPager(binding.pager);
    }
}
