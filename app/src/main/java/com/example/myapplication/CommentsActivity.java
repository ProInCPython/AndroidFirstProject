package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityCommentsBinding;

public class CommentsActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityCommentsBinding binding;
    private TextView name;

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            binding = ActivityCommentsBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            String data = getIntent().getStringExtra("post_name");
            name = findViewById(R.id.news_name);
            name.setText("Комментарии под " + data);
            binding.back.setOnClickListener(this);
        }

    @Override
    public void onClick(View view) {
            this.finish();
        }
}
