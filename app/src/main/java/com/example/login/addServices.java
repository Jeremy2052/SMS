package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addServices extends AppCompatActivity  implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Button sub;
    private EditText price;
    String prices,service;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_services);

        firebaseAuth = FirebaseAuth.getInstance();

        Spinner spinner = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        sub = findViewById(R.id.sub);
        price = findViewById(R.id.price);

        sub.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        service = text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void submitService(){
        prices = price.getText().toString();
        if(prices.isEmpty()){
            Toast.makeText(this, "Enter a price",Toast.LENGTH_SHORT).show();
            return;
        }

        setData();

        Intent intent = new Intent(this, vendorMainScreen.class);
        startActivity(intent);
        finish();

    }

    private void setData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef2 = firebaseDatabase.getReference("Vendors").child(firebaseAuth.getCurrentUser().getUid());

        myRef2.child("Price").setValue(prices);
        myRef2.child("Service").setValue(service);
    }

    @Override
    public void onClick(View v) {
        if(v==sub){
            submitService();
        }
    }
}
