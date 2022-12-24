package org.example.snakeLadder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadderDriver {
    Snake snake;
    Ladder ladder;
    Board board;
    List<Player> players = new ArrayList<>();

    public void drive(String file) throws GameAlreadyStartedException {
        System.out.println("\n\n");
        System.out.println(" xxxxxx-----xxxxx ----- xxxxx -----xxxxx ----------xxxxx");
        System.out.println();
        System.out.println("\t\t\t\t DRIVER FOR GAME - SNAKE AND LADDER");
        System.out.println("\t\t\t\t\t\t\t\t - System designed by Abhishek Kumar Gupta");

        board = new Board(10);
        Dice dice = new Dice(6);
        Scanner scanner;
        try {
            scanner = new Scanner(new File(file));
            int index = 0;
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] input = line.split(" ");
                if (input.length == 1){
                    switch (index++){
                        case 0 -> getSnakes(scanner, Integer.parseInt(input[0]));
                        case 1 -> getLadders(scanner, Integer.parseInt(input[0]));
                        case 2 -> getPlayer(scanner, Integer.parseInt(input[0]));
                    }
                }
            }
            scanner.close();

            Game game = new Game(board, dice);

            game.addPlayers(players);
            game.startGame();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void getPlayer(Scanner scanner, int n) {
        Player player;
        for (int i = 0; i < n; i++) {
            String playerName = scanner.nextLine();
            player = new Player(playerName);
            System.out.println(player.getName() + " joined the party");
            players.add(player);
        }
    }

    private void getLadders(Scanner scanner, int n) {
        int start, end;
        for (int i = 0; i < n; i++) {
            String[] ladder_vals = scanner.nextLine().split(" ");
            start = Integer.parseInt(ladder_vals[0]);
            end = Integer.parseInt(ladder_vals[1]);
            ladder = new Ladder(start, end);
            System.out.println(ladder.getId()  + " joined the party");
            board.addSpecialEntity(ladder);
        }
    }
    private void getSnakes(Scanner scanner, int n) {
        int start, end;
        for (int i = 0; i < n; i++) {
            String[] ladder_vals = scanner.nextLine().split(" ");
            start = Integer.parseInt(ladder_vals[0]);
            end = Integer.parseInt(ladder_vals[1]);
            snake = new Snake(start, end);
            System.out.println(snake.getId()  + " joined the party");
            board.addSpecialEntity(snake);
        }
    }
}
