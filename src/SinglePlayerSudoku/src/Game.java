import java.awt.BorderLayout;
import javax.swing.*;
/**
 * Main class of program.
 *
 * @author HP
 */
public class Game extends JFrame {
	
	public Game() {
        super("Sudoku");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
                
        Board board = new Board();
       
        add(board, BorderLayout.EAST);
        Menu gamemenu=new Menu(); 
        setJMenuBar(gamemenu); 
        pack(); 
        setLocationRelativeTo(null);
        setVisible(true);
    }
	public static void main(String[] args) {
        new Game();
	}
}	
