import java.awt.*;
import java.awt.event.*;

class MessageDialog extends Dialog {
	private static final long serialVersionUID = 1L;
	private Label lblMessage;

	public MessageDialog(Frame parent) {
		super(parent);
		initComponents();
	}
	public MessageDialog(Frame parent,boolean modal) {
		super(parent,modal);
		initComponents();
	}
	public void setMessage(String message) {
		lblMessage.setText(message);
	}
	private void initComponents() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(Color.white);
		setForeground(Color.black);
		setSize(295, 111);
		
		add(getLblMessage());
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent event) {
				setVisible(false);
				dispose();
			}
		});
	}
	private Label getLblMessage() {
		if (lblMessage == null) {
			lblMessage = new Label();
		}
		return lblMessage;
	}
}