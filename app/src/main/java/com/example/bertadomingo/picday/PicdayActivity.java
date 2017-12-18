package com.example.bertadomingo.picday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

public class PicdayActivity extends AppCompatActivity{
    private GridView gridView;
    private GridAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picday);

        gridView = (GridView) findViewById(R.id.id_gridview);
        adaptador = new GridAdapter(this);
        gridView.setAdapter(adaptador);
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menupicday, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        /*if(id == R.id.videomaker){
            // lo ideal aquí sería hacer un intent para abrir una nueva clase como lo siguiente
            Log.i("ActionBar", "Settings!");
            Intent about = new Intent(getApplicationContext(), About.class);
            startActivity(about);
            return true;
        }
        return super.onOptionsItemSelected(item);*/
        return true;
    }
}