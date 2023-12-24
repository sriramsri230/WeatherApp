package com.example.indiasateliteweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

public class MapViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapdetails_activity);

        String name = getIntent().getStringExtra("NAME");
        String imageUrl = getIntent().getStringExtra("IMAGE");
        String description = getIntent().getStringExtra("DESCRIPTION");

        TextView nameTextView = findViewById(R.id.textView2);
        ImageView mapImage = findViewById(R.id.imageView2);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);



        mapImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapViewerActivity.this, MapImageViewerActivity.class);
                intent.putExtra("IMAGE_URL",imageUrl);
                startActivity(intent);
            }
        });




        nameTextView.setText(name);
        descriptionTextView.setText(description);

        // Load image from URL using Picasso (for non-GIF images)
        if (!imageUrl.endsWith(".gif")) {
            Picasso.get().load(imageUrl).into(mapImage);
        } else {
            // For GIF images, consider using a library like Glide that supports GIF
            Glide.with(this).asGif().load(imageUrl)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
            .into(mapImage);
        }
        
    }
}