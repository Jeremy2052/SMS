package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        final String first2 = firstName.getText().toString();
        final String last2 = lastName.getText().toString();
        final String Email = email.getText().toString();
        final String phone = phoneNumber.getText().toString();
        final String user = username.getText().toString();
        final String pass = password.getText().toString();

        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(TextUtils.isEmpty(first2)){
                    //first name is empty
                    Toast.makeText(getApplication(), "Enter a first name",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(last2)){
                    //first name is empty
                    Toast.makeText(getApplication(), "Enter a last name",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Email)){
                    //first name is empty
                    Toast.makeText(getApplication(), "Enter an email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(phone)){
                    //first name is empty
                    Toast.makeText(getApplication(), "Enter a phone number",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(user)){
                    //first name is empty
                    Toast.makeText(getApplication(), "Enter a username",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    //first name is empty
                    Toast.makeText(getApplication(), "Enter a password",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
