package Chess;

import java.util.ArrayList;

public class PawnCapture implements Piece{

	

	@Override
	public ArrayList<String> getPossibleInitialPositions(String finalPosition) {
		ArrayList<String> possibleInitialPositions = new ArrayList<String>();
		
		int[][] moves = { { 1, -1 }, { 1, 1 }, { -1, -1 }, { -1, 1 } };
		for(int [] i : moves)
		{
			if(positionExists((char)(finalPosition.charAt(0)+i[0])+""+(char)(finalPosition.charAt(1)+i[1])))
				possibleInitialPositions.add((char)(finalPosition.charAt(0)+i[0])+""+(char)(finalPosition.charAt(1)+i[1]));
		}
		
		return possibleInitialPositions;
	}
	private boolean positionExists(String possibleInitialPosition) {
		return (('a' <= possibleInitialPosition.charAt(0) && 
				possibleInitialPosition.charAt(0) <= 'h') && 
				('1' <= possibleInitialPosition.charAt(1) && 
				possibleInitialPosition.charAt(1) <= '8'));
	}
}
