import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class Options extends JFrame implements ActionListener
{
	private JLabel labelTime;
	private ButtonGroup groupDiff;
	private JRadioButton radioEasy;
	private JRadioButton radioMedium;
	private JRadioButton radioHard;
	private JPanel panelDiff;
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
		this.setBounds(500, 200, 400, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Options");
		
		radioEasy = new JRadioButton("Easy",true);
		radioEasy.setName("Easy");
		radioEasy.addActionListener(this);
		radioMedium = new JRadioButton("Medium");
		radioMedium.setName("Medium");
		radioMedium.addActionListener(this);
		radioHard = new JRadioButton("Hard");
		radioHard.setName("Hard");
		radioHard.addActionListener(this);
		
		groupDiff = new ButtonGroup();
		groupDiff.add(radioEasy);
		groupDiff.add(radioMedium);
		groupDiff.add(radioHard);
		
		panelDiff = new JPanel();
		panelDiff.setLayout(new GridLayout(3, 1));
		panelDiff.add(radioEasy);
		panelDiff.add(radioMedium);
		panelDiff.add(radioHard);
		panelDiff.setBounds(10, 10, 100, 100);
		panelDiff.setBorder(BorderFactory.createTitledBorder("Difficulty:"));
		
		
		checkNode = new JCheckBox("Use node checker");
		checkNode.setName("NodeChecker");
		checkNode.setBounds(140, 10, 200, 25);
		checkNode.addActionListener(this);
		//checkNode.setBorder(BorderFactory.createLineBorder(Color.black));
		checkPoint = new JCheckBox("Show points");
		checkPoint.setName("ShowPoint");
		checkPoint.setBounds(140, 45, 150, 25);
		checkPoint.addActionListener(this);
		checkSolver = new JCheckBox("Use solve");
		checkSolver.setName("UseSolver");
		checkSolver.setBounds(140, 70, 150, 25);
		checkSolver.addActionListener(this);
		checkPause = new JCheckBox("Use pause");
		checkPause.setName("UsePause");
		checkPause.setBounds(140, 105, 150, 25);
		checkPause.addActionListener(this);
		
		checkTime = new JCheckBox("Time default (10 min)");
		checkTime.setName("Set Time");
		checkTime.setBounds(10, 110, 100, 25);
		checkTime.addActionListener(this);
		
		this.add(panelDiff);
		this.add(checkNode);
		this.add(checkPoint);
		this.add(checkSolver);
		this.add(checkPause);
		this.add(checkTime);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
