import java.awt.*;


class NumberPuzzleGame {
	int emptyCellId;
	Button buttonClicked;
	Button[] buttons;
	
	public NumberPuzzleGame() { }
	
	public NumberPuzzleGame(int emptyCellId,Button buttonClicked,Button[] buttons) {
		this.emptyCellId = emptyCellId;
		this.buttonClicked = buttonClicked;
		this.buttons = buttons;
	}
	
	public int getEmptyCellId() {
		return emptyCellId;
	}
	public void setEmptyCellId(int emptyCellId) {
		this.emptyCellId = emptyCellId;
	}
	public Button getButtonClicked() {
		return buttonClicked;
	}
	public void setButtonClicked(Button buttonClicked) {
		this.buttonClicked = buttonClicked;
	}
	public Button[] getButtons() {
		return buttons;
	}
	public void setButtons(Button[] buttons) {
		this.buttons = buttons;
	}
}