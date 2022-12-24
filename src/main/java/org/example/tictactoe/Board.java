package org.example.tictactoe;

import java.util.Arrays;

public class Board {
    private static Board board_instance;
    public static char [][] board;

    public Board(){
        board = new char[3][3];
        for (char[] row : board)
            Arrays.fill(row,'_');
    }

    public void printBoard(){
        for (char[] row : board){
            for (char ex : row){
                System.out.print(ex + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public boolean makeMove(int row, int col, Player player){
        row = row-1;
        col = col-1;
        if (board[row][col] == '_') {
            board[row][col] = player.mark;
            int position = 3 * row + col;
            player.occupants.add(position);
            return true;
        }
        System.out.println("Invalid Move");
        return false;
    }

}
