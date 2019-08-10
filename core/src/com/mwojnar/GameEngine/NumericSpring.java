package com.mwojnar.GameEngine;

public class NumericSpring {

    private float frequency = 0.0f, maxNum = 0.0f;
    private long time = 0, maxTime;

    public NumericSpring(float frequency, float maxNum, long maxTime) {
        this.frequency = frequency;
        this.maxNum = maxNum;
        this.maxTime = maxTime;
    }

    public float getNum() {
        return (float)Math.sin(time * frequency) * maxNum * lerp(1.0f, 0.0f, time, maxTime);
    }

    public void update() {
        time++;
    }

    private float lerp(float start, float end, long time, long maxTime) {
        float factor = (float)time / (float)maxTime;
        if (factor > 1.0f)
            factor = 1.0f;
        return start * (1.0f - factor) + end * factor;
    }

}