package game;

public class SnakeLadderPlayer implements Player{


	private String name;
	private String symbol;
	private int value;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String playerName) {
		name = playerName;
		
	}

	@Override
	public String getSymbol() {
		return symbol;
	}

	@Override
	public void setSymbol(String playerSymbol) {
		symbol = playerSymbol;		
	}

	@Override
	public int getCurrentRowPosition() {
		return 0;
	}

	@Override
	public int getCurrentColumnPosition() {
		return 0;
	}

	@Override
	public void play() {
		rollDice();
	}
	
	private void rollDice() {
		 value = (int) (Math.floor(Math.random() * 6)) + 1;
		 System.out.println("Your dice value is : "+value);
	}

	@Override
	public int getCurrentValue() {
		return value;
	}

}
