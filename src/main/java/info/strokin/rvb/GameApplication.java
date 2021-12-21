package info.strokin.rvb;

import info.strokin.rvb.pieces.Bishop;
import info.strokin.rvb.pieces.Rook;
import info.strokin.rvb.randomizers.Coin;
import info.strokin.rvb.randomizers.Dice;

public class GameApplication {

    // this code supports any board size, default size is 8x8
    public static final byte BOARD_SIZE = 8;
    public static final int ROUNDS = 15;

    public static void main(String... args) {

        Rook rook = new Rook(new Position("h1"), BOARD_SIZE);
        Bishop bishop = new Bishop(new Position("c3"), BOARD_SIZE);

        System.out.println("Starting a new game on  " + BOARD_SIZE + "x" + BOARD_SIZE + " board");

        Coin coin = new Coin();
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        boolean rookWon = true;

        for (int i = 1; i <= ROUNDS; i++) {
            printLine();
            System.out.println("Round " + i);
            System.out.println("Initial positions:");
            System.out.println("Bishop: " + bishop.getCurrentPosition() + " | Rook: " + rook.getCurrentPosition());

            // rolling dices, tossing a coin
            boolean isHeads = coin.isHeads();
            int dice1roll = dice1.roll();
            int dice2roll = dice2.roll();
            int move = dice1roll + dice2roll;

            System.out.println("Coin: " + (isHeads ? "heads" : "tails"));
            System.out.println("1st dice: " + dice1roll + ", 2nd dice: " + dice2roll);

            // make the move
            if (isHeads) {
                rook.moveUp(move);
            } else {
                rook.moveRight(move);
            }

            System.out.println("Rook moves " + move + " squares " + (isHeads ? "up" : "right") + " to " + rook.getCurrentPosition());

            // Sometimes rook could land on the bishop's square, lets say the bishop is killed be rook then.
            if (rook.getCurrentPosition().equals(bishop.getCurrentPosition())) {
                printLine();
                System.out.println("Rook captured Bishop on " + i + " round.");
                break;
            }

            // If bishop can capture rook the game is over
            if (bishop.canCapture(rook.getCurrentPosition())) {
                printLine();
                System.out.println("Bishop captured Rook on " + i + " round.");
                rookWon = false;
                break;
            }

            // We ran out of rounds, rook survived, long live the Rook!
            if (i == ROUNDS) {
                printLine();
                System.out.println("Bishop couldn't gat Rook.");
            }
        }

        if (rookWon) {
            System.out.println("Rook won!");
        } else {
            System.out.println("Bishop won!");
        }
    }

    private static void printLine() {
        System.out.println("---------------------------------------------");
    }
}
