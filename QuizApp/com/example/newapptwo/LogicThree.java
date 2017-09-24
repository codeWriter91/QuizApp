package com.example.newapptwo;

import android.widget.Toast;


public class LogicThree {

    String s;
    public String logic3(int score){

        if(score>=120)
        {
            s = "Harry Potter";
        }
        else if(score>90 && score<120)
        {
            s = "Hermione Granger";
        }
        else if(score<=90)
        {
            s = "Ron Weasly";
        }

        return s;
    }
}
