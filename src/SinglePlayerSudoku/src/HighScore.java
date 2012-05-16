import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class HighScore extends JFrame implements ActionListener
{
	HighScore()
	{
		this.setLayout(null);
		this.setBounds(500,200,400,400);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("High Score");
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
