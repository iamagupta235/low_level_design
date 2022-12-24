package org.example.snakeLadder;

public class Dice {
    int maxValue;

    public Dice(int maxValue) {
        this.maxValue = maxValue;
    }

    public int roll(){
        return (int) Math.floor(Math.random()*maxValue +1);
    }
}
