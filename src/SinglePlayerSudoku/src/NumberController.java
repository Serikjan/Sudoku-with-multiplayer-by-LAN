

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;


/**
 * This class controls all user actions from NumberButton.
 *
 * @author HP
 */
public class NumberController implements ActionListener {
    private Generator game;

    /**
     * Constructor, sets game.
     *
     * @param game  Game to be set.
     */
    public NumberController(Generator game) {
        this.game = game;
    }

    /**
     * Performs action after user pressed button.
     *
     * @param e ActionEvent.
     */
    public void actionPerformed(ActionEvent e) {
           game.setSelectedNumber(Integer.parseInt(e.getActionCommand()));
    }
}