package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Receiver_Details extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText rname,raddress,remail,rmobile,rsex,rbg,rage;
    private Button rsubmit;

    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference().child("Receiver");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_receiver_details);

        rname=findViewById(R.id.R_name);
        raddress=findViewById(R.id.R_address);
        remail=findViewById(R.id.R_email);
        rmobile=findViewById(R.id.R_mobile);
        rsex=findViewById(R.id.R_sex);
        rbg=findViewById(R.id.R_bg);
        rage=findViewById(R.id.R_age);
        rsubmit=findViewById(R.id.R_submit);


        rsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Receiver_Details.this,"All Fields Are Mandatory", Toast.LENGTH_SHORT).show();
                if( TextUtils.isEmpty(rname.getText())) {
                    String R_name = rname.getText().toString();
                    rname.setError("Name is required!");
                    HashMap<String,String> ReceiverMap=new HashMap<>();
                    ReceiverMap.put("receiver_name",R_name);
                    root.push().setValue(ReceiverMap);
                }
                else if( TextUtils.isEmpty(raddress.getText())) {
                    String R_address = raddress.getText().toString();
                    raddress.setError("address is required!");
                    HashMap<String,String> ReceiverMap=new HashMap<>();
                    ReceiverMap.put("receiver_address",R_address);
                    root.push().setValue(ReceiverMap);
                }
                else if( TextUtils.isEmpty(remail.getText())) {
                    String R_email = remail.getText().toString();
                    remail.setError("email is required!");
                    HashMap<String,String> ReceiverMap=new HashMap<>();
                    ReceiverMap.put("receiver_email",R_email);
                    root.push().setValue(ReceiverMap);
                }
                else if( TextUtils.isEmpty(rmobile.getText())) {
                    String R_mobile = rmobile.getText().toString();
                    rmobile.setError("mobile is required!");
                    HashMap<String,String> ReceiverMap=new HashMap<>();
                    ReceiverMap.put("receiver_mobile",R_mobile);
                    root.push().setValue(ReceiverMap);
                }
                else if( TextUtils.isEmpty(rbg.getText())) {
                    String R_bg = rbg.getText().toString();
                    rage.setError("blood group is required!");
                    HashMap<String,String> ReceiverMap=new HashMap<>();
                    ReceiverMap.put("receiver_blood_group",R_bg);
                    root.push().setValue(ReceiverMap);
                }
                else if( TextUtils.isEmpty(rage.getText())) {
                    String R_age = raddress.getText().toString();
                    raddress.setError("age is required!");
                    HashMap<String,String> ReceiverMap=new HashMap<>();
                    ReceiverMap.put("receiver_age",R_age);
                    root.push().setValue(ReceiverMap);
                }
                else if( TextUtils.isEmpty(rsex.getText())) {
                    String R_sex = rsex.getText().toString();
                    raddress.setError("gender is required!");
                    HashMap<String,String> ReceiverMap=new HashMap<>();
                    ReceiverMap.put("receiver_address",R_sex);
                    root.push().setValue(ReceiverMap);
                }
                /*String R_email=remail.getText().toString();
                String R_mobile=rmobile.getText().toString();
                String R_sex=rsex.getText().toString();
                String R_bg=rbg.getText().toString();
                String R_age=rage.getText().toString();
                HashMap<String,String> ReceiverMap=new HashMap<>();

                ReceiverMap.put("receiver_name",R_name);
                ReceiverMap.put("receiver_address",R_address);
                ReceiverMap.put("receiver_mobile",R_mobile);
                ReceiverMap.put("receiver_email",R_email);
                ReceiverMap.put("receiver_age",R_age);
                ReceiverMap.put("receiver_gender",R_sex);
                ReceiverMap.put("receiver_Blood_Group",R_bg);*/
            else {
                    Intent intent = new Intent(getApplicationContext(), content_dashboard.class);
                    Toast.makeText(Receiver_Details.this, "You will contact soon", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    finish();
                }


                //root.push().setValue(ReceiverMap);

            }
        });
    }
   /* public void onClick(View view){
        Intent intent=new Intent(getApplicationContext(),content_dashboard.class);
        startActivity(intent);
        finish();
    }*/

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}