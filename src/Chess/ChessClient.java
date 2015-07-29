package Chess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by test on 7/29/2015.
 */

public class ChessClient {

    public static void setChessBoard( Map<String,String > chessBoard){

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

    public static void main(String args[]){
        Map<String,String > chessBoard = new HashMap<String,String>();
        setChessBoard(chessBoard);
        //System.out.println(chessBoard);
        try {

            String pairOfMoves;

            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\test\\Desktop\\Chess\\src\\PGN.txt"));

            while ((pairOfMoves = br.readLine()) != null) {
                //System.out.println(pairOfMoves);
                String moves[] = pairOfMoves.split(" |\\.");
                String whiteMove = moves[1];
                String blackMove = moves[2];


            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }



}
