package com.example.bertadomingo.picday;

        import android.location.Address;
        import android.location.Geocoder;
        import android.location.Location;
        import android.location.LocationListener;
        import android.location.LocationManager;
        import android.os.Bundle;
        import android.app.Activity;
        import android.content.Context;
        import android.text.format.Time;
        import android.util.Log;
        import android.view.Menu;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.TextView;

        import java.io.IOException;
        import java.util.List;
        import java.util.Locale;

public class GpsActivity extends Activity {

    private Button btnActualizar;
    private TextView lblFecha;
    private TextView adreca;

    private LocationManager locManager;
    private LocationListener locListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        //btnActualizar = (Button)findViewById(R.id.BtnActualizar);
        btnActualizar = (Button)findViewById(R.id.picture);
        lblFecha = (TextView) findViewById(R.id.fecha);
        adreca = (TextView) findViewById(R.id.lblAdreca);

        btnActualizar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                Time today = new  Time(Time.getCurrentTimezone());
                today.setToNow();
                int dia=today.monthDay;
                int mes = today.month;
                int any = today.year;
                mes=mes+1;
                lblFecha.setText(dia +"/" + mes + "/" + any);

                comenzarLocalizacion();
            }
        });

    }

    private void comenzarLocalizacion()
    {
        //Obtenemos una referencia al LocationManager
        locManager =
                (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        //Obtenemos la ˙ltima posiciÛn conocida
        Location loc =
                locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

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

        locManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 30000, 0, locListener);
        mostrarPosicion(loc);

    }


    private void mostrarPosicion(Location loc) {

        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(
                        loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address DirCalle = list.get(0);
                    adreca.setText(DirCalle.getLocality() + ", " + DirCalle.getCountryName());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menupicday, menu);
        return true;
    }

}
