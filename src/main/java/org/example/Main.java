package org.example;

import org.example.snakeLadder.SnakeAndLadderDriver;
import org.example.snakeLadder.GameAlreadyStartedException;
import org.example.splitwise.SplitWiseDriver;

public class Main {
    static String file ;
    public static void main(String[] args) throws GameAlreadyStartedException {
        SnakeAndLadderDriver snakeAndLadderDriver = new SnakeAndLadderDriver();
        file = "./src/main/resources/snakeLadder.txt";
        snakeAndLadderDriver.drive(file);
        file = "./src/main/resources/splitwise.txt";
        SplitWiseDriver splitWiseDriver = new SplitWiseDriver();
        splitWiseDriver.drive(file);
    }
}