package org.example;

import org.example.snakeLadder.SnakeAndLadderDriver;
import org.example.snakeLadder.GameAlreadyStartedException;
import org.example.splitwise.SplitWiseDriver;
import org.example.tictactoe.TicTacToeDriver;

public class Main {
    static String file ;
    public static void main(String[] args) throws GameAlreadyStartedException {
        SnakeAndLadderDriver snakeAndLadderDriver = new SnakeAndLadderDriver();
        file = "./src/main/resources/snakeLadder.txt";
//        snakeAndLadderDriver.drive(file);

        SplitWiseDriver splitWiseDriver = new SplitWiseDriver();
        file = "./src/main/resources/splitwise.txt";
//        splitWiseDriver.drive(file);

        TicTacToeDriver ticTacToeDriver = new TicTacToeDriver();
//        file = "./src/main/resources/tictactoe.txt";
        ticTacToeDriver.drive(file);
    }
}