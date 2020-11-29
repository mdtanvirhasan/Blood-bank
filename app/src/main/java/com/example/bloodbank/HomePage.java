package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    private Button make_req;
    private Button view_req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        make_req=findViewById(R.id.makeReq);

        view_req=findViewById(R.id.viewReq);

        view_req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePage.this,RequestList.class);
                startActivity(intent);
            }
        });

        make_req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMakeRequest();
            }
        });

    }
    public void goToMakeRequest(){
        Intent intent=new Intent(this,MakeRequest.class);
        startActivity(intent);
    }
}
