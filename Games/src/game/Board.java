package game;

public interface Board {

	public boolean insertOnBoard(int row, int column, String symbol);

	public void setBoard(int row, int column);

	public String[][] getBoard();
	
	public String[] getGrid();

	public void displayBoard();
	
	public void updateBoard(int value,String symbol);

	public boolean validMove(int row, int column);
}
