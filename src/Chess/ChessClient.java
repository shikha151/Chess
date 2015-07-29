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



    public static void main(String args[]){

        ChessBoard gameChessBoard = new ChessBoard();
        //gameChessBoard.setChessBoard(chessBoard);
        //System.out.println(chessBoard);
        try {

            String pairOfMoves;

            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\test\\Desktop\\Chess\\src\\Chess\\PGN.txt"));



            while ((pairOfMoves = br.readLine()) != null) {
                gameChessBoard.playMoves(pairOfMoves);
                //gameChessBoard.display();



            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }



}
