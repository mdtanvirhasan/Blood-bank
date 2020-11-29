package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_in extends AppCompatActivity {

    private Button sign_up;
    private Button confirm;
    private EditText email;
    private EditText pass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();

        email=findViewById(R.id.email);
        pass=findViewById(R.id.passwordId);

        sign_up=findViewById(R.id.sign_up_button);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });

        confirm=findViewById(R.id.confirm2);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
                //goToHomePage();
            }
        });



    }

    public void goToHomePage(){
        Intent intent=new Intent(this,HomePage.class);
        startActivity(intent);
    }
    public void openSignUp(){
        Intent intent=new Intent(this,Sign_up.class);
        startActivity(intent);


    }
    public void userLogin(){

        String eml=email.getText().toString();
        String pwd=pass.getText().toString();

        mAuth.signInWithEmailAndPassword(eml,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    goToHomePage();
                } else {
                    Toast.makeText(getApplicationContext(),"Login not successful",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
