package com.example.newapptwo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import utils.SoundHelper;

public class MainActivity extends AppCompatActivity{

    Button button;
    RadioButton radioButton, radioButton2, radioButton3;
    TextView text;
    int a, b, c;
    File inputFile;
    public int score;
    private int score1;
    private int count;
    private SoundHelper mSoundHelper;
    private int y =0;
    String question;
    ArrayList<String> questions = new ArrayList<>();
    ProgressBar progressBar =null;
    String answer;
    private Scanner input;
    InputStream in;
    Context ctx;
    private String question1;
    ListOfQuestions list = new ListOfQuestions();
    int x=0;
    private static final int NOTIFY_ID = 1001;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton.setVisibility(View.INVISIBLE);
        radioButton2.setVisibility(View.INVISIBLE);
        radioButton3.setVisibility(View.INVISIBLE);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        text.setText("Find Out Who You Are...");

        button.setText("Find");
        mSoundHelper = new SoundHelper(this);
        mSoundHelper.prepareMusicPlayer(this);
        mSoundHelper.playMusic();
    }


    public void nextQuestion(View view) {
        button.setText("Next");
        count++;
        if (count!=6)
        { button.setClickable(false);
            radioButton.setVisibility(View.VISIBLE);
            radioButton2.setVisibility(View.VISIBLE);
            radioButton3.setVisibility(View.VISIBLE);
            radioButton.setText(list.choiceOne(x));
            radioButton2.setText(list.choiceTwo(x));
            radioButton3.setText(list.choiceThree(x));

            radioButton.setClickable(true);
            radioButton2.setClickable(true);
            radioButton3.setClickable(true);
            radioButton.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
            text.setText(questionBank());
        }
        else{
            radioButton.setVisibility(View.INVISIBLE);
            radioButton2.setVisibility(View.INVISIBLE);
            radioButton3.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
            text.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.INVISIBLE);

            LogicThree logicThree = new LogicThree();
            logicThree.logic3(score);
            logicFour(logicThree.s);
        }
    }

    private void logicFour(String s) {
        if (s.equals("Harry Potter")){
            getWindow().setBackgroundDrawableResource(R.drawable.harry_1);
            Toast t = Toast.makeText(this, "Your characteristics match closely with Harry Potter with score of "+score, Toast.LENGTH_LONG);
            t.show();
            exitDialogBox("Harry Potter");
        }
        else if (s.equals("Hermione Granger")){
            getWindow().setBackgroundDrawableResource(R.drawable.hermione);
            Toast t = Toast.makeText(this, "Your characteristics match closely with Harry Potter with score of "+score, Toast.LENGTH_LONG);
            t.show();
            exitDialogBox("Hermione Granger");
        }
        else if (s.equals("Ron Weasly")){
            getWindow().setBackgroundDrawableResource(R.drawable.ron_1);
            Toast t = Toast.makeText(this, "Your characteristics match closely with Harry Potter with score of "+score, Toast.LENGTH_LONG);
            t.show();
            exitDialogBox("Ron Weasly");

        }
    }

    public String questionBank(){
        question = list.method(x);
        x++;
        return question;
    }

    public void disableOtherOptions(View view) {
        radioButton.setClickable(false);
        radioButton2.setClickable(false);
        radioButton3.setClickable(false);
        button.setClickable(true);
        progressBar.incrementProgressBy(20);
        logic();
    }

    private int logic() {
        if(radioButton.isChecked()){
            score += 30;

        }
        else if(radioButton2.isChecked()){
            score += 20;

        }
        else if(radioButton3.isChecked()){
            score += 10;

        }
        return score;
    }
    public void exitDialogBox(String a) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your characterstics match closely with "+ a)
                .setCancelable(false)



                .setPositiveButton("EXIT", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        mSoundHelper.pauseMusic();
                        finish();

                    }
                });


        builder.setNegativeButton("Listen To Whole Music", new DialogInterface.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                createNotification();
            }
        });
        
        AlertDialog alert = builder.create();
        
        alert.setTitle("Results..");
        alert.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void createNotification() {
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.harry_potter_1)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");
        Intent resultIntent = new Intent(this, NotificationResultActivity.class);


        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        stackBuilder.addParentStack(NotificationResultActivity.class);

        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(NOTIFY_ID,mBuilder.build());
    }

    
}