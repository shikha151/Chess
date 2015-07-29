
package Chess;

import java.util.ArrayList;

public class Queen implements Piece {

    @Override
    public ArrayList<String> getPossibleInitialPositions(String Position) {
      
        Bishop bishop = new Bishop();
        Rook rook = new Rook();
        ArrayList<String> results = bishop.getPossibleInitialPositions(Position);
        results.addAll(rook.getPossibleInitialPositions(Position));
        return results;
    }
   
}
