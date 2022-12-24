package org.example.snakeLadder;

public class Ladder extends SpecialEntity{
    public Ladder(int start, int end) {
        super(start, end);
    }

    @Override
    public String getId() {
        return " "+ this.getStart() + "_L_" + this.getEnd();
    }
}
