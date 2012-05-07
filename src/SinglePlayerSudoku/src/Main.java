import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener
{
	/**
	 * @param args
	 */
	private JButton[] button=new JButton[5];
	public Main()
	{
		this.setLayout(null);
		this.setBounds(500,200,200,280);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Sudoku");
		
		button[0]=new JButton("Singleplayer");
		button[0].setBounds(40, 40, 120, 25);
		button[0].addActionListener(this);
		
		button[1]=new JButton("Multiplayer");
		button[1].setBounds(40, 75, 120, 25);
		button[1].addActionListener(this);
		
		button[2]=new JButton("Options");
		button[2].setBounds(40, 110, 120, 25);
		button[2].addActionListener(this);
		
		button[3]=new JButton("Highscore");
		button[3].setBounds(40, 145, 120, 25);
		button[3].addActionListener(this);
		
		button[4]=new JButton("Exit");
		button[4].setBounds(40, 180, 120, 25);
		button[4].addActionListener(this);
		
		getContentPane().add(button[0]);
		getContentPane().add(button[1]);
		getContentPane().add(button[2]);
		getContentPane().add(button[3]);
		getContentPane().add(button[4]);
		
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Main m = new Main();
		m.show();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getActionCommand().equalsIgnoreCase("Singleplayer"))
		{
			this.dispose();
			SelectPlayer s = new SelectPlayer();
			s.show();
		}
		else if (e.getActionCommand().equalsIgnoreCase("Multiplayer"))
		{
			
		}
		else if (e.getActionCommand().equalsIgnoreCase("Options"))
		{
			
		}
		else if (e.getActionCommand().equalsIgnoreCase("Highscore"))
		{
			
		}
		else if (e.getActionCommand().equalsIgnoreCase("Exit"))
		{
			 this.dispose();
		}
		else
		{
			System.out.println("Error!");
			this.dispose();
		}
	}

}
