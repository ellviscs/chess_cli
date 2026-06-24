package pieces;

public class Knight extends Piece {


    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getTypeCode() {
        return this.isWhite ? "N" : "n";
    }

    public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
        int diffX = Math.abs(toX - fromX);
        int diffY = Math.abs(toY - fromY);

        if ((diffX == 1 && diffY == 2) || (diffX == 2 && diffY == 1)) {
            return true;
        }

        return false;
    }
}