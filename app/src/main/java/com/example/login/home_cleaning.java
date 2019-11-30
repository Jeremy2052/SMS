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

public class home_cleaning extends AppCompatActivity implements View.OnClickListener{


    CheckBox Bedroom, Kitchen, Bathroom;

    EditText details;
    TextView detail_length;
    Button submit;

    String room, hcleaning_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cleaning);

        details = findViewById(R.id.details);
        detail_length = (TextView) findViewById(R.id.detail_length);
        submit = findViewById(R.id.submit);
        Bedroom = findViewById(R.id.Bedroom);
        Kitchen = findViewById(R.id.Kitchen);
        Bathroom = findViewById(R.id.Bathroom);

        submit.setOnClickListener(this);

        details.setVisibility(View.INVISIBLE);
        detail_length.setVisibility(View.INVISIBLE);
        submit.setVisibility(View.INVISIBLE);

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

        Bedroom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked || Kitchen.isChecked() || Bathroom.isChecked()) {
                    details.setVisibility(View.VISIBLE);
                    detail_length.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.VISIBLE);
                } else {
                    details.setVisibility(View.INVISIBLE);
                    detail_length.setVisibility(View.INVISIBLE);
                    submit.setVisibility(View.INVISIBLE);
                }
            }
        });

        Kitchen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked || Bedroom.isChecked() || Bathroom.isChecked()) {
                    details.setVisibility(View.VISIBLE);
                    detail_length.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.VISIBLE);
                } else {
                    details.setVisibility(View.INVISIBLE);
                    detail_length.setVisibility(View.INVISIBLE);
                    submit.setVisibility(View.INVISIBLE);
                }
            }
        });

        Bathroom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked || Kitchen.isChecked() || Bedroom.isChecked()) {
                    details.setVisibility(View.VISIBLE);
                    detail_length.setVisibility(View.VISIBLE);
                    submit.setVisibility(View.VISIBLE);
                } else {
                    details.setVisibility(View.INVISIBLE);
                    detail_length.setVisibility(View.INVISIBLE);
                    submit.setVisibility(View.INVISIBLE);
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit:
                if (Bedroom.isChecked())
                    room = "Bedroom";
                if (Kitchen.isChecked())
                    room += " Kitchen";
                if (Bathroom.isChecked())
                    room += " Bathroom";
            default:
                Toast.makeText(this, room,Toast.LENGTH_SHORT).show();

                Intent choose = new Intent(this, chooseVendor.class);
                startActivity(choose);
        }
    }
}

