package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    }
}
