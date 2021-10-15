package com.example.myquiz;

public class Question {
    private int mTextResId;
    private String mAnswer;

    public Question(int textResId, String answer) {
        mTextResId = textResId;
        mAnswer = answer;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public String isAnswer() {
        return mAnswer;
    }
}
