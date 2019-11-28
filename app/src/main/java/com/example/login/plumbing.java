package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

public class plumbing extends AppCompatActivity {

    Spinner spinner_room, spinner_bathroom_plumbing, spinner_kitchen_plumbing, spinner_outdoor_plumbing;
    EditText details;
    TextView detail_length;
    Button submit;

    String room, plumbing_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumbing);

        details = findViewById(R.id.details);
        detail_length = (TextView)findViewById(R.id.detail_length);
        submit = findViewById(R.id.submit);
        spinner_room = (Spinner) findViewById(R.id.spinner_room);
        spinner_bathroom_plumbing = (Spinner) findViewById(R.id.spinner_bathroom_plumbing);
        spinner_kitchen_plumbing = (Spinner) findViewById(R.id.spinner_kitchen_plumbing);
        spinner_outdoor_plumbing = (Spinner) findViewById(R.id.spinner_outdoor_plumbing);

        details.setVisibility(View.INVISIBLE);
        detail_length.setVisibility(View.INVISIBLE);
        submit.setVisibility(View.INVISIBLE);
        spinner_kitchen_plumbing.setVisibility(View.INVISIBLE);

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
                    case "Bathroom":
                        spinner_bathroom_plumbing.setVisibility(View.VISIBLE);
                        spinner_kitchen_plumbing.setVisibility(View.INVISIBLE);
                        spinner_outdoor_plumbing.setVisibility(View.INVISIBLE);

                        details.setVisibility(View.INVISIBLE);
                        detail_length.setVisibility(View.INVISIBLE);
                        submit.setVisibility(View.INVISIBLE);
                        break;
                    case "Kitchen":
                        spinner_kitchen_plumbing.setVisibility(View.VISIBLE);
                        spinner_bathroom_plumbing.setVisibility(View.INVISIBLE);
                        spinner_outdoor_plumbing.setVisibility(View.INVISIBLE);

                        details.setVisibility(View.INVISIBLE);
                        detail_length.setVisibility(View.INVISIBLE);
                        submit.setVisibility(View.INVISIBLE);
                        break;
                    case "Outdoor":
                        spinner_kitchen_plumbing.setVisibility(View.INVISIBLE);
                        spinner_bathroom_plumbing.setVisibility(View.INVISIBLE);
                        spinner_outdoor_plumbing.setVisibility(View.VISIBLE);

                        details.setVisibility(View.INVISIBLE);
                        detail_length.setVisibility(View.INVISIBLE);
                        submit.setVisibility(View.INVISIBLE);
                        break;
                    case "Other":
                        spinner_bathroom_plumbing.setVisibility(View.INVISIBLE);
                        spinner_kitchen_plumbing.setVisibility(View.INVISIBLE);
                        spinner_outdoor_plumbing.setVisibility(View.INVISIBLE);

                        details.setVisibility(View.VISIBLE);
                        detail_length.setVisibility(View.VISIBLE);
                        submit.setVisibility(View.VISIBLE);
                        break;
                    default:
                        spinner_bathroom_plumbing.setVisibility(View.INVISIBLE);
                        spinner_kitchen_plumbing.setVisibility(View.INVISIBLE);
                        spinner_outdoor_plumbing.setVisibility(View.INVISIBLE);

                        details.setVisibility(View.INVISIBLE);
                        detail_length.setVisibility(View.INVISIBLE);
                        submit.setVisibility(View.INVISIBLE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner_bathroom_plumbing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                plumbing_item = parent.getItemAtPosition(position).toString();
                switch (plumbing_item) {
                    case "Please specify what needs plumbing":
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

        spinner_kitchen_plumbing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                plumbing_item = parent.getItemAtPosition(position).toString();
                switch (plumbing_item) {
                    case "Please specify what needs plumbing":
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

        spinner_outdoor_plumbing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                plumbing_item = parent.getItemAtPosition(position).toString();
                switch (plumbing_item) {
                    case "Please specify what needs plumbing":
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
}

