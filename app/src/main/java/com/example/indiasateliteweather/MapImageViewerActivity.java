package com.example.indiasateliteweather;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

public class MapImageViewerActivity extends AppCompatActivity {

    private ScaleGestureDetector scaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);

        imageView = findViewById(R.id.imageViewFullSize);
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        String imageUrl = getIntent().getStringExtra("IMAGE_URL");

        // Load image from URL using Picasso (for non-GIF images)
        if (!imageUrl.endsWith(".gif")) {
            Picasso.get().load(imageUrl).into(imageView);
        } else {
            // For GIF images, consider using a library like Glide that supports GIF
            Glide.with(this).asGif().load(imageUrl)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(imageView);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        scaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private float MIN_SCALE_FACTOR =0.5f;
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(MIN_SCALE_FACTOR,Math.min(mScaleFactor,10.0f));

            // Apply the scale factor to the ImageView
            imageView.setScaleX(mScaleFactor);
            imageView.setScaleY(mScaleFactor);

            return true;
        }
    }
}
