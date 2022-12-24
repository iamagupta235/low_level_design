package org.example.snakeLadder;

public abstract class SpecialEntity {
    private final int start;
    private final int end;

    public SpecialEntity(int start, int end){
        this.start = start;
        this.end = end;
    }
    public abstract String getId();

    public int getStart(){
        return this.start;
    }

    public int getEnd(){
        return this.end;
    }
}
