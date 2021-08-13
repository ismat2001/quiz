package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class categories extends AppCompatActivity {
ImageView science,sports,general,food,marks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        science=findViewById(R.id.science);
        sports=findViewById(R.id.sportsq);
        general =findViewById(R.id.generalq);
        food=findViewById(R.id.foods);
        marks =findViewById(R.id.marks);
        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previewintent = new Intent(categories.this,science.class);
                startActivity(previewintent);
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previewintent = new Intent(categories.this,sports.class);
                startActivity(previewintent);
            }
        });
        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previewintent = new Intent(categories.this,general.class);
                startActivity(previewintent);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previewintent = new Intent(categories.this,food.class);
                startActivity(previewintent);
            }
        });
        marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previewintent = new Intent(categories.this,entertainment.class);
                startActivity(previewintent);
            }
        });
    }
}