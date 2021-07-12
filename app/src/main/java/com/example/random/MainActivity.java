package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static com.example.random.R.id.checkbtn;
import static com.example.random.R.id.text;

public class MainActivity extends AppCompatActivity {
    Button checkbtn, randombtn;
    TextView textview1;
    int remainder=0,c=2;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkbtn = findViewById(R.id.checkbtn);
        randombtn = findViewById(R.id.randombtn);
        textview1 = findViewById(R.id.textview1);
        String random = textview1.getText().toString();


        randombtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random check = new Random();
                int n = check.nextInt();
                textview1.setText("" + n);
            }
        });
        checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
String s=textview1.getText().toString();
int n=Integer.parseInt(s);

                remainder = n%c;
                if (remainder == 0) {
                    Intent previewintent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(previewintent);
                } else {
                    Intent previewintent = new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(previewintent);
                }
            }
        });


    }
}