package com.example.bloodbank;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class content_dashboard extends AppCompatActivity implements View.OnClickListener {

   private CardView donor11,receiver11,details11,available11,camp11,feedback11;
   Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_content_dashboard);

      // toolbar=findViewById(R.id.toolbar);
       //setSupportActionBar(toolbar);

        donor11=findViewById(R.id.donor1);
        receiver11=findViewById(R.id.receiver1);
        details11=findViewById(R.id.details1);
        available11=findViewById(R.id.availablity1);
        camp11=findViewById(R.id.camp1);
        feedback11=findViewById(R.id.feedback1);

        donor11.setOnClickListener(this);
        receiver11.setOnClickListener(this);
        details11.setOnClickListener(this);
        available11.setOnClickListener(this);
        camp11.setOnClickListener(this);
        feedback11.setOnClickListener(this);

       /* donor11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Donor_Details.class);
                finish();
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case R.id.donor1:intent=new Intent(this,Donor_Details.class);
                startActivity(intent);break;
            case R.id.receiver1:intent=new Intent(this,Receiver_Details.class);
                startActivity(intent);break;
            case R.id.details1:intent=new Intent(this,Details.class);
                startActivity(intent);break;
            case R.id.availablity1:intent=new Intent(this,Available.class);
                startActivity(intent);break;
            case R.id.camp1:intent=new Intent(this,Camp.class);
                startActivity(intent);break;
            case R.id.feedback1:intent=new Intent(this,Feedback.class);
                startActivity(intent);break;

            default:break;
        }
    }
}