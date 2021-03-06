import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class AddPlayer extends JFrame implements ActionListener, KeyListener
{
	private JLabel labelName;
	private JTextField textName;
	private JButton buttonOk;
	private JButton buttonCancel;
	private File fileDir;
	private File fileNames;
	private String stringPath;
	
	AddPlayer() throws IOException
	{
		this.setLayout(null);
		this.setBounds(500,200,200,160);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Add a player");
		
		labelName = new JLabel("Player's name:");
		labelName.setBounds(10,10,100,25);
		
		textName = new JTextField();
		textName.setBounds(10,45,170,25);
		textName.addKeyListener(this);
		
		buttonOk = new JButton("OK");
		buttonOk.setBounds(10,80,80,25);
		buttonOk.addActionListener(this);
		buttonOk.setEnabled(false);
		
		buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(100,80,80,25);
		buttonCancel.addActionListener(this);
		
		fileDir = new File(".");
		stringPath = new String(fileDir.getCanonicalPath()+"\\Players.txt");
		fileNames = new File(stringPath);
		
		this.add(labelName);
		this.add(textName);
		this.add(buttonOk);
		this.add(buttonCancel);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getActionCommand().equalsIgnoreCase("OK"))
		{
			if(fileNames.exists())
			{
				BufferedWriter writer = null;
				try
				{
					writer = new BufferedWriter(new FileWriter(fileNames,true));
					if(textName.getText()!="")
					{
						writer.newLine();
						writer.write(textName.getText());
					}
					else
					{
						
					}
					writer.close();
				}
				catch (IOException e2)
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			else
			{
				System.out.println("Error: Players.txt file doesn't exist!");
			}
			
			this.dispose();
			SelectPlayer selectDialog = null;
			try
			{
				selectDialog = new SelectPlayer();
				selectDialog.show();
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equalsIgnoreCase("Cancel"))
		{
			this.dispose();
			SelectPlayer selectDialog = null;
			try
			{
				selectDialog = new SelectPlayer();
				selectDialog.show();
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else
		{
			System.out.println("Unknown error in ActionListener!");
			this.dispose();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		if(textName.getText()!="")
		{
			buttonOk.setEnabled(true);
		}
		else
		{
			buttonOk.setEnabled(false);
		}
	}
	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
	}

}
