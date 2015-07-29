package Chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by test on 7/29/2015.
 */
public class ChessBoard {
    //System.out.println();
    Map<String, String> chessBoard = new HashMap<String, String>();
    private char pieceType;
    private String finalPosition;
    private char conflictingCharacter;

    public ChessBoard() {
        setChessBoard();
    }

    public void setChessBoard() {

        for (char i = 'a'; i <= 'h'; i++) {
            for (int j = 1; j <= 8; j++) {
                chessBoard.put(i + String.valueOf(j), "#");
            }
        }
        //first row
        chessBoard.put("a1", "WR");
        chessBoard.put("b1", "WN");
        chessBoard.put("c1", "WB");
        chessBoard.put("d1", "WQ");
        chessBoard.put("e1", "WK");
        chessBoard.put("f1", "WB");
        chessBoard.put("g1", "WN");
        chessBoard.put("h1", "WR");
        //second white row(Pawns)
        chessBoard.put("a2", "WP");
        chessBoard.put("b2", "WP");
        chessBoard.put("c2", "WP");
        chessBoard.put("d2", "WP");
        chessBoard.put("e2", "WP");
        chessBoard.put("f2", "WP");
        chessBoard.put("g2", "WP");
        chessBoard.put("h2", "WP");
        //first black row
        chessBoard.put("a8", "BR");
        chessBoard.put("b8", "BN");
        chessBoard.put("c8", "BB");
        chessBoard.put("d8", "BQ");
        chessBoard.put("e8", "BK");
        chessBoard.put("f8", "BB");
        chessBoard.put("g8", "BN");
        chessBoard.put("h8", "BR");
        //second black row(Pawns)
        chessBoard.put("a7", "BP");
        chessBoard.put("b7", "BP");
        chessBoard.put("c7", "BP");
        chessBoard.put("d7", "BP");
        chessBoard.put("e7", "BP");
        chessBoard.put("f7", "BP");
        chessBoard.put("g7", "BP");
        chessBoard.put("h7", "BP");


    }

    public void playMoves(String pairOfMoves) {

        String moves[] = pairOfMoves.split(" |\\.");

        String whiteMove = moves[1];
        String blackMove = moves[2];

        executeOneMove(whiteMove, 'W');
        display();

        executeOneMove(blackMove, 'B');
        display();
    }

    private void doCastle(char color){

            if(color=='B'){
                chessBoard.put("g8","BK");
                chessBoard.put("e8","#");
                chessBoard.put("f8","BR");
                chessBoard.put("h8","#");
            }
            else {
                chessBoard.put("g1", "WK");
                chessBoard.put("e1", "#");
                chessBoard.put("f1", "WR");
                chessBoard.put("h1", "#");

            }
    }

    private void executeOneMove(String move, char color) {
        if(isCastleMove(move)){
            doCastle(color);
        }

        if (isPawnMove(move)) {
            finalPosition = move.substring(move.length() - 2);
            pieceType = 'P';
            ArrayList<String> initialPositions;
            if (isCapture(move)) {
                Piece pawnCapture = new PawnCapture();
                initialPositions = pawnCapture.getPossibleInitialPositions(finalPosition);
            } else {
                Piece pawn = new Pawn();
                initialPositions = pawn.getPossibleInitialPositions(finalPosition);
            }

            for (String position : initialPositions) {
                String mapValue = chessBoard.get(position);
                if (mapValue.charAt(0) == color && mapValue.charAt(1) == pieceType) {
                    // System.out.print(color + " " + pieceType + finalPosition + " " +position);
                    if (color == 'W' && (position.charAt(1) < finalPosition.charAt(1))) {
                        if (isConflictingMove(move)) {
                            if (position.contains(String.valueOf(conflictingCharacter))) {
                                modifyChessboard(position, color);
                                break;
                            }
                        } else {
                            modifyChessboard(position, color);
                            break;
                        }

                    } else if (position.charAt(1) > finalPosition.charAt(1) && color == 'B') {
                        if (isConflictingMove(move)) {
                            //dummy
                            //System.out.println(position);
                           //System.out.println(position.contains(String.valueOf(conflictingCharacter)));
                            if (position.contains(String.valueOf(conflictingCharacter))) {
                                System.out.println(conflictingCharacter);
                                modifyChessboard(position, color);
                                break;

                            }
                        } else {
                            modifyChessboard(position, color);
                            break;
                        }


                    }

                }
            }


        } else {
            ArrayList<String> initialPositions = getInitialPositions(move);
            for (String position : initialPositions) {
                String mapValue = chessBoard.get(position);
                if (mapValue.charAt(0) == color && mapValue.charAt(1) == pieceType) {
                    if (isConflictingMove(move)) {
                        if (position.contains(String.valueOf(conflictingCharacter))) {
                            modifyChessboard(position, color);
                            break;
                        }
                    } else {
                        modifyChessboard(position, color);
                        break;
                    }

                }
            }
        }
    }

    private void modifyChessboard(String position, char color) {
        chessBoard.put(position, "#");
        chessBoard.put(finalPosition, String.valueOf(color) + String.valueOf(pieceType));
    }

    private ArrayList<String> getInitialPositions(String move) {
        pieceType = move.charAt(0);
        finalPosition = move.substring(move.length() - 2);
        Piece piece = null;
        switch (pieceType) {
            case 'N':
                //knight
                piece = new Knight();
                break;
            case 'K':
                piece = new King();
                break;
            case 'Q':
                piece = new Queen();
                break;
            case 'B':
                piece = new Bishop();
                break;
            case 'R':
                piece = new Rook();
                break;
        }
        return piece.getPossibleInitialPositions(finalPosition);
    }


    private boolean isPawnMove(String move) {
        if (move.matches(".*[BRKQN].*")){
            return false;
        }
        else{
            return true;
        }


    }

    private boolean isCapture(String move) {
        return move.contains("x");
    }

    private Boolean isCastleMove(String move){
        return move.equals("O_O");
    }

    private boolean isConflictingMove(String move) {
        if (!isCapture(move) && isPawnMove(move)) {
            if (move.length() == 3) {
                conflictingCharacter = move.charAt(0);
                return true;
            }
        } else if (isCapture(move) && isPawnMove(move)) {
            if (move.length() == 4) {
                conflictingCharacter = move.charAt(0);
                return true;
            }
        } else if (!isPawnMove(move) && !isCapture(move)) {
            if (move.length() == 4) {
                conflictingCharacter = move.charAt(1);
                return true;
            }
        } else if (!isPawnMove(move) && isCapture(move)) {
            conflictingCharacter = move.charAt(1);
            if (move.length() == 5) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 8; i > 0; i--) {
            String outputString = "";
            for (int j = 1; j <= 8; j++) {

                String key = Character.toString((char) (j + 96)) + i;
                if (chessBoard.containsKey(key)) {
                    outputString += chessBoard.get(key) + "\t";
                } else {
                    outputString += "#\t";
                }
            }
            System.out.println(outputString);

        }
        System.out.println("------------------------------------------------");
    }

}
