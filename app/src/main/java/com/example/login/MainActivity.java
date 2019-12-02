package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
//import from models for user object
import com.example.login.models.User;


public class  MainActivity extends AppCompatActivity implements View.OnClickListener {
        private EditText emaill;
        private EditText password;
        private Button login;
        private Button signup;
        private Button skip;
        private Button vendorLogin;

        private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null){
            Intent intent2 = new Intent(MainActivity.this, mainScreen.class);
            startActivity(intent2);
            finish();
        }

        emaill = (findViewById(R.id.email));
        password = (findViewById(R.id.password));
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        skip = findViewById(R.id.skip);
        vendorLogin = findViewById(R.id.vendorLogin);

        vendorLogin.setOnClickListener(this);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
        skip.setOnClickListener(this);


    }

    private void userLogin(){
        final String email2 = emaill.getText().toString().trim();
        String pass2 = password.getText().toString().trim();

        if(TextUtils.isEmpty(email2)){
            //first name is empty
            Toast.makeText(this, "Enter an email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass2)){
            //first name is empty
            Toast.makeText(this, "Enter a password",Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email2,pass2).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("FragmentActivity", "onComplete: AuthState: " + FirebaseAuth.getInstance().getCurrentUser().getUid());
                    //create object user for database
                    User user = new User();
                    user.setName(email2.substring(0, email2.indexOf("@")));
                    user.setPhone("1");
                    user.setUser_id(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    //insert database reference object
                    FirebaseDatabase.getInstance().getReference()
                            .child(getString(R.string.dbnode_users))
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user);



                    Intent intent3 = new Intent(getApplicationContext(), mainScreen.class);
                    startActivity(intent3);
                    //finish();//-------------------------

                }else{
                    Toast.makeText(MainActivity.this, "Login failed",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login:
                userLogin();
                break;
            case R.id.signup:
                Intent intent = new Intent(MainActivity.this, registration.class);
                startActivity(intent);

                break;
            case R.id.skip:
                Intent intent2 = new Intent(MainActivity.this, mainScreen.class);
                startActivity(intent2);
                //finish();
                break;

            case R.id.vendorLogin:
                Intent intent3 = new Intent(MainActivity.this, vendorLogin.class);
                startActivity(intent3);
                //finish();
        }
    }
}
