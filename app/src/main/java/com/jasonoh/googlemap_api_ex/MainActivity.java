package com.jasonoh.googlemap_api_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    GoogleMap Gmap;

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.map_relative);

        SupportMapFragment supportMapFragment = new SupportMapFragment();
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Gmap = googleMap;

                LatLng latLng = new LatLng(37.5, 126.2);

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position( latLng );
                markerOptions.title( "Seoul" );
                markerOptions.snippet( "대한민국 수도" );

                Gmap.addMarker( markerOptions );
            }
        });
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().add(R.id.map_relative, supportMapFragment);
        transaction.commit();

        //xml에 fragment가 있을경우 사용

//        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById( R.id.frag_map );
//        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(GoogleMap googleMap) {
//                Gmap = googleMap;
//
//                LatLng latLng = new LatLng(37.5, 126.2);
//
//                MarkerOptions markerOptions = new MarkerOptions();
//                markerOptions.position( latLng );
//                markerOptions.title( "Seoul" );
//                markerOptions.snippet( "대한민국" );
//
//                Gmap.addMarker( markerOptions );
//
//            }
//        });



    }//onCreate method
}//MainActivity class
