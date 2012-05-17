import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 * This class controls all user actions from Board.
 *
 * @author HP
 */
public class Controller implements MouseListener {
    private Board board;    // Panel to control.
    private Generator game;                  // Current Sudoku game.

    /**
     * Constructor, sets game.
     *
     * @param game  Game to be set.
     */
    public Controller(Board board, Generator game) {
        this.board = board;
        this.game = game;
    }

    /**
     * Sets number into the panel
     * @param e MouseEvent.
     */
    public void mousePressed(MouseEvent e) {
        JPanel panel = (JPanel)e.getSource();
        Component component = panel.getComponentAt(e.getPoint());
        if (component instanceof Cell) {
           Cell cell = (Cell)component;
            int x = cell.getCellX();
            int y = cell.getCellY();

            if (e.getButton() == MouseEvent.BUTTON1 && (game.getNumber(x, y) == 0 || cell.getForeground().equals(Color.BLUE))) {
                int number = game.getSelectedNumber();
                if (number == -1)
                    return;
                game.setNumber(x, y, number);
                cell.setNumber(number, true);
            }
            else if (e.getButton() == MouseEvent.BUTTON3 && !cell.getForeground().equals(Color.BLACK)) {
                game.setNumber(x, y, 0);
                cell.setNumber(0, false);
            }

        }
    }

    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
}