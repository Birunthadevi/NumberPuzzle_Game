import java.awt.*;


abstract class NumberPuzzleControl {
	private NumberPuzzleUI numberPuzzleUI;
	
	public NumberPuzzleControl() {
		numberPuzzleUI = new NumberPuzzleUI(this);
	}
	abstract public int getWidth();
	abstract public int getHeight();
	abstract public int getXPosition();
	abstract public int getYPosition();
	abstract public String getTitle();
	abstract public int getShuffleButtonFontSize();
	abstract public int getNumbersFontSize();
	abstract public Color getEmptyButtonColor();
	abstract public int handleButtonClicked(NumberPuzzleGame game);
	abstract public int[] getRandomNumbersForGrid();
	abstract public String getWinnerMessage();
	abstract public boolean checkForWinner(Button[] buttons);
	final protected int getRandomNumber() {
		double random = Math.random() * 100;
		int randInt = (int) (random);
		return randInt;
	}
	final protected void swapButton(Button emptyButton,Button clicked)
	{
		emptyButton.setLabel(clicked.getLabel());
		emptyButton.setBackground(Color.lightGray);
		Font font = clicked.getFont();
		emptyButton.setFont(font);
		clicked.setBackground(this.getEmptyButtonColor());
		clicked.setLabel("  ");
	}
	final protected int[] getIntegerArrayOfButtonIds(Button[] buttons) {
		int[] buttonIds = new int[15];
		for(int i=0;i<15;++i)
		{
			buttonIds[i] = Integer.parseInt(buttons[i].getLabel());
		}
		return buttonIds;
	} 
}
