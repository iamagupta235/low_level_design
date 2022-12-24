package org.example.snakeLadder;

import lombok.Getter;

import java.util.HashMap;

public class Board {
    @Getter
    int dimension;

    HashMap<Integer, SpecialEntity> specialEntities;

    public Board(int dimension) {
        this.dimension = dimension;
        this.specialEntities = new HashMap<>();
    }

    public void printBoard(){
        int totalCells = dimension * dimension;
        for (int i = totalCells; i > 0 ; i--) {

            if ((i)% 10 == 0)
                System.out.println();
            System.out.print(" | " + i + "");

            if (hasSpecialEntity(i))
                System.out.print(specialEntities.get(i).getId());

            System.out.print(" |");

        }
    }

    public int getTotalCells(){
        return this.dimension * this.dimension;
    }

    public void addSpecialEntity(SpecialEntity entity){
        int actionPosition = entity.getStart();
        specialEntities.put(actionPosition, entity);
    }

    public boolean hasSpecialEntity(int position) {
        return specialEntities.containsKey(position);
    }

    public SpecialEntity getSpecialEntity(int position){
        if (hasSpecialEntity(position))
            return specialEntities.get(position);
        return null;
    }
}
