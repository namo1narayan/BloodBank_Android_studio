package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Feedback extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    RatingBar rb1,rb2,rb3;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_feedback);

        rb1=findViewById(R.id.dc);
        rb2=findViewById(R.id.ba);
        rb3=findViewById(R.id.oas);
        submit=findViewById(R.id.f_submit);

        submit.setOnClickListener(new View.OnClickListener() {

            //Intent intent=new Intent(getApplicationContext(),Feedback.class);
                //Toast.makeText(Feedback.this,"You will contact soon",Toast.LENGTH_LONG).show();
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Feedback.this,content_dashboard.class));
                Toast.makeText(getApplicationContext(),"Thank You",Toast.LENGTH_LONG).show();
                finish();
                String s1=String.valueOf(rb1.getRating());
               // Toast.makeText(getApplicationContext(),s1+"Star",Toast.LENGTH_SHORT).show();
                String s2=String.valueOf(rb2.getRating());
               // Toast.makeText(getApplicationContext(),s2+"Star",Toast.LENGTH_SHORT).show();
                String s3=String.valueOf(rb3.getRating());
               // Toast.makeText(getApplicationContext(),s3+"Star",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}