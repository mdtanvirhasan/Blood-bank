package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MakeRequest extends AppCompatActivity {

    private Button submit;
    private EditText reqName;
    private EditText reqAddress;
    private EditText reqBloodg;
    private EditText reqDate;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_request);

        submit=findViewById(R.id.submit);

        databaseReference= FirebaseDatabase.getInstance().getReference();

        reqName=findViewById(R.id.reqNameId);
        reqAddress=findViewById(R.id.reqAddressId);
        reqBloodg=findViewById(R.id.reqBloodgId);
        reqDate=findViewById(R.id.reqDateId);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                //goToHomePage();
            }
        });
    }
    public void goToHomePage(){

        Intent intent=new Intent(this,HomePage.class);
        startActivity(intent);
    }
    public void saveData(){
        String name=reqName.getText().toString();
        String address=reqAddress.getText().toString();
        String blood_group=reqBloodg.getText().toString();
        String date=reqDate.getText().toString();

        String key=databaseReference.push().getKey();

        Requests requests=new Requests(name,address,blood_group,date);

        databaseReference.child(key).setValue(requests);
        Toast.makeText(getApplicationContext(),"Request successfully added",Toast.LENGTH_LONG).show();

        reqName.setText("");
        reqAddress.setText("");
        reqBloodg.setText("");
        reqDate.setText("");

    }
}
