package com.example.newapptwo;

import android.widget.Toast;



public class LogicTwo implements ScoreLogic {
    String s;

    @Override
    public String logic1(int score) {
        if(score>=120)
        {
            s = "Your characteristics match closely with Harry Potter with score of ";

        }
        else if(score>90 && score<120)
        {
             s = "Your characteristics match closely with Hermione Granger with score of ";

        }
        else if(score<=90)
        {
            s = "Your characteristics match closely with Ron Weasly with score of ";

        }
        return s;
    }

    @Override
    public void logic2() {

    }
}
