import java.awt.BorderLayout;
import javax.swing.*;
/**
 * Main class of program.
 *
 * @author HP
 */
@SuppressWarnings("serial")
public class Game extends JFrame
{
	
	public Game(String p_name) {
        super("Sudoku");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        
        Generator game = new Generator();
        //game.print();  
        Board board = new Board();
        Controller sudokuController = new Controller(board, game);
        add(board, BorderLayout.CENTER);
        board.setGame(game);
        board.setController(sudokuController);
        
        NumberController buttonController = new NumberController(game);
        NumberButton numbers = new NumberButton(p_name);
        numbers.setController(buttonController);
        add(numbers, BorderLayout.EAST);
        //setJMenuBar(gamemenu); 
        game.addObserver(numbers);
        game.addObserver(board);
        game.print();
        
        pack(); 
        setLocationRelativeTo(null);
        setVisible(true);
    }
	
}	
