package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class vendorLogin extends AppCompatActivity implements View.OnClickListener {


    private EditText emailV;
    private EditText passwordV;
    private Button loginV;
    private Button signupV;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null){
            Intent intent2 = new Intent(this, vendorMainScreen.class);
            startActivity(intent2);
            finish();
        }

        emailV = findViewById(R.id.email);
        passwordV = findViewById(R.id.password);
        loginV = findViewById(R.id.login);
        signupV = findViewById(R.id.signup);

        loginV.setOnClickListener(this);
        signupV.setOnClickListener(this);

    }

    private void vendor_Login(){
        String emailv = emailV.getText().toString().trim();
        String passv = passwordV.getText().toString().trim();

        if(TextUtils.isEmpty(emailv)){
            //first name is empty
            Toast.makeText(this, "Enter an email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(passv)){
            //first name is empty
            Toast.makeText(this, "Enter a password",Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(emailv,passv).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent3 = new Intent(getApplicationContext(), vendorMainScreen.class);
                    startActivity(intent3);
                    finish();
                    ///////if login is a vendor under email used, go to main screen for vendor
                    ///////instead of customers main menu.
                }else{
                    Toast.makeText(vendorLogin.this, "Login failed",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                vendor_Login();
                break;
            case R.id.signup:
                Intent intent2 = new Intent(this, vendorRegister.class);
                startActivity(intent2);
                finish();
                break;
        }

    }
}