package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final EditText firstName = (findViewById(R.id.first));
        final EditText lastName = (findViewById(R.id.last));
        final EditText email = (findViewById(R.id.email));
        final EditText phoneNumber = (findViewById(R.id.phonenumber));
        final EditText username = (findViewById(R.id.usernameR));
        final EditText password = (findViewById(R.id.passwordR));

        Button signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
