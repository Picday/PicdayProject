package com.example.bertadomingo.picday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
}