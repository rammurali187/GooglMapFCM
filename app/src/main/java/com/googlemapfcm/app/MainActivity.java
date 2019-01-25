package com.googlemapfcm.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
   DatabaseReference databaseref;
   EditText edtname;
   EditText edtlatitude;
   EditText edtlongitude;
   Button btnsave;
   Button btngomap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseref = FirebaseDatabase.getInstance().getReference().child("Locations");
        edtname = (EditText)findViewById(R.id.edtname);
        edtlatitude = (EditText)findViewById(R.id.edtlatitude);
        edtlongitude = (EditText)findViewById(R.id.edtlogitude);
        btnsave = (Button) findViewById(R.id.btnsave);
        btngomap = (Button)findViewById(R.id.btnmap);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            LocationInformation locinfo = new LocationInformation(edtname.getText().toString(), Double.parseDouble(edtlatitude.getText().toString().trim()),Double.parseDouble(edtlongitude.getText().toString().trim()));
            databaseref.child(edtname.getText().toString()).setValue(locinfo);
            edtname.getText().clear();
            edtlatitude.getText().clear();
            edtlongitude.getText().clear();
                Toast.makeText(MainActivity.this,"Location Saved Successfully",Toast.LENGTH_LONG).show();
            }
        });

        btngomap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MapViewActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
