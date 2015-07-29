package Chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by test on 7/29/2015.
 */
public class ChessBoard {
    //System.out.println();
    Map<String,String > chessBoard = new HashMap<String,String>();
    private char pieceType;
    private String finalPosition;

   public ChessBoard(){
       setChessBoard();
   }
    public void setChessBoard(){

        for(char i ='a';i<='h';i++){
            for(int j= 1; j<=8;j++){
                chessBoard.put(i+String.valueOf(j),"#");
            }
        }
        //first row
        chessBoard.put("a1","WR");
        chessBoard.put("b1","WN");
        chessBoard.put("c1","WB");
        chessBoard.put("d1","WQ");
        chessBoard.put("e1","WK");
        chessBoard.put("f1","WB");
        chessBoard.put("g1","WN");
        chessBoard.put("h1","WR");
        //second white row(Pawns)
        chessBoard.put("a2","WP");
        chessBoard.put("b2","WP");
        chessBoard.put("c2","WP");
        chessBoard.put("d2","WP");
        chessBoard.put("e2","WP");
        chessBoard.put("f2","WP");
        chessBoard.put("g2","WP");
        chessBoard.put("h2","WP");
        //first black row
        chessBoard.put("a8","BR");
        chessBoard.put("b8","BN");
        chessBoard.put("c8","BB");
        chessBoard.put("d8","BQ");
        chessBoard.put("e8","BK");
        chessBoard.put("f8","BB");
        chessBoard.put("g8","BN");
        chessBoard.put("h8","BR");
        //second black row(Pawns)
        chessBoard.put("a7","BP");
        chessBoard.put("b7","BP");
        chessBoard.put("c7","BP");
        chessBoard.put("d7","BP");
        chessBoard.put("e7","BP");
        chessBoard.put("f7","BP");
        chessBoard.put("g7","BP");
        chessBoard.put("h7","BP");


    }

    public void playMoves(String pairOfMoves) {

        String moves[] = pairOfMoves.split(" |\\.");
        String whiteMove = moves[1];
        String blackMove = moves[2];
        executeOneMove(whiteMove,'W');
        executeOneMove(blackMove,'B');
    }


void executeOneMove(String move, char color){
    ArrayList<String> initialPositions = getInitialPositions(move);
    if(isPawnMove(move)){

    }
    else{
        for(String position: initialPositions){
            String mapValue = chessBoard.get(position);
            if(mapValue.charAt(0)==color && mapValue.charAt(1)==pieceType){
               chessBoard.put(position,"#");// might be error
                chessBoard.put(finalPosition,color+pieceType+"");
            }
        }


    }
}


    public ArrayList<String> getInitialPositions(String move){
         pieceType = move.charAt(0);
         finalPosition = move.substring(move.length() - 2);
        Piece piece=null;
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




    public boolean isPawnMove( String move){
        if(move.length()==2)
            return true;
        else
            return false;
    }

    public boolean isCapture( String move){
        return false;
    }

}