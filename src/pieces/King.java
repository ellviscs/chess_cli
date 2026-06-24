package pieces;

public class King extends Piece {


    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getTypeCode() {
        return this.isWhite ? "K" : "k";
    }

    public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
        return true;
    }
}