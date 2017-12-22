package com.example.bertadomingo.picday;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.VideoView;

public class VideoGalleyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_galley);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_video_galley);

                VideoView videoView = (VideoView) findViewById(R.id.videoView_video);

        //pujar un video i cargar-lo aqui!!
        /*
                Uri path = Uri.parse("android.resource://com.example.reproducirvideo/"
                        + R.raw.VideoExample);
                videoView.setVideoURI(path);
                videoView.start();*/
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
