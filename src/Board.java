import pieces.*;

public class Board {

    Piece[][] board = new Piece[8][8];

    void getNewBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 || i == 7) {
                    if (j == 0 || j == 7) {
                        this.board[i][j] = new Rook(i == 7);
                    } else if (j == 1 || j == 6) {
                        this.board[i][j] = new Knight(i == 7);
                    } else if (j == 2 || j == 5) {
                        this.board[i][j] = new Bishop(i == 7);
                    } else if (j == 4) {
                        this.board[i][j] = new King(i == 7);
                    } else {
                        this.board[i][j] = new Queen(i == 7);
                    }
                } else if (i == 1 || i == 6) {
                    this.board[i][j] = new Pawn(i == 6);
                }
            }
        }
    }

    void getBoard(boolean isWhiteTurn) {
        for (int i = 0; i < 9; i++) {
            int boardNumber = isWhiteTurn ? 8 - i : i + 1;
            int xIndex = 8 - boardNumber;
            if (i < 8) {
                System.out.print(boardNumber + " |");
                for (int j = 0; j < 8; j++) {
                    int boardLetter = isWhiteTurn ? 'a' + j : 'h' - j;
                    int yIndex = boardLetter - 'a';
                    Piece pieces = board[xIndex][yIndex];
                    String boardColor = (i + j) % 2 == 0 ? "\u001B[107m" : "\u001B[47;1m";
                    if (null == board[xIndex][yIndex]) {
                        System.out.print(boardColor + "." + "\u001B[0m" + "|");
                    } else {
                        String pieceColor = pieces.isWhite() ? "\u001B[37m" : "\u001B[30m";
                        System.out.print(boardColor + pieceColor + pieces.getTypeCode() + "\u001B[0m" + "|");
                    }
                }
                System.out.println();
            }
            if (i == 8) {
                System.out.print("   ");
                for (int j = 0; j < 8; j++) {
                    int boardLetter = isWhiteTurn ? 'a' + j : 'h' - j;
                    System.out.print((char) (boardLetter) + " ");
                }
                System.out.println();
            }
        }
    }

    boolean getMove(int fromCol, int fromRow, int toCol, int toRow) {
        // Check if the move is still on the board
        //validate
        int fromRowIndex = 8 - fromRow;
        int fromColIndex = fromCol - 1;
        int toRowIndex = 8 - toRow;
        int toColIndex = toCol - 1;

        boolean isValid = isValid(fromRow, fromCol, toRow, toCol);
        if (!isValid) {
            return false;
        }

        Piece piece = board[fromRowIndex][fromColIndex];
        board[toRowIndex][toColIndex] = piece;
        board[fromRowIndex][fromColIndex] = null;
        return true;


        //return isMoveOnBoard;
        //Piece piece = this.board[8 - a]
    }

    boolean isValid(int fromRow, int fromCol, int toRow, int toCol) {
        int fromRowIndex = 8 - fromRow;
        int fromColIndex = fromCol - 1;
        int toRowIndex = 8 - toRow;
        int toColIndex = toCol - 1;
        Piece piece = board[fromRowIndex][fromColIndex];

        if (piece == null) {
            return false;
        }

        boolean isMoveOnBoard = isValidIndex(fromRowIndex, fromColIndex) && isValidIndex(toRowIndex, toColIndex);
        boolean isValidMove = piece.isValidMove(fromRow, fromCol, toRow, toCol);
        boolean isEmptyWay = isEmptyWay(fromRowIndex, fromColIndex, toRowIndex, toColIndex);

        if ((piece.getTypeCode().equals("P") || piece.getTypeCode().equals("p")) && Math.abs(toCol - fromCol) == 1) {
            Piece target = board[toRowIndex][toColIndex];
            isValidMove = (target != null && piece.isWhite() != target.isWhite());
        }

        return isMoveOnBoard && isValidMove && isEmptyWay;
    }

    private boolean isValidIndex(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public boolean isEmptyWay(int fromRow, int fromCol, int toRow, int toCol) {
        int currentRow = fromRow + Integer.signum(toRow - fromRow);
        int currentCol = fromCol + Integer.signum(toCol - fromCol);
        Piece piece = board[fromRow][fromCol];
        Piece target = board[toRow][toCol];

        if (piece.getTypeCode().equals("N") || piece.getTypeCode().equals("n")) {
            return target == null || target.isWhite() != piece.isWhite();
        }

        while (currentRow != toRow || currentCol != toCol) {

            if (board[currentRow][currentCol] != null) {
                return false;
            }

            currentRow += Integer.signum(toRow - currentRow);
            currentCol += Integer.signum(toCol - currentCol);
        }

        return target == null || target.isWhite() != piece.isWhite();
    }
}