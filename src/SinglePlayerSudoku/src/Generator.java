import java.util.Observable;


public class Generator extends Observable {
	private int selectedNumber;
	private int[][] game; 
	
	public void setSelectedNumber(int selectedNumber) {
        this.selectedNumber = selectedNumber;
        setChanged();
        notifyObservers(UpdateAction.SELECTED_NUMBER);
    }
	
	public void setNumber(int x, int y, int number) {
	        game[y][x] = number;
	}
	
	public int getSelectedNumber() {
        return selectedNumber;
    }
	
	public int getNumber(int x, int y) {
        return game[y][x];
    }
}
 