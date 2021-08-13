package com.example.random;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.random.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context){
        this.context=context;
    }
    //arays
    public  int[] slideimages={R.drawable.e,R.drawable.a,R.drawable.d,R.drawable.b};
    public  String[] headings={"WELCOME","CATEGORIES","CHOOSE","REVIEW"};
    public  String[] description={"Hi,let's begin by signing up afterwards login to your world of quizes and score","This app have 4 categories for you:science,sports,food & general knowledge","you will be given 10sec per question ","When finished you can see your score card"};
    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject( View view, Object o) {
        return view==(RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slidelayout,container,false);
        ImageView image=(ImageView) view.findViewById(R.id.img);
        TextView heading=(TextView) view.findViewById(R.id.head);
        TextView desc=(TextView) view.findViewById(R.id.body);
        image.setImageResource(slideimages[position]);
        heading.setText(headings[position]);
        desc.setText(description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
