package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class mainScreen extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;

    private Button Orders;
    private Button logout;
    private ImageButton appliances;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

       Toolbar toolbar = findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);


        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        Orders = findViewById(R.id.orders);
        logout = findViewById(R.id.logout);
        appliances = findViewById(R.id.appliances);

        Orders.setOnClickListener(this);
        logout.setOnClickListener(this);
        appliances.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.logout:
                firebaseAuth.signOut();
                finish();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.appliances:
                Intent intent2 = new Intent(this, appliances.class);
                startActivity(intent2);
                break;

            case R.id.orders:
                Intent order = new Intent(this, orders.class);
                startActivity(order);
                break;
        }

    }
}
