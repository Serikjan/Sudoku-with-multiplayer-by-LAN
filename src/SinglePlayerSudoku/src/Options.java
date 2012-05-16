import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class Options extends JFrame implements ActionListener
{
	private JLabel labelDifficult;
	private JLabel labelTime;
	private ButtonGroup groupDifficulty;
	private JRadioButton radioEasy;
	private JRadioButton radioMedium;
	private JRadioButton radioHard;
	private JCheckBox checkNode;
	private JCheckBox checkPoint;
	private JCheckBox checkSolver;
	private JCheckBox checkPause;
	private JCheckBox checkTime;
	private JButton buttonOk;
	private JButton buttonCancel;
	
	Options()
	{
		this.setLayout(null);
		this.setBounds(500,200,400,400);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Options");
		
		labelDifficult = new JLabel("Difficulty:");
		labelDifficult.setBounds(10,10,100,25);
		
		groupDifficulty = new ButtonGroup();
		//groupDifficulty
		
		this.add(labelDifficult);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
