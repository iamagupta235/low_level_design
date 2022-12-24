package org.example.snakeLadder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Driver {
    static Snake snake;
    static Ladder ladder;
    static Board board;
    static List<Player> players = new ArrayList<>();

    public static void main(String[] args) throws GameAlreadyStartedException, FileNotFoundException {

//        Scanner scanner = new Scanner(System.in);
        board = new Board(10);
        Dice dice = new Dice(6);
        String file = "/Users/Abhii/Desktop/LLD/src/main/resources/snakeLadder.txt";
        Scanner scanner = new Scanner(new File(file));
        HashMap<Integer, String> hash= new HashMap<>();
        hash.put(0,"snakes");
        hash.put(1,"ladder");
        hash.put(2,"person");
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

    private static void getPlayer(Scanner scanner, int n) {
        Player player;
        for (int i = 0; i < n; i++) {
            String playerName = scanner.nextLine();
            player = new Player(playerName);
            System.out.println(player.getName() + " joined the party");
            players.add(player);
        }
    }

    private static void getLadders(Scanner scanner, int n) {
        int start, end;
        for (int i = 0; i < n; i++) {
            String[] ladder_vals = scanner.nextLine().split(" ");
            start = Integer.parseInt(ladder_vals[0]);
            end = Integer.parseInt(ladder_vals[1]);
            ladder = new Ladder(start, end);
            System.out.println(ladder.getId());
            board.addSpecialEntity(ladder);
        }
    }
    private static void getSnakes(Scanner scanner, int n) {
        int start, end;
        for (int i = 0; i < n; i++) {
            String[] ladder_vals = scanner.nextLine().split(" ");
            start = Integer.parseInt(ladder_vals[0]);
            end = Integer.parseInt(ladder_vals[1]);
            snake = new Snake(start, end);
            System.out.println(snake.getId());
            board.addSpecialEntity(snake);
        }
    }
}
