package com.androidapp.locproviderinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView txtInfo;
    LocationManager locManager;
    List<String> locProviderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInfo = findViewById(R.id.txtInfo);
        locManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        locProviderList = locManager.getAllProviders();
        txtInfo.setText("");

        for(String locProName : locProviderList){
            txtInfo.append("Loc. Provider: " + locProName + "\n");
            txtInfo.append("Enabled: " + locManager.isProviderEnabled(locProName) + "\n\n");
        }
    }
}