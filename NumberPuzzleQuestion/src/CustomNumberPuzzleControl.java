import java.awt.*;

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
		int i = 0;
		for(Button button : buttons) {
			if(buttonClicked == button) {
				break;
			} else i++;
		}
		swapButton(buttons[emptyCellId], buttonClicked);
		emptyCellId = i;
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		//int a = getRandomNumber();
		for(int i = 0; i < 15; i++) {
			arr[i] = -1;
		}
		
		//int totalNos = 0;
		int n = 0;
		while(n != 15) {
			int flag = 0;
			int a = getRandomNumber();
			a = a%15;
			if( a == 0) a = 15;
			for(int i = 0; i  < n; i++) {
				if(arr[i] == a) flag = 1;
			}
			if(flag == 0) {
				arr[n] = a;
				System.out.print(a + " ");
				n++;
			}
		}
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int nos[] = getIntegerArrayOfButtonIds(buttons);
		int flag = 0;
		for(int i = 0; i < nos.length; i++) {
			if(nos[i] != i+1) {
				flag =1;
				break;
			}
		}
		if(flag == 1) winner = false;
		return winner;

	}
}