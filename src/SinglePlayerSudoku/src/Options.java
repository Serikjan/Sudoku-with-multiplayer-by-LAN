import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Options extends JFrame implements ActionListener
{
	private JLabel labelTime;
	private JLabel labelMin;
	private JLabel labelSec;
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
	@SuppressWarnings("rawtypes")
	private JComboBox comboSolveN;
	@SuppressWarnings("rawtypes")
	private JComboBox comboPauseN;
	private JTextField textMin;
	private JTextField textSec;
	private JButton buttonOk;
	private JButton buttonCancel;
	private ConfigFile config;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	Options()
	{
		this.setLayout(null);
		this.setBounds(500, 200, 320, 250);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Options");
		
		
		
		radioEasy = new JRadioButton("Easy");
		radioEasy.setName("Easy");
		radioEasy.addActionListener(this);
		radioMedium = new JRadioButton("Medium");
		radioMedium.setName("Medium");
		radioMedium.addActionListener(this);
		radioHard = new JRadioButton("Hard");
		radioHard.setName("Hard");
		radioHard.addActionListener(this);
		switch(config.getDifficult())
		{
			case 1:
				radioEasy.setSelected(true);
				break;
			case 2:
				radioMedium.setSelected(true);
				break;
			case 3:
				radioHard.setSelected(true);
				break;
			default:
				System.out.println("Error in level...!");
				break;
		}
		
		groupDiff = new ButtonGroup();
		groupDiff.add(radioEasy);
		groupDiff.add(radioMedium);
		groupDiff.add(radioHard);
		
		panelDiff = new JPanel();
		panelDiff.setLayout(new GridLayout(3, 1));
		panelDiff.add(radioEasy);
		panelDiff.add(radioMedium);
		panelDiff.add(radioHard);
		panelDiff.setBounds(15, 10, 100, 100);
		panelDiff.setBorder(BorderFactory.createTitledBorder("Difficulty:"));
		
		checkNode = new JCheckBox("Use node checker");
		checkNode.setName("NodeChecker");
		checkNode.setSelected(true);
		checkNode.setBounds(160, 10, 200, 25);
		checkNode.addActionListener(this);
		if(config.getUseNode())
			checkNode.setSelected(true);
		else
			checkNode.setSelected(false);
		
		checkPoint = new JCheckBox("Show points");
		checkPoint.setName("ShowPoint");
		checkPoint.setSelected(true);
		checkPoint.setBounds(160, 45, 150, 25);
		checkPoint.addActionListener(this);
		if(config.getShowPoint())
			checkPoint.setSelected(true);
		else
			checkPoint.setSelected(false);
		
		checkSolver = new JCheckBox("Use solve");
		checkSolver.setName("UseSolver");
		checkSolver.setSelected(true);
		checkSolver.setBounds(160, 80, 100, 25);
		checkSolver.addActionListener(this);
		
		comboSolveN = new JComboBox();
		for(int i=1; i<10; i++)
		{
			comboSolveN.addItem(i);
		}
		comboSolveN.setSelectedItem(3);
		comboSolveN.setBounds(260, 80, 40, 25);
		comboSolveN.addActionListener(this);
		
		checkPause = new JCheckBox("Use pause");
		checkPause.setName("UsePause");
		checkPause.setSelected(true);
		checkPause.setBounds(160, 115, 100, 25);
		checkPause.addActionListener(this);
		
		comboPauseN = new JComboBox();
		for(int i=1; i<10; i++)
		{
			comboPauseN.addItem(i);
		}
		comboPauseN.setSelectedItem(3);
		comboPauseN.setBounds(260, 115, 40, 25);
		comboPauseN.addActionListener(this);
		
		checkTime = new JCheckBox("Time default (10 min)");
		checkTime.setName("Set Time");
		checkTime.setSelected(true);
		checkTime.setBounds(10, 115, 150, 25);
		checkTime.addActionListener(this);
		
		labelTime = new JLabel("Time: ");
		labelTime.setBounds(15, 150, 40, 25);
		
		textMin = new JTextField("10");
		textMin.setBounds(60, 150, 30, 25);
		textMin.setEnabled(false);
		
		labelMin = new JLabel("min ");
		labelMin.setBounds(90, 150, 30, 25);

		textSec = new JTextField("0");
		textSec.setBounds(120, 150, 30, 25);
		textSec.setEnabled(false);

		labelSec = new JLabel("sec");
		labelSec.setBounds(150, 150, 30, 25);

		buttonOk = new JButton("OK");
		buttonOk.setBounds(80, 185, 80, 25);
		buttonOk.addActionListener(this);

		buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(180, 185, 80, 25);
		buttonCancel.addActionListener(this);
		
		this.add(panelDiff);
		this.add(checkNode);
		this.add(comboSolveN);
		this.add(checkPoint);
		this.add(comboPauseN);
		this.add(checkSolver);
		this.add(checkPause);
		this.add(checkTime);
		this.add(labelTime);
		this.add(textMin);
		this.add(labelMin);
		this.add(textSec);
		this.add(labelSec);
		this.add(buttonOk);
		this.add(buttonCancel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}