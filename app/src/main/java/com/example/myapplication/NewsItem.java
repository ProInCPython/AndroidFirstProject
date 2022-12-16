package com.example.myapplication;

import android.graphics.Bitmap;

public class NewsItem {
    public final String name;
    public final String description;
    public int likes;
    public boolean isClicked;
    public int photoId;

    public NewsItem(String name, String description, int likes, int photoId, boolean isClicked) {
        this.name = name;
        this.likes = likes;
        this.photoId = photoId;
        this.description = description;
        this.isClicked = isClicked;
    }

    public void like() {
        if (isClicked) {
            likes--;
        } else {
            likes++;
        }
        isClicked = !isClicked;
    }




}
