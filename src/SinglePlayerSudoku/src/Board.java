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
            
            case SELECTED_NUMBER:
            case CANDIDATES:
                          
                break;
        }
    }
    
    public void setController(Controller sudokuController) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++)
                panels[y][x].addMouseListener(sudokuController);
        }
    }
	
} 