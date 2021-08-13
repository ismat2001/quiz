package com.example.random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
private ViewPager slideview;
private LinearLayout dots;
private SliderAdapter sliderAdapter;
private TextView[] Dots;
private Button previousbtn,nextbtn;
private int currentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
slideview=(ViewPager)findViewById(R.id.some);
previousbtn=(Button)findViewById(R.id.previousbtn);
nextbtn=(Button)findViewById(R.id.nextbtn);
        dots=(LinearLayout)findViewById(R.id.linear);
        sliderAdapter=new SliderAdapter(this);
        slideview.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        slideview.addOnPageChangeListener(viewListener);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideview.setCurrentItem(currentPage+1);
                if(currentPage==3){
                    Intent intent=new Intent(MainActivity2.this,login.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        previousbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideview.setCurrentItem(currentPage-1);}});
    }
    private void addDotsIndicator(int position){
        Dots=new TextView[4];
        dots.removeAllViews();
        for(int i=0;i< Dots.length;i++){
            Dots[i]=new TextView(this);
            Dots[i].setText(Html.fromHtml("&#8226;"));
            Dots[i].setTextSize(35);
            Dots[i].setTextColor(getResources().getColor(R.color.transparent));
            dots.addView(Dots[i]);
        }
        if(Dots.length>0){ Dots[position].setTextColor(getResources().getColor(R.color.red));
        }
    }
    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
addDotsIndicator(i);
currentPage=i;
if(i==0){nextbtn.setEnabled(true);
previousbtn.setEnabled(false);
nextbtn.setText("Next");
previousbtn.setVisibility(View.INVISIBLE);
    previousbtn.setText("");}
else if(i==(Dots.length-1)){nextbtn.setEnabled(true);
    previousbtn.setEnabled(true);
    previousbtn.setVisibility(View.VISIBLE);
    nextbtn.setText("Finish");
    previousbtn.setText("Previous");}
       else{nextbtn.setEnabled(true);
            previousbtn.setEnabled(true);
            previousbtn.setVisibility(View.VISIBLE);
            nextbtn.setText("Next");
            previousbtn.setText("Previous");}
    }


        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}