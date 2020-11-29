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

public class Sign_up extends AppCompatActivity {
    private Button confirm;
    private FirebaseAuth mAuth;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email=findViewById(R.id.emailId);
        password=findViewById(R.id.passID);

        mAuth = FirebaseAuth.getInstance();

        confirm=findViewById(R.id.confirmId);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //goToHomePage();
                userRegister();
            }
        });
    }
    public void goToHomePage(){
        Intent intent=new Intent(this,HomePage.class);
        startActivity(intent);
    }

    private void userRegister(){
        String em=email.getText().toString();
        String pass=password.getText().toString();
        mAuth.createUserWithEmailAndPassword(em,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Register is successful",Toast.LENGTH_SHORT).show();
                    goToHomePage();
                } else {
                    Toast.makeText(getApplicationContext(),"Register is not successful",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }



}
