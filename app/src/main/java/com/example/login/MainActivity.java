package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    // JOSH WAS HERE COMMIT TEST 2...............................................


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText email1 = (findViewById(R.id.email));
        final EditText password = (findViewById(R.id.password));
        final Button login = findViewById(R.id.login);
        final Button signup = findViewById(R.id.signup);
        final Button skip = findViewById(R.id.skip);



        login.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v){
                final String email = email1.getText().toString();
                final String pass = password.getText().toString();

                if(email.matches("jeremy") & pass.matches("123")){
                    Intent intent = new Intent(getApplicationContext(), mainScreen.class);
                    startActivity(intent);
                    finish();
                }else{
                    CharSequence text = "Login Unsuccessful";
                    int duration = Toast.LENGTH_SHORT;
                    Toast.makeText(getApplication(), text, duration).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                /*
                * Add functionality for registering
                * Check if email and phone number are in correct format
                * */
                Intent intent = new Intent(getApplicationContext(), registration.class);
                startActivity(intent);
                finish();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), mainScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
