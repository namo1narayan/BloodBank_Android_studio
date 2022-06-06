package com.example.bloodbank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.firebase.auth.FirebaseAuth;

public class Details extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{
    Button logout,hospital,bloodbank;
    FirebaseAuth firebaseAuth;
    //GoogleMap map1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_details);
       // firebaseAuth=FirebaseAuth.getInstance().signOut();

        logout=findViewById(R.id.Logout);
        hospital=findViewById(R.id.map);
        bloodbank=findViewById(R.id.bloodbank);
        logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Details.this, login.class));
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onProfile(View view){
        Intent intent=new Intent(getApplicationContext(),Profile.class);
        startActivity(intent);
        finish();
    }

    public void map(View view){
        Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(intent);
        finish();
    }

    public void bloodbank(View view){
        Toast.makeText(Details.this,"Feature is coming soon", Toast.LENGTH_SHORT).show();
    }
}