package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

public class home_repair extends AppCompatActivity implements View.OnClickListener{
    Spinner spinner_damage;
    EditText details;
    TextView detail_length;
    Button submit;

    String repair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_repair);

        spinner_damage = (Spinner) findViewById(R.id.spinner_damage);
        details = findViewById(R.id.details);
        detail_length = (TextView)findViewById(R.id.detail_length);
        submit = findViewById(R.id.submit);

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

        spinner_damage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                repair = parent.getItemAtPosition(position).toString();
                switch (repair) {
                    case "Please select home repair type":
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
            startActivity(choose);

        }
    }
}

