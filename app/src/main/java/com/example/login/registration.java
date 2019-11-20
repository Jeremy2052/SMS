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

public class registration extends AppCompatActivity implements View.OnClickListener {
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText phoneNumber;
    private EditText password;
    private Button signup;
    private Button vendorB;

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
        vendorB = findViewById(R.id.vendorB);

        signup.setOnClickListener(this);
        vendorB.setOnClickListener(this);

    }

    private void register(){
        String first2 = firstName.getText().toString().trim();
        String last2 = lastName.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String phone = phoneNumber.getText().toString().trim();
        String pass = password.getText().toString().trim();

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
                if(task.isSuccessful()){
                    //display registration was successful
                    Toast.makeText(registration.this, "Register successful",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(registration.this, "Could not register, please try again",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onClick(View v) {
        if(v == signup){
            register();
        }
        if(v == vendorB){
            Intent intent = new Intent(this, vendorRegister.class);
            startActivity(intent);
            finish();
        }
    }


}
