import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class SelectPlayer extends JFrame implements ActionListener
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
		
		buttonDelete = new JButton("Delete");
		buttonDelete.setBounds(240, 40, 90, 25);
		buttonDelete.addActionListener(this);
		
		buttonPlay = new JButton("Play");
		buttonPlay.setBounds(40, 300, 90, 25);
		buttonPlay.addActionListener(this);
		buttonPlay.disable();
		
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
			System.out.println("File doesn't exist!");
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
			AddPlayer add = new AddPlayer();
			add.show();
			//vectorNames.addElement("Player2");
		}
		else if(e.getActionCommand().equalsIgnoreCase("Back"))
		{
			this.dispose();
			Main m = new Main();
			m.show();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Play"))
		{
			
		}
	}
	
}
