package Chess;

import java.util.ArrayList;

public interface Piece {
    
    ArrayList<String> getPossibleInitialPositions(String finalPosition);
}
