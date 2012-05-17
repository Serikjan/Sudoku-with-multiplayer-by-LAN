import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

@SuppressWarnings("serial")
public class Board extends JPanel implements Observer {

    private Cell[][] cells;       // Array of cells.
    private JPanel[][] panels;      // Panels holding the cells.

    /**
     * Panel->subpanel->cell
     */
    public Board() {
        super(new GridLayout(3, 3));

        panels = new JPanel[3][3];
        for (int y = 0; y < 3; y++) {//three panels stores 9 cells each.
            for (int x = 0; x < 3; x++) {
                panels[y][x] = new JPanel(new GridLayout(3, 3));
                panels[y][x].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                add(panels[y][x]);
                
            }
        }

        cells = new Cell[9][9];
        for (int y = 0; y < 9; y++) {//Construct cells Y-axis
            for (int x = 0; x < 9; x++) {
                cells[y][x] = new Cell(x, y);
                panels[y / 3][x / 3].add(cells[y][x]);
            }
        }
        
    }
    
    public void update(Observable o, Object arg) {
        switch ((UpdateAction)arg) {
            case NEW_GAME:
                setGame((Generator)o);
                break;
            case CHECK:
                setGameCheck((Generator)o);
                break;
            case SELECTED_NUMBER:
            case CANDIDATES:
            
                break;
        }
    }
    
    public void setGame(Generator game) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                cells[y][x].setBackground(Color.WHITE);
                cells[y][x].setNumber(game.getNumber(x, y), false);
            }
        }
    }

    /**
     * Sets cells validity according to given game.
     *
     * @param game  Current game.
     */
    private void setGameCheck(Generator game) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                cells[y][x].setBackground(Color.WHITE);
                if (cells[y][x].getForeground().equals(Color.BLUE))
                    cells[y][x].setBackground(game.isCheckValid(x, y) ? Color.GREEN : Color.RED);
            }
        }
    }   

    
    public void setController(Controller sudokuController) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++)
                panels[y][x].addMouseListener(sudokuController);
        }
    }
	
} 