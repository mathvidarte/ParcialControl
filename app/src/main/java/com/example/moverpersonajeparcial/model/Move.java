package com.example.moverpersonajeparcial.model;

public class Move {
    String move;
    String type = "move";

    public Move(String move) {
        this.move = move;

    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
