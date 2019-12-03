package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

public class appliances extends AppCompatActivity implements View.OnClickListener{
    Spinner spinner_room, spinner_kitchen_app, spinner_bathroom_app, spinner_bedroom_app;
    EditText details;
    TextView detail_length;
    Button submit;

    String room, appliance_item,service = "Appliance";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliances);

        spinner_room = (Spinner) findViewById(R.id.spinner_room);
        spinner_kitchen_app = (Spinner) findViewById(R.id.spinner_kitchen_app);
        spinner_bathroom_app = (Spinner) findViewById(R.id.spinner_bathroom_app);
        spinner_bedroom_app = (Spinner) findViewById(R.id.spinner_bedroom_app);
        details = findViewById(R.id.details);
        detail_length = (TextView)findViewById(R.id.detail_length);
        submit = findViewById(R.id.submit);

        spinner_kitchen_app.setVisibility(View.INVISIBLE);
        spinner_bathroom_app.setVisibility(View.INVISIBLE);
        spinner_bedroom_app.setVisibility(View.INVISIBLE);
        details.setVisibility(View.INVISIBLE);
        detail_length.setVisibility(View.INVISIBLE);
        submit.setVisibility(View.INVISIBLE);

        submit.setOnClickListener(this);

        details.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = details.getText().toString();
                int symbols = text.length();
                detail_length.setText("" + symbols + "/300");
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        spinner_room.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                room = parent.getItemAtPosition(position).toString();
                switch (room) {
                    case "Select a Room":
                        spinner_kitchen_app.setVisibility(View.INVISIBLE);
                        spinner_bathroom_app.setVisibility(View.INVISIBLE);
                        spinner_bedroom_app.setVisibility(View.INVISIBLE);
                        details.setVisibility(View.INVISIBLE);
                        detail_length.setVisibility(View.INVISIBLE);
                        submit.setVisibility(View.INVISIBLE);
                        break;
                    case "Kitchen":
                        spinner_kitchen_app.setVisibility(View.VISIBLE);
                        spinner_bathroom_app.setVisibility(View.INVISIBLE);
                        spinner_bedroom_app.setVisibility(View.INVISIBLE);
                        details.setVisibility(View.INVISIBLE);
                        detail_length.setVisibility(View.INVISIBLE);
                        submit.setVisibility(View.INVISIBLE);
                        break;
                    case "Bathroom":
                        spinner_kitchen_app.setVisibility(View.INVISIBLE);
                        spinner_bathroom_app.setVisibility(View.VISIBLE);
                        spinner_bedroom_app.setVisibility(View.INVISIBLE);
                        details.setVisibility(View.INVISIBLE);
                        detail_length.setVisibility(View.INVISIBLE);
                        submit.setVisibility(View.INVISIBLE);
                        break;
                    case "Bedroom":
                        spinner_kitchen_app.setVisibility(View.INVISIBLE);
                        spinner_bathroom_app.setVisibility(View.INVISIBLE);
                        spinner_bedroom_app.setVisibility(View.VISIBLE);
                        details.setVisibility(View.INVISIBLE);
                        detail_length.setVisibility(View.INVISIBLE);
                        submit.setVisibility(View.INVISIBLE);
                        break;
                    case "Other":
                        spinner_kitchen_app.setVisibility(View.INVISIBLE);
                        spinner_bathroom_app.setVisibility(View.INVISIBLE);
                        spinner_bedroom_app.setVisibility(View.INVISIBLE);
                        details.setVisibility(View.VISIBLE);
                        detail_length.setVisibility(View.VISIBLE);
                        submit.setVisibility(View.VISIBLE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_kitchen_app.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                appliance_item = parent.getItemAtPosition(position).toString();
                switch (appliance_item){
                    case "Select an Appliance":
                        details.setVisibility(View.INVISIBLE);
                        detail_length.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        details.setVisibility(View.VISIBLE);
                        detail_length.setVisibility(View.VISIBLE);
                        submit.setVisibility(View.VISIBLE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_bathroom_app.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                appliance_item = parent.getItemAtPosition(position).toString();
                switch (appliance_item){
                    case "Select an Appliance":
                        details.setVisibility(View.INVISIBLE);
                        detail_length.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        details.setVisibility(View.VISIBLE);
                        detail_length.setVisibility(View.VISIBLE);
                        submit.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_bedroom_app.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                appliance_item = parent.getItemAtPosition(position).toString();
                switch (appliance_item){
                    case "Select an Appliance":
                        details.setVisibility(View.INVISIBLE);
                        detail_length.setVisibility(View.INVISIBLE);
                        submit.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        details.setVisibility(View.VISIBLE);
                        detail_length.setVisibility(View.VISIBLE);
                        submit.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v==submit){
            Intent choose = new Intent(this, chooseVendor.class);
            choose.putExtra("Service",service);
            startActivity(choose);
        }
    }
}

