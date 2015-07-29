package Chess;

import java.util.ArrayList;

public class Bishop implements Piece {
	private ArrayList<String> moveUpForwardSlash(String finalPosition) {
		int i = 1;
		ArrayList<String> possibleInitialPositions = new ArrayList<String>();
		while (finalPosition.charAt(0) + i <= 'h'
				&& finalPosition.charAt(1) + i <= '8') {
			possibleInitialPositions.add((char) (finalPosition.charAt(0) + i)
					+ "" + (char) (finalPosition.charAt(1) + i));
			i++;
		}
		return possibleInitialPositions;
	}

	private ArrayList<String> moveDownForwardSlash(String finalPosition) {
		int i = 1;
		ArrayList<String> possibleInitialPositions = new ArrayList<String>();
		while (finalPosition.charAt(0) - i >= 'a'
				&& finalPosition.charAt(1) - i >= '1') {
			possibleInitialPositions.add((char) (finalPosition.charAt(0) - i)
					+ "" + (char) (finalPosition.charAt(1) - i));
			i++;
		}
		return possibleInitialPositions;
	}

	private ArrayList<String> moveUpBackwardSlash(String finalPosition) {
		int i = 1;
		ArrayList<String> possibleInitialPositions = new ArrayList<String>();
		while (finalPosition.charAt(0) - i >= 'a'
				&& finalPosition.charAt(1) + i <= '8') {
			possibleInitialPositions.add((char) (finalPosition.charAt(0) - i)
					+ "" + (char) (finalPosition.charAt(1) + i));
			i++;
		}
		return possibleInitialPositions;
	}

	private ArrayList<String> moveDownBackwardSlash(String finalPosition) {
		int i = 1;
		ArrayList<String> possibleInitialPositions = new ArrayList<String>();
		while (finalPosition.charAt(0) + i <= 'h'
				&& finalPosition.charAt(1) - i >= '1') {
			possibleInitialPositions.add((char) (finalPosition.charAt(0) + i)
					+ "" + (char) (finalPosition.charAt(1) - i));
			i++;
		}
		return possibleInitialPositions;
	}

	@Override
	public ArrayList<String> getPossibleInitialPositions(String finalPosition) {

		ArrayList<String> possibleInitialPositions = moveUpForwardSlash(finalPosition);
		possibleInitialPositions.addAll(moveDownForwardSlash(finalPosition));
		possibleInitialPositions.addAll(moveUpBackwardSlash(finalPosition));
		possibleInitialPositions.addAll(moveDownBackwardSlash(finalPosition));
		
		return possibleInitialPositions;
	}

	
}
