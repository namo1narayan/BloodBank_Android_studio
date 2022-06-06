package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    Button sign_in,sign_up,resetpassword;
    private EditText inputemail,inputpassword;
    private FirebaseAuth Auth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);

        Auth=FirebaseAuth.getInstance();
        if (Auth.getCurrentUser() !=null)
        {
            Intent intent=new Intent(getApplicationContext(),content_dashboard.class);
            startActivity(intent);
            finish();
        }
        inputemail = findViewById(R.id.username);
        inputpassword = findViewById(R.id.password);

        sign_in = findViewById(R.id.signin);
        sign_up = findViewById(R.id.signup);
        resetpassword = findViewById(R.id.forget_password);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = inputemail.getText().toString()+"";
                final String password = inputpassword.getText().toString()+"";

                try {
                    if(password.length()>0 && email.length()>0) {
                        progressDialog.show();
                        Auth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (!task.isSuccessful()) { Toast.makeText(getApplicationContext(),
                                                  "Invalid Email/password", Toast.LENGTH_LONG).show();
                                            Log.v("error", task.getException().getMessage());
                                        } else {
                                            Intent intent = new Intent(getApplicationContext(), login.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                        progressDialog.dismiss();
                                    }
                                });
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Please fill all the field.", Toast.LENGTH_LONG).show();
                    }

                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        /*sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Sign_up.class);
                startActivity(intent);
            }*/
       // });

        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Restore_Password.class);

                startActivity(intent);
            }
        });


    }
   public void onClick (View view){
        sign_up=findViewById(R.id.signup);
        startActivity(new Intent(login.this,Sign_up.class));
        finish();
    }
  
}