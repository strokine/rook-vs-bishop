package info.strokin.rvb.pieces;

import info.strokin.rvb.Piece;
import info.strokin.rvb.Position;

public class Bishop extends Piece {

    public Bishop(Position currentPosition, int boardSize) {
        super(currentPosition, boardSize);
    }

    public boolean canCapture(Position position) {
        return Math.abs(getCurrentPosition().getFile() - position.getFile()) == Math.abs(getCurrentPosition().getRank() - position.getRank());
    }
}
