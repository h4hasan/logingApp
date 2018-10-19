package com.example.hmhas.chatingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StartActivity extends AppCompatActivity {

    private EditText userEmail, userPassword;
    private Button logingBtn;
    private TextView signup_tv;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        userEmail = findViewById(R.id.loging_email_et);
        userPassword = findViewById(R.id.loging_password_et);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void loging(View view) {
        String email = userEmail.getText().toString();
        String password = userPassword.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    startActivity(new Intent(StartActivity.this,MainActivity.class));
                    Toast.makeText(StartActivity.this, "Longed In", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(StartActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    public void GoToSignUpPage(View view) {
          startActivity(new Intent(StartActivity.this,RegisterActivity.class));
    }
}
