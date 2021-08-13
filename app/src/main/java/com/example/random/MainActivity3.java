package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {
private TextInputLayout Name,Username,Email,Phone,Password;
private Button register;
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
register=findViewById(R.id.registerbtn);
        Name=findViewById(R.id.name);
        Username=findViewById(R.id.username);
        Email=findViewById(R.id.email);
        Phone=findViewById(R.id.phone);
        Password=findViewById(R.id.password);
register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        rootnode=FirebaseDatabase.getInstance();
        reference=rootnode.getReference("users");
        Intent intent=new Intent(MainActivity3.this,categories.class);
        startActivity(intent);
        //getting values from textFields
        String name=Name.getEditText().getText().toString();
        String username=Username.getEditText().getText().toString();
        String email=Email.getEditText().getText().toString();
        String phone=Phone.getEditText().getText().toString();
        String password=Password.getEditText().getText().toString();
        UserHelper helperClass=new UserHelper( name,username,email,phone,password);
        //storing in database
       // reference.setValue(helperClass);
        //multiple users unique id
        reference.child(phone).setValue(helperClass);
        //changing screen

    }
});
            }

}