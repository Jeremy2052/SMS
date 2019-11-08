package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username = (findViewById(R.id.username));
        final EditText password = (findViewById(R.id.password));
        final Button login = findViewById(R.id.login);
        final Button signup = findViewById(R.id.signup);
        final Button skip = findViewById(R.id.skip);

        login.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v){
                final String user = username.getText().toString();
                final String pass = password.getText().toString();

                if(user.matches("jeremy") & pass.matches("123")){
                    Intent intent = new Intent(getApplicationContext(), main_Screen.class);
                    startActivity(intent);
                }else{
                    CharSequence text = "Login Unsuccessful";
                    int duration = Toast.LENGTH_SHORT;
                    Toast.makeText(getApplication(), text, duration).show();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), registration.class);
                startActivity(intent);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), main_Screen.class);
                startActivity(intent);
            }
        });
    }
}
