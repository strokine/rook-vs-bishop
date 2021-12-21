package info.strokin.rvb.pieces;

import info.strokin.rvb.Piece;
import info.strokin.rvb.Position;

public class Rook extends Piece {

    public Rook(Position currentPosition, int boardSize) {
        super(currentPosition, boardSize);
    }

    public boolean canCapture(Position position) {
        return getCurrentPosition().getFile() - position.getFile() == 0 || getCurrentPosition().getRank() - position.getRank() == 0;
    }

    public void moveRight(int right) {
        int file = currentPosition.getFile();
        file += right;
        file %= boardSize;
        currentPosition.setFile(file);
    }

    public void moveUp(int up) {
        int rank = currentPosition.getRank();
        rank += up;
        rank %= boardSize;
        currentPosition.setRank(rank);
    }
}
