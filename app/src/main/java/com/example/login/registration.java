package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class registration extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "registration";

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText phoneNumber;
    private EditText password;
    private Button signup;
    String first2, last2, Email, phone, pass;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firebaseAuth = FirebaseAuth.getInstance();

        firstName = (findViewById(R.id.first));
        lastName = (findViewById(R.id.last));
        email = (findViewById(R.id.email));
        phoneNumber = (findViewById(R.id.phonenumber));
        password = (findViewById(R.id.passwordR));
        signup = findViewById(R.id.signup);

        signup.setOnClickListener(this);
    }


    private void register(){
         first2 = firstName.getText().toString().trim();
         last2 = lastName.getText().toString().trim();
         Email = email.getText().toString().trim();
         phone = phoneNumber.getText().toString().trim();
         pass = password.getText().toString().trim();

        if(TextUtils.isEmpty(first2)){
            //first name is empty
            Toast.makeText(this, "Enter a first name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(last2)){
            //first name is empty
            Toast.makeText(this, "Enter a last name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            //first name is empty
            Toast.makeText(this, "Enter a password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Email)){
            //first name is empty
            Toast.makeText(this, "Enter an email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(phone)){
            //first name is empty
            Toast.makeText(this, "Enter a phone number",Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(Email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                if(!task.isSuccessful()){
                    Log.d(TAG, "onComplete: Failed=" + task.getException().getMessage());
                    Toast.makeText(registration.this, "Could not register, please try again",Toast.LENGTH_SHORT).show();

                }else{
                    sendUser();
                    //display registration was successful
                    Toast.makeText(registration.this, "Registration successful",Toast.LENGTH_SHORT).show();

                }
            }
        });
        
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void sendUser(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        UserInformation userInformation = new UserInformation(first2,last2,Email,phone,pass);
        myRef.setValue(userInformation);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.signup:
                register();
                break;

        }

    }


}
