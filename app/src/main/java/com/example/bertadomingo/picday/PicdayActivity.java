package com.example.bertadomingo.picday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

public class PicdayActivity extends AppCompatActivity{
    private GridView gridView;
    private GridAdapter adaptador;
    private ImageButton btn_camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picday);

        gridView = (GridView) findViewById(R.id.id_gridview);
        adaptador = new GridAdapter(this);
        gridView.setAdapter(adaptador);

        btn_camera =  (ImageButton) findViewById(R.id.btn_camera);

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ActionBar", "Make a video!");
                //Aqui hem de posar com entrar a la camera per a fer la foto
                Intent about = new Intent(getApplicationContext(), CameraActivity.class );
                startActivity(about);
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menupicday, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.make_video){
            // lo ideal aquí sería hacer un intent para abrir una nueva clase como lo siguiente
            Log.i("ActionBar", "Make a video!");
            Intent about = new Intent(getApplicationContext(), DayActivity.class );
            startActivity(about);
            return true;
        }
        if(id == R.id.video_gallery){
            // lo ideal aquí sería hacer un intent para abrir una nueva clase como lo siguiente
            Log.i("ActionBar", "VideoGallery!");
            Intent about = new Intent(getApplicationContext(), VideoGalleyActivity.class);
            startActivity(about);
            return true;
        }
        if(id == R.id.settings){
            // lo ideal aquí sería hacer un intent para abrir una nueva clase como lo siguiente
            Log.i("ActionBar", "Settings!");
            Intent about = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(about);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}