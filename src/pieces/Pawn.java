package pieces;

public class Pawn extends Piece {


    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getTypeCode() {
        return this.isWhite ? "P" : "p";
    }

    public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
        int diffX = toX - fromX;
        int diffY = toY - fromY;

        int forwardDirection = this.isWhite ? 1 : -1;
        int startingRow = this.isWhite ? 2 : 7; // Baris awal pion di array kamu

        if (diffY == 0) {
            if (diffX == forwardDirection) {
                return true;
            }
            if (fromX == startingRow && diffX == (2 * forwardDirection)) {
                return true;
            }
        }

        if (diffX == forwardDirection && (diffY == 1 || diffY == -1)) {
            return true;
        }
        return false;
    }
}