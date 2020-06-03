import java.awt.*;
import java.awt.event.*;

class NumberPuzzleUI extends Frame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	// UI Components
	private Button[] buttons = new Button[16];
	private Panel numberGrid = new Panel();
	private Button shuffle = new Button("Shuffle");
	
	// game-tracking variables
	private int empty = 15;
	private boolean gameWon = false;
	
	private NumberPuzzleControl control;

	public NumberPuzzleUI(NumberPuzzleControl control)
	{
		this.control = control;
		
		initializeComponents(control);
	}
	private void initializeComponents(NumberPuzzleControl control) {
		add(numberGrid,BorderLayout.CENTER);
		numberGrid.setLayout(new GridLayout(4,4));
		
		for(int i=0;i<16;++i)
		{
			buttons[i] = new Button();
			numberGrid.add(buttons[i]);
			buttons[i].addActionListener(this);
		}

		shuffle.setFont(new Font("Arial",Font.BOLD,control.getShuffleButtonFontSize()));
		add(shuffle,BorderLayout.SOUTH);
		shuffle.addActionListener(this);
		
		setWindowProperties(control);

		setWindowClosingProperty();

		shuffleGrid();
		
		setVisible(true);
	}
	private void setWindowClosingProperty() {
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	private void setWindowProperties(NumberPuzzleControl control) {
		setSize(control.getWidth(),control.getHeight());
		setLocation(control.getXPosition(),control.getYPosition());
		setResizable(false);
		setTitle(control.getTitle());
	}
	private void shuffleGrid()
	{
		if(gameWon)
		{
			for(int i=0;i<16;++i)
			{
				buttons[i].addActionListener(this);
			}
		}

		for(int i=0;i<16;++i)
		{
			buttons[i].setBackground(Color.lightGray);
		}
	
		buttons[15].setLabel("  ");
		buttons[15].setBackground(control.getEmptyButtonColor());

		int arr[] = control.getRandomNumbersForGrid();
		
		for(int i=0;i<15;++i)
		{
			buttons[i].setLabel(arr[i] + "");
			buttons[i].setFont(new Font("Arial",Font.BOLD,control.getNumbersFontSize()));
		}

		empty = 15;
	}
	private void checkForWinner()
	{
		boolean winner = control.checkForWinner(buttons);
		if(winner)
		{
			for(int i=0;i<15;++i)
				buttons[i].removeActionListener(this);
			
			MessageDialog dialog = new MessageDialog(this,true);
			dialog.setMessage(control.getWinnerMessage());
			dialog.setVisible(true);
			
			gameWon = true;
		}
	}
	final public void actionPerformed(ActionEvent ae)	
	{
		Button b = (Button) ae.getSource();
		if(b == shuffle)
		{
			shuffleGrid();
		}
		else
		{
			NumberPuzzleGame game = new NumberPuzzleGame(empty,b,buttons);
			empty = control.handleButtonClicked(game);
		}

		if(empty == 15)
			checkForWinner();
	}
}