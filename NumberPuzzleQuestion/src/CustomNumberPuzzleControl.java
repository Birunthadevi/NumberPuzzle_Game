import java.awt.*;
import java.util.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here		
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr=new int[15];
		ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i=1; i<16; i++) {
            list.add(new Integer(i));
        }
		
        Collections.shuffle(list);
        for (int i=0; i<15; i++) {
            arr[i]=list.get(i);
        }
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		getIntegerArrayOfButtonIds(buttons);

		return winner;
	}
}