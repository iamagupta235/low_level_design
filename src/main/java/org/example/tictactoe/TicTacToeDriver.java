package org.example.tictactoe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class TicTacToeDriver {
    public void drive(String file){
        System.out.println("\n\n");
        System.out.println(" xxxxxx-----xxxxx ----- xxxxx -----xxxxx ----------xxxxx");
        System.out.println();
        System.out.println("\t\t\t\t DRIVER FOR TIC-TAC-TOE");
        System.out.println("\t\t\t\t\t\t\t\t - System designed by Abhishek Kumar Gupta");
        Scanner scanner;
        Board board = new Board();
        HashMap<Integer, Player> players = new HashMap<>();
        int turn = -1;
        boolean getPlayer1 = false, getPlayer2 = false, gameStopped = false;
        try {
            scanner = new Scanner(new File(file));
            while (!gameStopped && scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] inputArr = line.split(" ");
                if(!getPlayer1){
                    getPlayer1 = true;
                    char player1Mark = inputArr[0].charAt(0);
                    String player1Name = inputArr[1];
                    Player player = new Player(player1Name, player1Mark);
                    players.put(-1,player);
                    continue;
                }
                if(!getPlayer2){
                    getPlayer2 = true;
                    char player2Mark = inputArr[0].charAt(0);
                    String player2Name = inputArr[1];
                    Player player = new Player(player2Name, player2Mark);
                    players.put(1,player);
                    continue;
                }
                String val1 = inputArr[0];
                if (val1.equals("exit")) {
                    break;
                }
                String val2 = inputArr[1];
                int row = Integer.parseInt(val1);
                int col =  Integer.parseInt(val2);
                boolean checkMove = board.makeMove(row, col , players.get(turn));
                turn *= -1;
                if (!checkMove) {
                    turn *= -1;
                }
                board.printBoard();
                if (players.get(turn).playerWon()) {
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
