package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class vendorRegister extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText vendor;
    private EditText email;
    private EditText phonenumber;
    private EditText password;
    private EditText address, city, zipcode;
    private Spinner states;
    private Switch agree;
    String Vendor,Address,Email,phone,pass,City,Zipcode;

    private Button next;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_register);

        firebaseAuth = FirebaseAuth.getInstance();

        vendor = (findViewById(R.id.vendor));
        email = (findViewById(R.id.email2));
        phonenumber = (findViewById(R.id.phonenumber));
        password = (findViewById(R.id.passwordv));
        address = (findViewById(R.id.address));
        city = (findViewById(R.id.city));
        zipcode = (findViewById(R.id.zipcode));
        states = (findViewById(R.id.states));
        next = (findViewById(R.id.next));
        agree = findViewById(R.id.switch1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.states,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        states.setAdapter(adapter);
        states.setOnItemSelectedListener(this);
        next.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void registerNext() {
        Vendor = vendor.getText().toString().trim();
         Address = address.getText().toString().trim();
        Email = email.getText().toString().trim();
         phone = phonenumber.getText().toString().trim();
         pass = password.getText().toString().trim();
         City = city.getText().toString().trim();
         Zipcode = zipcode.getText().toString().trim();

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
        //if statement for spinner being empty

        //if statement for agree switch not clicked.
        if(agree.isChecked()){

        }else{
            Toast.makeText(this, "You must agree to terms.",Toast.LENGTH_SHORT).show();
            return;
        }
        ////save as registering as vendor
        firebaseAuth.createUserWithEmailAndPassword(Email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    sendVendor();
                    //display registration was successful
                    Toast.makeText(vendorRegister.this, "Registration successful",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(vendorRegister.this, "Could not register, please try again",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Intent intent3 = new Intent(this, vendorLogin.class);
        startActivity(intent3);
        finish();
    }

    private void sendVendor(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        vendorInformation vendorInformation = new vendorInformation(Vendor,Address,Email,phone,pass,City,Zipcode);
        myRef.setValue(vendorInformation);
    }

    @Override
    public void onClick(View v) {
        if(v == next){
            registerNext();
        }
    }


}
