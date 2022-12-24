package org.example.tictactoe;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    @Getter
    @Setter
    String playerName;

    @Getter
    @Setter
    char mark;

    @Getter
    @Setter
    Set<Integer> occupants;

    public Player(String playerName, char mark){
        this.mark = mark;
        this.playerName = playerName;
        this.occupants = new HashSet<>();
    }
    public boolean playerWon(){
        List<Integer> wc_row1 = Arrays.asList(0, 1, 2);
        List<Integer> wc_row2 = Arrays.asList(3, 4, 5);
        List<Integer> wc_row3 = Arrays.asList(6, 7, 8);
        List<Integer> wc_col1 = Arrays.asList(0, 3, 6);
        List<Integer> wc_col2 = Arrays.asList(1, 4, 7);
        List<Integer> wc_col3 = Arrays.asList(2, 5, 8);
        List<Integer> wc_diag1 = Arrays.asList(0, 4, 8);
        List<Integer> wc_diag2 = Arrays.asList(2, 4, 6);
        
        if (occupants.containsAll(wc_row1) ||
            occupants.containsAll(wc_row2) ||
            occupants.containsAll(wc_row3) ||
            occupants.containsAll(wc_col1) ||
            occupants.containsAll(wc_col2) ||
            occupants.containsAll(wc_col3) ||
            occupants.containsAll(wc_diag1) ||
            occupants.containsAll(wc_diag2)
        ) {
            System.out.println(this.playerName + " won !!!");
            return true;
        }
        return false;
    }
}
