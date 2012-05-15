import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;


public class NumberButton extends JPanel implements Observer,ActionListener{
	ButtonGroup bgNumbers;
	JToggleButton[] btnNumbers;
	private Generator game;
	
	public NumberButton() {
        super(new BorderLayout());

        JPanel pnlNumbers = new JPanel();
        pnlNumbers.setLayout(new BoxLayout(pnlNumbers, BoxLayout.PAGE_AXIS));
        pnlNumbers.setBorder(BorderFactory.createTitledBorder(" Numbers "));
        add(pnlNumbers, BorderLayout.NORTH);
       
        JPanel pnlNumbersNumbers = new JPanel(new GridLayout(3, 3));
        pnlNumbers.add(pnlNumbersNumbers);

        bgNumbers = new ButtonGroup();
        btnNumbers = new JToggleButton[9];
        for (int i = 0; i < 9; i++) {
            btnNumbers[i] = new JToggleButton("" + (i + 1));
            btnNumbers[i].setPreferredSize(new Dimension(40, 40));
            btnNumbers[i].setFocusable(false);
            bgNumbers.add(btnNumbers[i]);
            pnlNumbersNumbers.add(btnNumbers[i]);
        }
    }

    /**
     * Method called when model sends update notification.
     *
     * @param o     The model.
     * @param arg   The UpdateAction.
     */
    public void update(Observable o, Object arg) {
       
    }

    /**
     * Adds controller to all components.
     *
     * @param buttonController  Controller which controls all user actions.
     */
    public void setController() {
        for (int i = 0; i < 9; i++)
            btnNumbers[i].addActionListener(null);
    }
    public void actionPerformed(ActionEvent e) {
            game.setSelectedNumber(Integer.parseInt(e.getActionCommand()));
    }
}

