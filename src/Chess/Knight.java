
package Chess;

import java.util.ArrayList;

public class Knight implements Piece {

    public int LIMIT = 8;
    private boolean isValidMove(int row,int column)
    {
        return((row >= 1 && row <= LIMIT )&&(column >= 1 && column <= LIMIT ));
      
    }
    private String getCharacterForRow(int i)
    {
        
       return Character.toString((char) (i+ 96));
    }
    private ArrayList<String> getMoves( int row,int column)
    {
        ArrayList<String> result =  new ArrayList<String>();
        
        if(isValidMove(row-2,column -1))
        {
            result.add(getCharacterForRow(row-2)+((column-1)+""));    
        }
        if(isValidMove(row-1,column -2))
        {
            result.add(getCharacterForRow(row-1)+((column-2)+""));    
        }
        if(isValidMove(row-2,column +1))
        {
            result.add(getCharacterForRow(row-2)+((column+1)+""));    
        }
        if(isValidMove(row-1,column +2))
        {
            result.add(getCharacterForRow(row-1)+((column+2)+""));    
        }
        if(isValidMove(row+2,column -1))
        {
            result.add(getCharacterForRow(row+2)+((column-1)+""));    
        }
        if(isValidMove(row+1,column -2))
        {
            result.add(getCharacterForRow(row+1)+((column-2)+""));    
        }
        if(isValidMove(row+2,column +1))
        {
            result.add(getCharacterForRow(row+2)+((column+1)+""));    
        }
        if(isValidMove(row+1,column +2))
        {
            result.add(getCharacterForRow(row+1)+((column+2)+""));    
        }
        return result;
    }
    
    @Override
    public ArrayList<String> getPossibleInitialPositions(String Position) {
        char row = Position.charAt(0);
        int columnnum = (int) Position.charAt(1) - '0';
        int rownum = row - 'a' +1;
        return  getMoves (rownum,columnnum);
    }
    
}
