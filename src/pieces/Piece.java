package pieces;

public abstract class Piece {
    protected boolean isWhite;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public abstract String getTypeCode();

    public abstract boolean isValidMove(int fromX, int fromY, int toX, int toY);
}