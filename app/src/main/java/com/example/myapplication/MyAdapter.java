package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.example.myapplication.databinding.ListitemBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<NewsItem> {
    private final NewsItem[] newsList;

    public MyAdapter(@NonNull Context context, NewsItem[] newsList) {
        super(context, R.layout.listitem);
        this.newsList = newsList;
    }

    @Override
    public int getCount() {
        return newsList.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        NewsItem newsItem = newsList[position];
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem, null);
        }

        ListitemBinding binding = ListitemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        binding.name.setText(newsItem.name);
        binding.likeButton.setText(String.valueOf(newsItem.likes));
        binding.description.setText(String.valueOf(newsItem.description));
        binding.photo.setImageResource(newsItem.photoId);

//        TextView newsName = convertView.findViewById(R.id.name);
//        newsName.setText(newsItem.name);
//
//        TextView newsDescription = convertView.findViewById(R.id.description);
//        newsDescription.setText(String.valueOf(newsItem.description));
//
//        ImageView photo = (ImageView) convertView.findViewById(R.id.photo);
//
//        switch(position) {
//            case 0:
//            case 1:
//                photo.setImageResource(R.drawable.news1);
//                break;
//            case 2:
//            case 3:
//                photo.setImageResource(R.drawable.news2);
//                break;
//            case 4:
//            case 5:
//                photo.setImageResource(R.drawable.news3);
//                break;
//            case 6:
//            case 7:
//                photo.setImageResource(R.drawable.news4);
//                break;
//        }

        binding.likeButton.setText(newsItem.likes + "");
        binding.likeButton.setBackgroundResource(newsItem.isClicked ? R.drawable.likeclicked : R.drawable.like);
        binding.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsItem.like();
                binding.likeButton.setText(newsItem.likes + "");
                binding.likeButton.setBackgroundResource(newsItem.isClicked ? R.drawable.likeclicked : R.drawable.like);
                notifyDataSetInvalidated();
//                int count;
//                boolean flag = newsItem.isClicked;
//                if (flag) {
//                    count = newsItem.likes - 1;
//                    like.setBackgroundResource(R.drawable.like);
//                    flag = false;
//                } else {
//                    count = newsItem.likes + 1;
//                    like.setBackgroundResource(R.drawable.likeclicked);
//                    flag = true;
//                }
//                newsItem.likes = count;
//                newsItem.isClicked = flag;
            }
        });

        binding.commentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(getContext(), CommentsActivity.class);
                intent.putExtra("post_name", newsItem.name);
                getContext().startActivity(intent);
            }
        });

        binding.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Эта функция будет добавлена позже!", Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }
}
