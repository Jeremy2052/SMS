package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private EditText emaill;
        private EditText password;
        private Button login;
        private Button signup;
        private Button skip;
        private Button vendorLogin;

        private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null){
            Intent intent2 = new Intent(MainActivity.this, mainScreen.class);
            startActivity(intent2);
            finish();
        }

        emaill = (findViewById(R.id.email));
        password = (findViewById(R.id.password));
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        skip = findViewById(R.id.skip);
        vendorLogin = findViewById(R.id.vendorLogin);

        vendorLogin.setOnClickListener(this);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
        skip.setOnClickListener(this);


    }

    private void userLogin(){
        String email2 = emaill.getText().toString().trim();
        String pass2 = password.getText().toString().trim();

        if(TextUtils.isEmpty(email2)){
            //first name is empty
            Toast.makeText(this, "Enter an email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass2)){
            //first name is empty
            Toast.makeText(this, "Enter a password",Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email2,pass2).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent3 = new Intent(getApplicationContext(), mainScreen.class);
                    startActivity(intent3);
                    finish();
                    ///////if login is a vendor under email used, go to main screen for vendor
                    ///////instead of customers main menu.
                }else{
                    Toast.makeText(MainActivity.this, "Login failed",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login:
                userLogin();
                break;
            case R.id.signup:
                Intent intent = new Intent(MainActivity.this, registration.class);
                startActivity(intent);
                finish();
                break;
            case R.id.skip:
                Intent intent2 = new Intent(MainActivity.this, mainScreen.class);
                startActivity(intent2);
                finish();
                break;

            case R.id.vendorLogin:
                Intent intent3 = new Intent(MainActivity.this, vendorLogin.class);
                startActivity(intent3);
                finish();
        }
    }
}
