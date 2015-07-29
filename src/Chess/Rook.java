
package Chess;

import java.util.ArrayList;

public class Rook implements Piece {

    
    
    private boolean isValidMove(int row,int column)
    {
        return((row >= 1 && row <= 8 )&&(column >= 1 && column <= 8 ));
      
    }
    private String getCharacterForRow(int i)
    {
        
       return Character.toString((char) (i+ 96));
    }
    private ArrayList<String> getMoves( int row,int column)
    {
        ArrayList<String> result =  new ArrayList<String>();
        
       for(int i = row+1 ;i <= 8; i++)
       {
            result.add(getCharacterForRow(i)+(column+""));
       }
       for(int i = row-1 ;i >= 1; i--)
       {
            result.add(getCharacterForRow(i)+(column+""));
       }
       for(int i = column-1 ;i >= 1; i--)
       {
            result.add(getCharacterForRow(row)+(i+""));
       }
       for(int i = column+1 ;i <=8 ; i++)
       {
            result.add(getCharacterForRow(row)+(i+""));
       }
       
       return result;
    }
    @Override
    public ArrayList<String> getPossibleInitialPositions(String Position) {
       char row = Position.charAt(0);
        int columnnum = (int) Position.charAt(1) - '0';
        int rownum = row - 'a' +1;
        return getMoves(rownum,columnnum);
    }
    
}
