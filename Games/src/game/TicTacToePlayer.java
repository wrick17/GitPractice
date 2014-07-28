package game;

import java.util.Scanner;

public class TicTacToePlayer implements Player {

	Scanner sc;
	private int row;
	private int column;
	private String name;
	private String symbol;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String playerSymbol) {
		symbol = playerSymbol;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String playerName) {
		name = playerName;
	}

	@Override
	public void play() {
		sc = new Scanner(System.in);
		System.out.print("\nEnter the row position: ");
		row = sc.nextInt();
		System.out.print("Enter the column position: ");
		column = sc.nextInt();
	}

	public int getCurrentRowPosition() {
		return row;
	}

	public int getCurrentColumnPosition() {
		return column;
	}

	@Override
	public int getCurrentValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
