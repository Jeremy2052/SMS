package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class vendorRegister extends AppCompatActivity implements View.OnClickListener {

    private EditText vendor;
    private EditText email;
    private EditText phonenumber;
    private EditText password;
    private EditText address, city, zipcode;
    private Spinner states;

    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_register);

        vendor = (findViewById(R.id.vendor));
        email = (findViewById(R.id.email));
        phonenumber = (findViewById(R.id.phonenumber));
        password = (findViewById(R.id.password));
        address = (findViewById(R.id.address));
        city = (findViewById(R.id.city));
        zipcode = (findViewById(R.id.zipcode));
        states = (findViewById(R.id.states));
        next = (findViewById(R.id.next));

        next.setOnClickListener(this);
    }

    private void registerNext() {
        String Vendor = vendor.getText().toString().trim();
        String  Address = address.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String phone = phonenumber.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String City = city.getText().toString().trim();
        String Zipcode = zipcode.getText().toString().trim();

        //Spinner

        if(TextUtils.isEmpty(Vendor)){
            //first name is empty
            Toast.makeText(this, "Enter a vendor name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Address)){
            //first name is empty
            Toast.makeText(this, "Enter an address",Toast.LENGTH_SHORT).show();
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
        if(TextUtils.isEmpty(City)){
            //first name is empty
            Toast.makeText(this, "Enter a city",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Zipcode)){
            //first name is empty
            Toast.makeText(this, "Enter a zipcode",Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(vendorRegister.this, nextRegister.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if(v==next){
            registerNext();
        }
    }


}
