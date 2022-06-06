package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;
import static android.util.Patterns.EMAIL_ADDRESS;

public class Sign_up extends AppCompatActivity {
    private EditText inputEmail, inputPassword,mobile,name;
    private Button  btnSignUp ;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private FirebaseFirestore firebaseFirestore;
    String id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();

        name=findViewById(R.id.fullname);
        mobile=findViewById(R.id.inputMobile);
        //btnSignIn = (Button) findViewById(R.id.signin);
        btnSignUp = (Button) findViewById(R.id.signup1);
        inputEmail = (EditText) findViewById(R.id.username);
        inputPassword = (EditText) findViewById(R.id.password);
        progressBar=findViewById(R.id.progressBar);

        if(auth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),login.class));
            finish();;
        }

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                String password= inputPassword.getText().toString().trim();
                String fullname=name.getText().toString();
                String contact=mobile.getText().toString();

                if(email.isEmpty())
                {
                    inputEmail.setError("Email is Required");
                    inputEmail.requestFocus();
                    return;
                }
                if(!EMAIL_ADDRESS.matcher(email).matches())
                {
                    inputEmail.setError("Enter the valid email address");
                    inputEmail.requestFocus();
                    return;
                }
                if(password.isEmpty())
                {
                    inputPassword.setError("Enter the password");
                    inputPassword.requestFocus();
                    return;
                }
                if(password.length()<6)
                {
                    inputPassword.setError("Length of the password should be more than 6");
                    inputPassword.requestFocus();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Sign_up.this,"You are successfully Registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Sign_up.this, login.class));
                            id=auth.getCurrentUser().getUid();
                            DocumentReference documentReference=firebaseFirestore.collection("users").document(id);
                            Map<String,Object> user=new HashMap<>();
                            user.put("fName",fullname);
                            user.put("Mobile",contact);
                            user.put("Email",email);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d("Tag","on sucess:User Profile is Created For" + id);
                                }
                            });
                           // startActivity(new Intent(getApplicationContext(),login.class));
                        }
                        else
                        {
                            startActivity(new Intent(Sign_up.this, login.class));
                            Toast.makeText(Sign_up.this,"You are already Registered!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }
}