package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class vendorMainScreen extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private Button logout;
    private Button addService;
    private Button acceptService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_main_screen);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()==null){
            Intent intent = new Intent(this, vendorLogin.class);
            startActivity(intent);
            finish();
        }

        logout = findViewById(R.id.logoutV);
        addService = findViewById(R.id.addService);
        acceptService = findViewById(R.id.acceptService);

        logout.setOnClickListener(this);
        addService.setOnClickListener(this);
        acceptService.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.logoutV:
                firebaseAuth.signOut();

                Intent intent3 = new Intent(this, vendorLogin.class);
                startActivity(intent3);
                finish();

                break;
            case R.id.addService:
                Intent servi = new Intent(this, addServices.class);
                startActivity(servi);
                break;
           // case R.id.acceptService:
                //break;
                //break;
        }
    }
}
