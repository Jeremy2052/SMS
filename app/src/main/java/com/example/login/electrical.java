package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class electrical extends AppCompatActivity {
    Spinner spinner_room, spinner_kitchen_app, spinner_bathroom_app, spinner_bedroom_app;

    EditText details;

    String room, room_appliance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliances);

        spinner_room = (Spinner) findViewById(R.id.spinner_room);
        spinner_kitchen_app = (Spinner) findViewById(R.id.spinner_kitchen_app);
        spinner_bathroom_app = (Spinner) findViewById(R.id.spinner_bathroom_app);
        spinner_bedroom_app = (Spinner) findViewById(R.id.spinner_bedroom_app);
        details = (findViewById(R.id.details));

        spinner_kitchen_app.setVisibility(View.INVISIBLE);
        spinner_bathroom_app.setVisibility(View.INVISIBLE);
        spinner_bedroom_app.setVisibility(View.INVISIBLE);
        details.setVisibility(View.INVISIBLE);

        spinner_room.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                room = parent.getItemAtPosition(position).toString();
                switch (room) {
                    case "Select a Room":
                        Toast.makeText(parent.getContext(), "Select a Room", Toast.LENGTH_SHORT).show();
                        spinner_kitchen_app.setVisibility(View.INVISIBLE);
                        spinner_bathroom_app.setVisibility(View.INVISIBLE);
                        spinner_bedroom_app.setVisibility(View.INVISIBLE);
                        details.setVisibility(View.INVISIBLE);
                        break;
                    case "Kitchen":
                        Toast.makeText(parent.getContext(), "Kitchen", Toast.LENGTH_SHORT).show();
                        spinner_kitchen_app.setVisibility(View.VISIBLE);
                        spinner_bathroom_app.setVisibility(View.INVISIBLE);
                        spinner_bedroom_app.setVisibility(View.INVISIBLE);
                        details.setVisibility(View.INVISIBLE);
                        break;
                    case "Bathroom":
                        Toast.makeText(parent.getContext(), "Bathroom", Toast.LENGTH_SHORT).show();
                        spinner_kitchen_app.setVisibility(View.INVISIBLE);
                        spinner_bathroom_app.setVisibility(View.VISIBLE);
                        spinner_bedroom_app.setVisibility(View.INVISIBLE);
                        details.setVisibility(View.INVISIBLE);
                        break;
                    case "Bedroom":
                        Toast.makeText(parent.getContext(), "Bedroom", Toast.LENGTH_SHORT).show();
                        spinner_kitchen_app.setVisibility(View.INVISIBLE);
                        spinner_bathroom_app.setVisibility(View.INVISIBLE);
                        spinner_bedroom_app.setVisibility(View.VISIBLE);
                        details.setVisibility(View.INVISIBLE);
                        break;
                    case "Other":
                        Toast.makeText(parent.getContext(), "Other", Toast.LENGTH_SHORT).show();
                        spinner_kitchen_app.setVisibility(View.INVISIBLE);
                        spinner_bathroom_app.setVisibility(View.INVISIBLE);
                        spinner_bedroom_app.setVisibility(View.INVISIBLE);
                        details.setVisibility(View.VISIBLE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // NO YE
            }
        });

        spinner_kitchen_app.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                room_appliance = parent.getItemAtPosition(position).toString();
                switch (room_appliance){
                    case "Select a Kitchen Appliance":
                        details.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        details.setVisibility(View.VISIBLE);
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
                room_appliance = parent.getItemAtPosition(position).toString();
                switch (room_appliance){
                    case "Select a Bathroom Appliance":
                        details.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        details.setVisibility(View.VISIBLE);
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
                room_appliance = parent.getItemAtPosition(position).toString();
                switch (room_appliance){
                    case "Select a Bedroom Appliance":
                        details.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        details.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

