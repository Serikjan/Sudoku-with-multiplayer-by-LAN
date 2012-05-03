

import javax.swing.JMenu;
import javax.swing.JMenuBar;



public class Menu
{
	public Menu()
	{
		JMenuBar gamemenu = new JMenuBar();
	    JMenu gamem = new JMenu("Game");
	    JMenu helpm = new JMenu("Help"); 
	    gamemenu.add(gamem);
	    gamemenu.add(helpm);
	}
}
