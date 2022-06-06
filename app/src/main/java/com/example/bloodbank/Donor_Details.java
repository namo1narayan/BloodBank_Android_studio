package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.core.UserData;

import java.util.HashMap;
import java.util.Map;

public class Donor_Details extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText dname,daddress,demail,dmobile,dage,dsex,dbg;
     private Button dsubmit;
     String value;

     private FirebaseDatabase db=FirebaseDatabase.getInstance();
     private DatabaseReference root= db.getReference().child("Donors");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_donor_details);

        dname=findViewById(R.id.donor_name);
        daddress=findViewById(R.id.donor_Address);
        demail=findViewById(R.id.donor_email);
        dmobile=findViewById(R.id.donor_mobile);
        dsex=findViewById(R.id.D_sex);
        dbg=findViewById(R.id.D_bg);
        dage=findViewById(R.id.D_age);
        dsubmit=findViewById(R.id.donor_submit);

        dsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(dname.getText())) {
                    String donor_name = dname.getText().toString();
                    String donor_address = daddress.getText().toString();
                    String donor_email = demail.getText().toString();
                    String donor_mobile = dmobile.getText().toString();
                    String D_sex = dsex.getText().toString();
                    String D_bg = dbg.getText().toString();
                    String D_age = dage.getText().toString();
                    dname.setError("Name is required!");
                    demail.setError("email is required!");
                    daddress.setError("address is required!");
                    dage.setError("age is required!");
                    dsex.setError("gender is required!");
                    dmobile.setError("mobile no. is required!");
                    dbg.setError("blood group is required!"); Toast.makeText(Donor_Details.this,"All Fields Are Mandatory", Toast.LENGTH_SHORT).show();


                    HashMap<String, String> donorMap = new HashMap<>();

                    donorMap.put("donor_name", donor_name);
                    donorMap.put("donor_address", donor_address);
                    donorMap.put("donor_mobile", donor_mobile);
                    donorMap.put("donor_email", donor_email);
                    donorMap.put("donor_age", D_age);
                    donorMap.put("donor_gender", D_sex);
                    donorMap.put("donor_Blood_Group", D_bg);

                    root.push().setValue(donorMap);
                }
                else
                {
                    Intent intent=new Intent(getApplicationContext(),content_dashboard.class);
                    Toast.makeText(Donor_Details.this,"You will contact soon",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    finish();
                }
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


