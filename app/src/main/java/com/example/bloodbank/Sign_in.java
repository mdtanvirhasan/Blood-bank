package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sign_in extends AppCompatActivity {

    private Button sign_up;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

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
                goToHomePage();
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
}
