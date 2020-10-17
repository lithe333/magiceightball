package com.example.a001magiceightball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    //setting up variables
    private ImageView eightballIV;
    private TextView answerTV;
    private String[] answerArray = {"It is certain", "It is decidedly so", "Without a doubt", "Yes definitely", "You may rely on it", "As I see it, yes",
            "Most likely", "Outlook good", "Yes", "Signs point to yes", "Reply hazy try again", "Ask again later",
            "Better not tell you now", "Cannot predict now", "Concentrate and ask again", "Don't count on it",
            "My reply is no", "My sources say no", "Outlook not so good", "Very doubtful"};

    //main method - see link RE Override https://beginnersbook.com/2014/01/method-overriding-in-java-with-example/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connecting the variables to previous code by id
        eightballIV = findViewById(R.id.btn);
        answerTV = findViewById(R.id.answer);

        //adding a delay
        eightballIV.setOnTouchListener(this);

        //calling the btn method
        eightballIV.setOnClickListener(this);


    }

    //on touch method
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //delay answer
        answerTV.setText("..asking...");
        return false;
    }

    //btn click method
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                //adding delay
                //not sure why TimeUnit.SECONDS.sleep(1); wouldn't compile
                try {
                    SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //random answer
                int rand = new Random().nextInt(answerArray.length);
                answerTV.setText(answerArray[rand]);
                break;
        }
    }
}