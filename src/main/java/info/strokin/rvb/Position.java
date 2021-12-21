package info.strokin.rvb;

import java.util.Objects;

public class Position {

    private int file;
    private int rank;

    public Position(String position) {
        if (position == null) {
            throw new IllegalArgumentException("Position can't be null");
        }
        if (position.length() < 2) {
            throw new IllegalArgumentException("Position should be at least 2 characters, ex c3");
        }

        char fileCode = position.toLowerCase().charAt(0);
        if (fileCode < 'a' || fileCode > 'z') {
            throw new IllegalArgumentException("File should be character from 'a' to 'z', ex c3");
        }
        this.file = fileCode - 'a';

        String rankCode = position.substring(1);
        try {
            this.rank = Integer.parseInt(rankCode) - 1;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Rank should be a number.", e);
        }
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return file == position.file && rank == position.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

    @Override
    public String toString() {
        return Character.toString('a' + file) + "" + (rank + 1);
    }
}
