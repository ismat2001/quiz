package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class entertainment extends AppCompatActivity {
    String fetchedScore,fetchedCategory;
    TextView score;
    private Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        done=findViewById(R.id.scorebtn);
        score=findViewById(R.id.score);
        fetchedScore=getIntent().getStringExtra("marks");

        score.append(fetchedScore+"\n "+",");
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(entertainment.this,categories.class);
                startActivity(intent);
                finish();
            }
        });    }
}