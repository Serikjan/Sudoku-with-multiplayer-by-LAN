import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


@SuppressWarnings("serial")
public class SelectPlayer extends JFrame implements ActionListener, ListSelectionListener
{
	private JButton buttonAdd;
	private JButton buttonRename;
	private JButton buttonDelete;
	private JButton buttonPlay;
	private JButton buttonBack;
	private File fileDir;
	private File fileNames;
	private String stringPath;
	
	@SuppressWarnings("rawtypes")
	private JList listNames;
	@SuppressWarnings("rawtypes")
	Vector vectorNames;
	private JScrollPane scrollPaneNames;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	SelectPlayer() throws IOException
	{
		this.setLayout(null);
		this.setBounds(500,200,400,400);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Select Player");
		
		buttonAdd = new JButton("Add");
		buttonAdd.setBounds(40, 40, 90, 25);
		buttonAdd.addActionListener(this);
		
		buttonRename = new JButton("Rename");
		buttonRename.setBounds(140, 40, 90, 25);
		buttonRename.addActionListener(this);
		buttonRename.setEnabled(false);
		
		buttonDelete = new JButton("Delete");
		buttonDelete.setBounds(240, 40, 90, 25);
		buttonDelete.addActionListener(this);
		buttonDelete.setEnabled(false);
		
		buttonPlay = new JButton("Play");
		buttonPlay.setBounds(40, 300, 90, 25);
		buttonPlay.addActionListener(this);
		buttonPlay.setEnabled(false);
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(240, 300, 90, 25);
		buttonBack.addActionListener(this);
		
		fileDir = new File(".");
		stringPath = new String(fileDir.getCanonicalPath()+"\\Players.txt");
		fileNames = new File(stringPath);
		
		vectorNames = new Vector();
		listNames = new JList(vectorNames);
		scrollPaneNames = new JScrollPane(listNames);
		scrollPaneNames.setBounds(40, 75, 290,215);
		listNames.addListSelectionListener(this);
		
		if(fileNames.exists())
		{
			BufferedReader reader = new BufferedReader(new FileReader(fileNames));
            String tmp;
            while((tmp = reader.readLine())!= null)
            {
                String name = (new String(tmp.getBytes(),"UTF-8"));
                vectorNames.addElement(name);
            }
            reader.close();
		}
		else
		{
			System.out.println("Error: Players.txt file doesn't exist!");
		}
		
		getContentPane().add(scrollPaneNames);
		getContentPane().add(buttonAdd);
		getContentPane().add(buttonRename);
		getContentPane().add(buttonDelete);
		getContentPane().add(buttonPlay);
		getContentPane().add(buttonBack);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getActionCommand().equalsIgnoreCase("Add"))
		{
			this.dispose();
			AddPlayer addDialog = null;
			try
			{
				addDialog = new AddPlayer();
				addDialog.show();
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equalsIgnoreCase("Back"))
		{
			this.dispose();
			Main mainDialog = new Main();
			mainDialog.show();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Play"))
		{
//<<<<<<< HEAD
			//this.dispose();
			//Sudoku playDialog = new Main();
			//playDialog.show();
			this.dispose();
			Game g = new Game();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Rename"))
		{
			this.dispose();
			RenamePlayer renameDialog = null;
			try
			{
				renameDialog = new RenamePlayer(listNames.getSelectedValue().toString());
				renameDialog.show();
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equalsIgnoreCase("Delete"))
		{
			if(fileNames.exists())
			{
				String allNames="";
				int i=0;
				BufferedWriter writer = null;
				try
				{
					BufferedReader reader = new BufferedReader(new FileReader(fileNames));
					String tmp;
					while((tmp = reader.readLine())!= null)
					{
						String name = (new String(tmp.getBytes(),"UTF-8"));
						if(!name.equals(listNames.getSelectedValue().toString()))
						{
							if(i==0)
							{
								allNames=name;
							}
							else
							{
								allNames=allNames+"\n"+name;
							}
							i++;
						}
					}
					reader.close();
					
					writer = new BufferedWriter(new FileWriter(fileNames,false));
					writer.write(allNames);
					writer.close();
					
					vectorNames.remove(listNames.getSelectedIndex());
					
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
				catch (IOException e2)
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		}
		else
		{
			System.out.println("Unknown error in ActionListener!");
			this.dispose();
//=======

			
//>>>>>>> dbf8097a6504f51cca3b0640eea5b7df1b29b56f
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		// TODO Auto-generated method stub
		if (!e.getValueIsAdjusting()) 
		{
			buttonRename.setEnabled(true);
			buttonDelete.setEnabled(true);
			buttonPlay.setEnabled(true);
	    }
	}
	
}
