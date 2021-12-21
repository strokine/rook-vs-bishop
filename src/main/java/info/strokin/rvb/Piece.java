package info.strokin.rvb;

public abstract class Piece {

    protected Position currentPosition;
    protected int boardSize;

    public Piece(Position currentPosition, int boardSize) {
        this.currentPosition = currentPosition;
        this.boardSize = boardSize;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public abstract boolean canCapture(Position position);
}
