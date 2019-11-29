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
    String firstc, lastc, Emailc, phonec, passc;

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
         firstc = firstName.getText().toString();
         lastc = lastName.getText().toString();
         Emailc = email.getText().toString();
         phonec = phoneNumber.getText().toString();
         passc = password.getText().toString();

        if(TextUtils.isEmpty(firstc)){
            //first name is empty
            Toast.makeText(this, "Enter a first name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(lastc)){
            //first name is empty
            Toast.makeText(this, "Enter a last name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(passc)){
            //first name is empty
            Toast.makeText(this, "Enter a password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Emailc)){
            //first name is empty
            Toast.makeText(this, "Enter an email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(phonec)){
            //first name is empty
            Toast.makeText(this, "Enter a phone number",Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(Emailc,passc).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                if(!task.isSuccessful()){
                    Log.d(TAG, "onComplete: Failed=" + task.getException().getMessage());
                    Toast.makeText(registration.this, "Could not register, please try again",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(registration.this, "Registration successful",Toast.LENGTH_SHORT).show();
                    sendUser();
                    //display registration was successful


                }
            }
        });
        
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void sendUser(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef2 = firebaseDatabase.getReference(firebaseAuth.getUid());
        UserInformation userInformation = new UserInformation(firstc,lastc,Emailc,phonec,passc);
        myRef2.setValue(userInformation);
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
