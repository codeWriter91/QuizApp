package com.example.newapptwo;

import java.util.ArrayList;

/**
 * Created by Chinmaya on 8/3/2017.
 */

public class ListOfQuestions {

    ArrayList <Integer> randomNumbers = new ArrayList<>();
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> choice1 = new ArrayList<>();
    ArrayList<String> choice2 = new ArrayList<>();
    ArrayList<String> choice3 = new ArrayList<>();
    public String method(int i) {
        questions.add("Your friend just suffered public Humiliation? What will you do?");
        questions.add("Do you hate Snape more than Malfoy?");
        questions.add("Do you like Hagrid?");
        questions.add("You are outmatched 30 to 1 against Deatheaters. If you have a chance to escape, will you still fight?");
        questions.add("Snape is trying to kill you. Dumbledore says 'Don't worry, He's on our side.' Will you fight Snape?");
        return questions.get(i);
    }

    public String choiceOne(int i){
        choice1.add("Provide Absolute Support");
        choice1.add("choice 1b");
        choice1.add("choice 1c");
        choice1.add("choice 1d");
        choice1.add("choice 1e");
        return choice1.get(i);

    }
    public String choiceTwo(int i){
        choice2.add("Will give him/her pointers on how to not make the same mistake again");
        choice2.add("choice 2b");
        choice2.add("choice 2c");
        choice2.add("choice 2d");
        choice2.add("choice 2e");
        return choice2.get(i);

    }
    public String choiceThree(int i){
        choice3.add("Beat the people who pulled the prank on your friend");
        choice3.add("choice 3b");
        choice3.add("choice 3c");
        choice3.add("choice 3d");
        choice3.add("choice 3e");
        return choice3.get(i);

    }

    public int numberOfQuestions(){

        return questions.size();
    }

}
