package com.samx08.animx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AnimeDetail extends AppCompatActivity {

 String AnimeTitle,AnimeInfo;
 int AnimeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_detail);

        TextView animeTitle = findViewById(R.id.animetitle);
        ImageView animeImage = findViewById(R.id.animeimage);
        TextView  animeDetails = findViewById(R.id.animedetailone);

        AnimeTitle = getIntent().getStringExtra("anime_title");
        AnimeInfo = getIntent().getStringExtra("anime_info");
        AnimeImage = getIntent().getIntExtra("anime_image",0);

        animeTitle.setText(AnimeTitle);
        animeImage.setImageResource(AnimeImage);
        animeDetails.setText(AnimeInfo);
    }
}