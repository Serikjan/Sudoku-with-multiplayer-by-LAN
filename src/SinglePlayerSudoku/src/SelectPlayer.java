import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class SelectPlayer extends JFrame implements ActionListener
{
	private JButton[] button=new JButton[6];
	private JList list;
	private Vector names;
	SelectPlayer()
	{
		this.setLayout(null);
		this.setBounds(500,200,400,400);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Select Player");
		
		button[0]=new JButton("Add");
		button[0].setBounds(40, 40, 90, 25);
		button[0].addActionListener(this);
		
		button[1]=new JButton("Rename");
		button[1].setBounds(140, 40, 90, 25);
		button[1].addActionListener(this);
		
		button[2]=new JButton("Delete");
		button[2].setBounds(240, 40, 90, 25);
		button[2].addActionListener(this);
		
		button[3]=new JButton("Play");
		button[3].setBounds(40, 300, 90, 25);
		button[3].addActionListener(this);
		
		button[4]=new JButton("Back");
		button[4].setBounds(240, 300, 90, 25);
		button[4].addActionListener(this);
		
		names = new Vector();
		list = new JList(names);
		
		getContentPane().add(new JScrollPane(list));
		getContentPane().add(button[0]);
		getContentPane().add(button[1]);
		getContentPane().add(button[2]);
		getContentPane().add(button[3]);
		getContentPane().add(button[4]);
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getActionCommand().equalsIgnoreCase("Add"))
		{
			
		}
		else if(e.getActionCommand().equalsIgnoreCase("Back"))
		{
			this.dispose();
			Main m = new Main();
			m.show();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Play"))
		{
			this.dispose();
			Game g = new Game();
		}
	}
	
}
