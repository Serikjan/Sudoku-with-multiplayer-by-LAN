import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class AddPlayer extends JFrame implements ActionListener
{
	private JLabel label;
	private JTextField textName;
	private JButton buttonOk;
	private JButton buttonCancel;
	AddPlayer()
	{
		this.setLayout(null);
		this.setBounds(500,200,200,160);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Add a player");
		
		label = new JLabel("Player's name:");
		label.setBounds(10,10,100,25);
		
		textName = new JTextField();
		textName.setBounds(10,45,170,25);
		
		buttonOk = new JButton("OK");
		buttonOk.setBounds(10,80,80,25);
		
		buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(100,80,80,25);
		
		this.add(label);
		this.add(textName);
		this.add(buttonOk);
		this.add(buttonCancel);
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

}
