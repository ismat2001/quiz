package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class science extends AppCompatActivity implements View.OnClickListener{
private TextView quesno,ques,timer;
private Button opt1,opt2,opt3,opt4;
private List<questions> questionsList;
private CountDownTimer countDownTimer;
private int marks;
String category="Science";
    int quesNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);
        quesno=findViewById(R.id.quesno);
        ques=findViewById(R.id.ques);
        timer=findViewById(R.id.timer);
        opt1=findViewById(R.id.opt1 );
        opt2=findViewById(R.id.opt2 );
        opt3=findViewById(R.id.opt3 );
        opt4=findViewById(R.id.opt4 );
        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);
        getQuestionList();
        marks=0;
    }
private void getQuestionList()
{
    questionsList=new ArrayList<>();
    questionsList.add(new questions("Plants that grow in saline water is called","HALOPHYTES","HYDROPHYTES","THALLOPHYTES","SALINOPHYTE",1));
    questionsList.add(new questions("What is the unit os noise","OHM","DECIBLE","HERTZ","CANDELA",2));
    questionsList.add(new questions("Which of the following is not an endothermic process?","Fusion","Vapourisation","Temperature","None of above",3));
    questionsList.add(new questions("Who started vaccination?","Edward Jenner","Paul Miller","Jonas E. Salk","Charles Darwin",1));
    questionsList.add(new questions("Which one is chief ore of Aluminium?","Galena","Hematite","Alumina","Bauxite",4));
    questionsList.add(new questions("Dry ice is the solod form of which gas?","Carbon mono oxide","Carbon Dioxide","Helium","Nitrous oxide",2));
    questionsList.add(new questions("Chemical formula of laughing gas??","Nitrous Oxide","Nitrogen Oxide","Nitric oxide","Nitric Acid",1));

    setQuestion();
}

    private void setQuestion() {//Plants that grow in saline water is called
       //setting all the values
        timer.setText(String.valueOf(10));
        ques.setText(questionsList.get(0).getQuestion());
        opt1.setText(questionsList.get(0).getOption1());
        opt2.setText(questionsList.get(0).getOption2());
        opt3.setText(questionsList.get(0).getOption3());
        opt4.setText(questionsList.get(0).getOption4());
        quesno.setText(String.valueOf(1)+"/"+String.valueOf(questionsList.size()));
        //starting timer
        startTimer();
        quesNum=0;
    }

    private void startTimer() {
        countDownTimer=new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished/1000));
            }
            @Override
            public void onFinish() {
                changeQuestion();

            }
        };
        countDownTimer.start();
    }


    @Override
    public void onClick(View v) {
        int selected=0;
        switch (v.getId()){
            case R.id.opt1 :
                selected=1;
            break;
            case R.id.opt2:
                selected=2;
                break;
            case R.id.opt3:
                selected=3;
                break;
            case R.id.opt4:
                selected=4;
                break;

            default:

        }
        countDownTimer.cancel();
        checkAnswer(selected,v);
    }

    private void checkAnswer(int selected,View view) {
    if(selected==questionsList.get(quesNum).correctAns)
    {
        //right answer
        marks++;
        ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
    }
    else
    {
        //wrong answer
        ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));
        switch (questionsList.get(quesNum).getCorrectAns())
        {
            case 1:
            opt1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            break;
            case 2:
            opt2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            break;
            case 3:
            opt3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            break;
            case 4:
            opt4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            break;
        }
    }
    changeQuestion();
    }
    private void changeQuestion() {
        if(quesNum<questionsList.size()-1){
           //change questionusing animation
            quesNum++;
            playAnimation(ques,0,0);
            playAnimation(opt1,0,1);
            playAnimation(opt2,0,2);
            playAnimation(opt3,0,3);
            playAnimation(opt4,0,4);

            quesno.setText(String.valueOf(quesNum+1)+"/"+String.valueOf(questionsList.size()));
            timer.setText(String.valueOf(10));
            startTimer();


        }
        else
        {
            //go to result
            Intent intent=new Intent(science.this,result.class);
            intent.putExtra("marks",String.valueOf(marks)+"/"+String.valueOf(questionsList.size()));
            intent.putExtra("category",category);
            startActivity(intent);
           finish();
        }
    }

    private void playAnimation(View view,final int value,int viewNum) {
    view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
            .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
    .setListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            if(value==0)
            {
                switch (viewNum){
                    case 0:
                        ((TextView)view).setText(questionsList.get(quesNum).getQuestion());
                        break;
                    case 1:
                        ((Button)view).setText(questionsList.get(quesNum).getOption1());
                        break;
                    case 2:
                        ((Button)view).setText(questionsList.get(quesNum).getOption2());
                        break;
                    case 3:
                        ((Button)view).setText(questionsList.get(quesNum).getOption3());
                        break;
                    case 4:
                        ((Button)view).setText(questionsList.get(quesNum).getOption4());
                        break;
                }
                playAnimation(view,1,viewNum);
            }

        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    });
    }

}