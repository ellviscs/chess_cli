package pieces;

public class Bishop extends Piece {


    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getTypeCode() {
        return this.isWhite ? "B" : "b";
    }

    public boolean isValidMove(int fromX, int fromY, int toX, int toY) {
        int diffX = Math.abs(toX - fromX);
        int diffY = Math.abs(toY - fromY);

        return (diffX == diffY && diffX != 0);
    }
}