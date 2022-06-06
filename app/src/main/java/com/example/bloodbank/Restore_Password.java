package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Restore_Password extends AppCompatActivity {
    Button resetbtn;
    EditText useremail;
    private FirebaseAuth mAuth;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_restore_password);

        mAuth = FirebaseAuth.getInstance();
        pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.setCancelable(true);
        pd.setCanceledOnTouchOutside(false);

        useremail = findViewById(R.id.resetUsingEmail);

        findViewById(R.id.resetPassbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseUser user = mAuth.getCurrentUser();

                final String email = useremail.getText().toString();

                if(TextUtils.isEmpty(email))
                {
                    useremail.setError("Email required!");
                }
                else
                {
                    pd.show();
                    mAuth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(getApplicationContext(), "We have sent an email to "+" '"+ email +"'. Please check your email.", Toast.LENGTH_LONG)
                                                .show();
                                        startActivity(new Intent(getApplicationContext(), login.class));
                                        //useremail.setText(null);
                                    }
                                    else
                                    {
                                        Toast.makeText(getApplicationContext(), "Sorry, There is something went wrong. please try again some time later.", Toast.LENGTH_LONG)
                                                .show();
                                        useremail.setText(null);
                                    }
                                    pd.dismiss();
                                }
                            });
                }
            }

        });
    }

   /* public void onClick(View view) {
        button = findViewById(R.id.ResetPasswordbtn);
        Toast.makeText(this, "Check Your Email", Toast.LENGTH_LONG).show();
        startActivity(new Intent(Restore_Password.this, login.class));
    }*/
}