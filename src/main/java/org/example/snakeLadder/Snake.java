package org.example.snakeLadder;

public class Snake extends SpecialEntity{
    public Snake(int start, int end) {
        super(start, end);
    }

    @Override
    public String getId() {
        return " "+this.getStart() + "_S_" + this.getEnd();
    }
}
