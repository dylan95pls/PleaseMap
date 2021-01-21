package com.example.pleasemap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static android.widget.Toast.LENGTH_LONG;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, SensorEventListener {

        private GoogleMap mMap;

        final private int REQUEST_COURSE_ACCESS = 123;
        boolean permissionGranted = false;
        LocationManager lm;
        LocationListener locationListener;
        private SensorManager sensorManager;
        private Sensor sensor;
        private View view;
        private long lastUpdateTime;
        private static float SHAKE_THRESHHOLD_GRAVITY = 2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_maps);
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
            lastUpdateTime = System.currentTimeMillis();
        }


        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera. In this case,
         * we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to install
         * it inside the SupportMapFragment. This method will only be triggered once the user has
         * installed Google Play services and returned to the app.
         */

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

     /*   // Add a marker in Sydney and move the camera
        LatLng bca = new LatLng(55.0062, -7.3236);
        mMap.addMarker(new MarkerOptions().position(bca).title("Ulster uni"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bca));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bca, 12.0f));*/

            Geocoder geoCoders = new Geocoder(getBaseContext(), Locale.getDefault());
            try {
                String FocusAddress = "Northland Rd, Londonderry BT48 7JL";
                String FocusName = "Ulster uni";
                // String placeName = "150 Strand Rd, Londonderry BT48 7TL";
                List<Address> addresses = geoCoders.getFromLocationName(FocusAddress, 1);
                Address address = addresses.get(0);
                String add = "";
                if (addresses.size() > 0) {
                    for (int i = 0; i <= address.getMaxAddressLineIndex(); i++)
                        add += address.getAddressLine(i) + "\n";
                    LatLng p = new LatLng(address.getLatitude(), address.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(p).title(FocusName));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p, 2.0f));
                }
                // Toast.makeText(getBaseContext(), add, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //GETTING ALL ADDRESSES
            //
            //
            //
            //
            //
            //
            //
            //
            Geocoder geoCoder = new Geocoder(getBaseContext(), Locale.getDefault());
            try {
                String[] addressArray = {"Bishop Street BT48 6PR", "Carlisle Road BT48 6JW", "Foyle Road BT48 6XB", "Foyle Valley Railway", "Foyle Street BT48 6AT", "Queens Quay BT 48 7AS", "Society Street BT48 6PJ", "Spencer Road Londonderry", "Strand Road BT487AL", "Victoria Market Derry/Londonderry", "William Street Derry/Londonderry", "Butcher Street Strabane", "Lower Main Street Strabane", "Upper Main Street Strabane", "Market Square Claudy", "Meetinghouse Lane Castlederg", "William Street Castlederg", "Priest’s Lane Castlederg", "Albert Street Castlederg", "Simpson’s Brae Derry/Londonderry", "Waterside Railway Station Derry/Londonderry", "Shantallow Derry/Londonderry", "Berryhill Road Donemana", "Townhall Street West Newtownstewart", "Upper Main Street Strabane", "Bowling Green Strabane", "Mill Street Strabane", "Canal Basin North Strabane", "Canal Basin (Dock Street)Strabane", "Railway Street, Strabane"};
                String[] nameArray = {"Bishops Street", "Carlisle Road", "Foyle Road", "Foyle Valley", "Foyle Street", "Queens Quay", "Society Street", "Spencer Road", "Strand Road", "Victoria market", "William Street", "Butcher Street", "Lower Main Street", "Upper Main Street", "Market Square", "Meetinghouse Lane", "William Street", "Priest's Lane", "Albert Street", "Simpson's Brae", "Waterside Railway", "Shantallow", "Bennyhill Road", "Townhall Street", "Upper Main Street", "Bowling Green", "Mill Street", "Canal Basin North", "Canal Basin(Dock Street)", "Railway Street"};
                for (int q = 0; q < 30; q++) {
                    List<Address> addresses = geoCoder.getFromLocationName(addressArray[q], 1);
                    Address address = addresses.get(0);
                    String add = "";
                    if (addresses.size() > 0) {
                        for (int i = 0; i <= address.getMaxAddressLineIndex(); i++)
                            add += address.getAddressLine(i) + "\n";
                        LatLng p = new LatLng(address.getLatitude(), address.getLongitude());
                        mMap.addMarker(new MarkerOptions().position(p).title(nameArray[q]));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p, 20.0f));
                    }
                }
                // Toast.makeText(getBaseContext(), add, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //
            //
            //
            //
            Geocoder geoCoderz = new Geocoder(getBaseContext(), Locale.getDefault());
            try {
                Bundle bundle = getIntent().getExtras();
                String FocusAddress = bundle.getString("FocusAddress");
                String FocusName = bundle.getString("FocusName");
                List<Address> addresses = geoCoderz.getFromLocationName(FocusAddress, 1);
                Address address = addresses.get(0);
                String add = "";
                if (addresses.size() > 0) {
                    for (int i = 0; i <= address.getMaxAddressLineIndex(); i++)
                        add += address.getAddressLine(i) + "\n";
                    LatLng p = new LatLng(address.getLatitude(), address.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(p).title(FocusName));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p, 16.0f));
                }
                // Toast.makeText(getBaseContext(), add, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //
            //
            //
            //
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng point) {
                }
            });
            lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationListener = new MyLocationListener();

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{
                        android.Manifest.permission.ACCESS_COARSE_LOCATION
                }, REQUEST_COURSE_ACCESS);
                return;
            } else {
                permissionGranted = true;
            }
            if (permissionGranted) {
                lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
            }
            Toast.makeText(this, "Shake to reset map", Toast.LENGTH_SHORT).show();
        }

        private class MyLocationListener implements LocationListener {

            @Override
            public void onLocationChanged(Location location) {
                if (location != null) {
                    Toast.makeText(getBaseContext(), "Current Location: Lat: " + location.getLatitude() + " Lng: " + location.getLongitude(), LENGTH_LONG).show();
                    LatLng p = new LatLng(location.getLatitude(), location.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(p).title("Current Location"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p, 12.0f));
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        }

        public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantResults) {
            switch (requestCode) {
                case REQUEST_COURSE_ACCESS:
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        permissionGranted = true;
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                                != PackageManager.PERMISSION_GRANTED
                                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                                != PackageManager.PERMISSION_GRANTED) {
                            return;
                        }
                        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                    } else {
                        permissionGranted = false;
                    }
                    break;
                default:
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);

            }
        }

        @Override
        public void onPause() {
            super.onPause();
            sensorManager.unregisterListener(this);
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.ACCESS_COARSE_LOCATION
                }, REQUEST_COURSE_ACCESS);
                return;
            } else {
                permissionGranted = true;
            }
            if (permissionGranted) {
                lm.removeUpdates(locationListener);
            }
        }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            getAccelerometer(event);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
        private void getAccelerometer(SensorEvent event) {
            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];

            float gX = x / SensorManager.GRAVITY_EARTH;
            float gY = y / SensorManager.GRAVITY_EARTH;
            float gZ = z / SensorManager.GRAVITY_EARTH;

            float gForce = (float) Math.sqrt(gX * gX + gY * gY + gZ * gZ);

            long currentTime = System.currentTimeMillis();
            if (event.values[0] >= SHAKE_THRESHHOLD_GRAVITY) {
                if (currentTime - lastUpdateTime < 200) {
                    return;
                }
                lastUpdateTime = currentTime;
                Toast.makeText(this, "Resetting map", Toast.LENGTH_SHORT).show();
                Geocoder geoCoderz = new Geocoder(getBaseContext(), Locale.getDefault());
                try {
                    Bundle bundle = getIntent().getExtras();
                    String FocusAddress = bundle.getString("FocusAddress");
                    String FocusName = bundle.getString("FocusName");
                    List<Address> addresses = geoCoderz.getFromLocationName(FocusAddress, 1);
                    Address address = addresses.get(0);
                    String add = "";
                    if (addresses.size() > 0) {
                        for (int i = 0; i <= address.getMaxAddressLineIndex(); i++)
                            add += address.getAddressLine(i) + "\n";
                        LatLng p = new LatLng(address.getLatitude(), address.getLongitude());
                        mMap.addMarker(new MarkerOptions().position(p).title(FocusName));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p, 16.0f));
                    }
                    // Toast.makeText(getBaseContext(), add, Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onResume() {
            super.onResume();
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        }
}
