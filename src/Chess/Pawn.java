package Chess;

import java.util.ArrayList;

public class Pawn implements Piece {

	public static void main(String[] args) {
		System.out.println(new Pawn().getPossibleInitialPositions("d3"));
	}

	@Override
	public ArrayList<String> getPossibleInitialPositions(String finalPosition) {
		ArrayList<String> possibleInitialMoves = new ArrayList<String>();
		int[][] moves = { { 0, -1 }, { 0, 1 }, { 0, 2 }, { 0, -2 } };
		for(int [] i : moves)
		{
			if(positionExists((char)(finalPosition.charAt(0)+i[0])+""+(char)(finalPosition.charAt(1)+i[1])))
				possibleInitialMoves.add((char)(finalPosition.charAt(0)+i[0])+""+(char)(finalPosition.charAt(1)+i[1]));
		}
		return possibleInitialMoves;
	}
	private boolean positionExists(String possibleInitialPosition) {
		return (('a' <= possibleInitialPosition.charAt(0) && 
				possibleInitialPosition.charAt(0) <= 'h') && 
				('1' <= possibleInitialPosition.charAt(1) && 
				possibleInitialPosition.charAt(1) <= '8'));
	}
}
