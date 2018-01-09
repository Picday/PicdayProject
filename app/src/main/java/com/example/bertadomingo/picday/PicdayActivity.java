package com.example.bertadomingo.picday;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class PicdayActivity extends AppCompatActivity {
    private GridView gridView;
    private GridAdapter adaptador;
    private ImageButton btn_camera;

    private String lblFecha;
    private String adreca;
    private LocationManager locManager;
    private LocationListener locListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picday);

        gridView = (GridView) findViewById(R.id.id_gridview);
        adaptador = new GridAdapter(this);
        gridView.setAdapter(adaptador);

        btn_camera = (ImageButton) findViewById(R.id.btn_camera);

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ActionBar", "Make a photo!");
                //guardem el dia
                Time today = new Time(Time.getCurrentTimezone());
                today.setToNow();
                int dia = today.monthDay;
                int mes = today.month;
                int any = today.year;
                mes = mes + 1;
                lblFecha = dia + "/" + mes + "/" + any;


                //guardem la localització
                //Obtenemos una referencia al LocationManager
               /* locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                //Obtenemos la ˙ltima posiciÛn conocida
                Location loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                //Mostramos la ˙ltima posiciÛn conocida
                //Nos registramos para recibir actualizaciones de la posiciÛn
                locListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        mostrarPosicion(location);
                    }
                    public void onProviderDisabled(String provider){}
                    public void onProviderEnabled(String provider){}
                    public void onStatusChanged(String provider, int status, Bundle extras){
                        Log.i("", "Provider Status: " + status);
                    }
                };

                locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 0, locListener);

                mostrarPosicion(loc); */

                //entrem a la camara
                Intent about = new Intent(getApplicationContext(), CameraActivity.class );
                startActivity(about);
            }
        });

        /*gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about = new Intent(getApplicationContext(), FotoActivity.class );
                startActivity(about);

            }
        });*/
    }

    private void mostrarPosicion(Location loc) {
        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(
                        loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address DirCalle = list.get(0);
                    adreca = (DirCalle.getLocality() + ", " + DirCalle.getCountryName());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menupicday, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.make_video){
            Log.i("ActionBar", "Make a video!");
            Intent about = new Intent(getApplicationContext(), FromActivity.class );
            startActivity(about);
            return true;
        }
        if(id == R.id.video_gallery){
            Log.i("ActionBar", "VideoGallery!");
            Intent about = new Intent(getApplicationContext(), VideoGalleyActivity.class);
            startActivity(about);
            return true;
        }
        if(id == R.id.settings){
            Log.i("ActionBar", "Settings!");
            Intent about = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(about);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}