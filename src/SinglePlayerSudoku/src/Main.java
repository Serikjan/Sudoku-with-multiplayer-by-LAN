import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;


@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener
{
	/**
	 * @param args
	 */
	private JButton buttonSinglePlayer;
	private JButton buttonMultiplayer;
	private JButton buttonOptions;
	private JButton buttonHighScore;
	private JButton buttonExit;
	public Main()
	{
		this.setLayout(null);
		this.setBounds(500,200,200,280);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Sudoku");
		
		buttonSinglePlayer=new JButton("Singleplayer");
		buttonSinglePlayer.setBounds(40, 40, 120, 25);
		buttonSinglePlayer.addActionListener(this);
		
		buttonMultiplayer=new JButton("Multiplayer");
		buttonMultiplayer.setBounds(40, 75, 120, 25);
		buttonMultiplayer.addActionListener(this);
		
		buttonOptions=new JButton("Options");
		buttonOptions.setBounds(40, 110, 120, 25);
		buttonOptions.addActionListener(this);
		
		buttonHighScore=new JButton("Highscore");
		buttonHighScore.setBounds(40, 145, 120, 25);
		buttonHighScore.addActionListener(this);
		
		buttonExit=new JButton("Exit");
		buttonExit.setBounds(40, 180, 120, 25);
		buttonExit.addActionListener(this);
		
		getContentPane().add(buttonSinglePlayer);
		getContentPane().add(buttonMultiplayer);
		getContentPane().add(buttonOptions);
		getContentPane().add(buttonHighScore);
		getContentPane().add(buttonExit);
		
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
			SelectPlayer s = null;
			try
			{
				s = new SelectPlayer();
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
