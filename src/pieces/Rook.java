package pieces;

public class Rook extends Piece {


    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getTypeCode() {
        return this.isWhite ? "R" : "r";
    }

    public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
        int diffX = toX - fromX;
        int diffY = toY - fromY;

        if ((diffX != 0 && diffY == 0) || (diffX == 0 && diffY != 0)) {
            return true;
        }

        return false;
    }
}