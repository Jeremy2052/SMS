package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class mainScreen extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;

    private Button back;
    private Button Orders;
    private Button logout;
    private Button settingB;
    private ImageButton appliances;
    private ImageButton electrical;
    private ImageButton plumbing;
    private ImageButton home_cleaning;
    private ImageButton tutoring;
    private ImageButton packaging_moving;
    private ImageButton computer_repair;
    private ImageButton home_repair;
    private ImageButton pest_control;

    private TextView displayUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

      // Toolbar toolbar = findViewById(R.id.toolbar);
      // setSupportActionBar(toolbar);



        settingB = findViewById(R.id.settingB);
        back = findViewById(R.id.backB);
        Orders = findViewById(R.id.orders);
        logout = findViewById(R.id.logout);
        appliances = findViewById(R.id.appliances);
        electrical = findViewById(R.id.electrical);
        plumbing = findViewById(R.id.plumbing);
        home_cleaning = findViewById(R.id.homeCleaning);
        tutoring = findViewById(R.id.tutoring);
        packaging_moving = findViewById(R.id.packaging);
        computer_repair = findViewById(R.id.computer);
        home_repair = findViewById(R.id.homeRepair);
        pest_control = findViewById(R.id.pestControl);
        displayUser = findViewById(R.id.displayUser);

        /*if(firebaseAuth.getCurrentUser()!=null){
           // displayUser.setText(user.getEmail());
        }*/


        settingB.setOnClickListener(this);
        back.setOnClickListener(this);
        Orders.setOnClickListener(this);
        logout.setOnClickListener(this);
        appliances.setOnClickListener(this);
        electrical.setOnClickListener(this);
        plumbing.setOnClickListener(this);
        home_cleaning.setOnClickListener(this);
        tutoring.setOnClickListener(this);
        packaging_moving.setOnClickListener(this);
        computer_repair.setOnClickListener(this);
        home_repair.setOnClickListener(this);
        pest_control.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.logout:
                 firebaseAuth = FirebaseAuth.getInstance();
                //FirebaseUser user = firebaseAuth.getCurrentUser();
                if(firebaseAuth.getCurrentUser()!=null){
                    firebaseAuth.signOut();
                    finish();
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.appliances:
                Intent appliance = new Intent(this, appliances.class);
                startActivity(appliance);
                break;
            case R.id.electrical:  // BUG: Doesn't open up electrical activity
                Intent electrical = new Intent(this, electrical.class);
                startActivity(electrical);
                break;
            case R.id.plumbing:
                Intent plumbing = new Intent(this, plumbing.class);
                startActivity(plumbing);
                break;
            case R.id.homeCleaning:
                Intent home_cleaning = new Intent(this, home_cleaning.class);
                startActivity(home_cleaning);
                break;
            case R.id.tutoring:
                Intent tutoring = new Intent(this, tutoring.class);
                startActivity(tutoring);
                break;
            case R.id.packaging:
                Intent packaging_moving = new Intent(this, packaging_moving.class);
                startActivity(packaging_moving);
                break;
            case R.id.orders:
                Intent order = new Intent(this, orders.class);
                startActivity(order);
                break;
            case R.id.computer:
                Intent computer_repair = new Intent(this, computer_repair.class);
                startActivity(computer_repair);
                break;
            case R.id.homeRepair:
                Intent home_repair = new Intent(this, home_repair.class);
                startActivity(home_repair);
                break;
            case R.id.pestControl:
                Intent pest_control = new Intent(this, pest_control.class);
                startActivity(pest_control);
                break;
            case R.id.backB:
                //Intent back = new Intent(this, MainActivity.class);
                //startActivity(back);
                finish();
                break;
            case R.id.settingB:
                Intent sett = new Intent(this, settings.class);
                startActivity(sett);
                finish();
                break;

        }

    }
}
