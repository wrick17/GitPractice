package game;

public interface Player {

	public String getName();

	public void setName(String playerName);

	public String getSymbol();

	public void setSymbol(String playerSymbol);

	public int getCurrentRowPosition();

	public int getCurrentColumnPosition();
	
	public int getCurrentValue();

	public void play();
}
