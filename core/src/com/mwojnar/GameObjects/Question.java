package com.mwojnar.GameObjects;

public class Question {
    private String questionText = "", answer1 = "", answer2 = "", personName = "";
    private Question answer1Question = null, answer2Question = null;
    private boolean isEnding = false, isAutoReply = false, isTransition = false;
    private int endingType = -1;

    public Question(String questionText, String answer1, String answer2, Question answer1Question, Question answer2Question, boolean isEnding, int endingType) {
        this.questionText = questionText;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer1Question = answer1Question;
        this.answer2Question = answer2Question;
        this.isEnding = isEnding;
        this.endingType = endingType;
    }

    public Question(String questionText, String answer1, String answer2, Question answer1Question, Question answer2Question, boolean isEnding, int endingType, boolean isAutoReply, boolean isTransition) {
        this.questionText = questionText;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer1Question = answer1Question;
        this.answer2Question = answer2Question;
        this.isEnding = isEnding;
        this.endingType = endingType;
        this.isAutoReply = isAutoReply;
        this.isTransition = isTransition;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Question getAnswer1Question() {
        return answer1Question;
    }

    public Question getAnswer2Question() {
        return answer2Question;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public boolean getIsEnding() {
        return isEnding;
    }

    public int getEndingType() {
        return endingType;
    }

    public boolean getIsTransition() {
        return isTransition;
    }

    public boolean getIsAutoReply() {
        return isAutoReply;
    }
}
