package pieces;

public class Queen extends Piece {


    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getTypeCode() {
        return this.isWhite ? "Q" : "q";
    }

    public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
        int diffX = toX - fromX;
        int diffY = toY - fromY;

        if ((diffX != 0 && diffY == 0) || (diffX == 0 && diffY != 0)) {
            return true;
        }

        return (Math.abs(diffX) == Math.abs(diffY) && diffX != 0);
    }
}