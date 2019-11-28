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

    private FirebaseAuth firebaseAuth;

    //private DatabaseReference databaseReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firebaseAuth = FirebaseAuth.getInstance();

       // databaseReference = FirebaseDatabase.getInstance().getReference();

        firstName = (findViewById(R.id.first));
        lastName = (findViewById(R.id.last));
        email = (findViewById(R.id.email));
        phoneNumber = (findViewById(R.id.phonenumber));
        password = (findViewById(R.id.passwordR));
        signup = findViewById(R.id.signup);

        signup.setOnClickListener(this);
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

       // UserInformation userInformation = new UserInformation(first2,last2,Email,phone,pass);
       // FirebaseUser user = firebaseAuth.getCurrentUser();
       // databaseReference.child("Customers").child(user).setValue(userInformation);

        firebaseAuth.createUserWithEmailAndPassword(Email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());
                if(!task.isSuccessful()){
                    Log.d(TAG, "onComplete: Failed=" + task.getException().getMessage());
                    Toast.makeText(registration.this, "Could not register, please try again",Toast.LENGTH_SHORT).show();

                }else{

                    //String userId = firebaseAuth.getCurrentUser().getUid();
                    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();

                    String first3 = firstName.getText().toString();
                    String last3 = lastName.getText().toString();
                    String Email3 = email.getText().toString();
                    String phone3 = phoneNumber.getText().toString();
                    String pass3 = password.getText().toString();

                    UserInformation userInformation = new UserInformation(first3,last3,Email3,phone3,pass3);
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    databaseReference.child("Customers").child(user.getUid()).push().setValue(userInformation);

                   /* Map newPost = new HashMap();
                    newPost.put("First", first3);
                    newPost.put("Last", last3);
                    newPost.put("Email", Email3);
                    newPost.put("Phone", phone3);
                    newPost.put("Password", pass3);

                    databaseReference.push().setValue(newPost);*/

                    //display registration was successful
                    Toast.makeText(registration.this, "Registration successful",Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
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
