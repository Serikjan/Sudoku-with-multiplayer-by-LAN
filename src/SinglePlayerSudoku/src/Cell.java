

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * This class represents a cell on the Board. (square)
 *
 * @author HP
 */
@SuppressWarnings("serial")
public class Cell extends JLabel {
    private int x;      // X position in game.
    private int y;      // Y position in game.

    /**
     * X and Y will be used in the game array
     *
     * @param x     X position in game.
     * @param y     Y position in game.
     */
    public Cell(int x, int y) {
        super("", CENTER);
        this.x = x;
        this.y = y;
        
        setPreferredSize(new Dimension(40, 40));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        setOpaque(true);
    }

    /**
     * Color : Black then from system Color : Blue then user input
     *
     * @param number        Number to be set.
     * @param userInput     User input or not
     */
    public void setNumber(int number, boolean userInput) {
        setForeground(userInput ? Color.BLUE : Color.BLACK);
        
        setText(number > 0 ? number + "" : "");
    }

    /**
     * @return  X position in game.
     */
    public int getCellX() {
        return x;
    }

    /**
     * @return  Y position in game.
     */
    public int getCellY() {
        return y;
    }
}