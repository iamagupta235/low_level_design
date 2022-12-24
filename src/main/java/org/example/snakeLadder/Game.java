package org.example.snakeLadder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    Board board;
    Dice dice;
    Queue<Player> players;
    GameStatus gameStatus;

    public Game(Board board, Dice dice){
        this.board = board;
        this.dice = dice;
        this.players = new LinkedList<>();
        this.gameStatus = GameStatus.NOT_STARTED;
    }

    public void startGame(){
        this.gameStatus = GameStatus.RUNNING;
        board.printBoard();

        while (true){
            Player currentPlayer = players.poll();

            makeMove(currentPlayer);

            if (currentPlayer.getPosition() == board.getTotalCells()) {
                System.out.println(currentPlayer.getName() + " wins the game");
                break;
            }
            else
                players.add(currentPlayer);
        }

        this.gameStatus = GameStatus.FINISHED;
    }

    private void makeMove(Player currentPlayer) {

        int playerPosition = currentPlayer.getPosition();
        int rollValue = dice.roll();


        int targetPosition = playerPosition + rollValue;

        if (targetPosition > board.getTotalCells())
            targetPosition -= rollValue;
        else {
            if (board.hasSpecialEntity(targetPosition))
                targetPosition = board.getSpecialEntity(targetPosition).getEnd();
        }
        System.out.println(currentPlayer.getName() + " rolled a " + rollValue +" and moved from " + playerPosition +" to "+targetPosition);
        currentPlayer.setPosition(targetPosition);
    }

    public void addPlayers(List<Player> allPlayers) throws GameAlreadyStartedException {
        if (this.gameStatus == GameStatus.NOT_STARTED){
            this.players.addAll(allPlayers);
        }
        else
            throw new GameAlreadyStartedException("Game has already started ! Can't add more players");
    }
}
