package game;

import java.util.Scanner;

public class SnakeLadder implements Game {

	private int totalPlayers;
	private int totalRow = 10;
	private int totalColumn = 10;
	private int totalGrid;
	private int currentValue;
	private int turnPosition;
	private int winCondition;
	private Board b;
	private int count = 0;
	private String symbol;
	private Scanner sc;
	
	public SnakeLadder(Board slboard) {
		// TODO Auto-generated constructor stub
		this.b = slboard;
	}

	public void startGame() {
		
		sc = new Scanner(System.in);
		
		System.out.print("Enter the number players: ");
		totalPlayers = sc.nextInt();
		
		b.setBoard(totalRow, totalColumn);
		totalGrid = totalRow * totalColumn;
		SnakeLadderPlayer player[] = new SnakeLadderPlayer[totalPlayers];

		int i = 0;

		while (i < totalPlayers) {
			player[i] = new SnakeLadderPlayer();
			System.out.print("Enter name of Player " + (i + 1) + ": ");
			player[i].setName(sc.next());
			System.out.print("Enter symbol of Player " + (i + 1) + ": ");
			player[i].setSymbol(sc.next());
			i++;
		}
		System.out.print("Enter the symbol who wants to start first: ");
		symbol = sc.next();

		for (i = 0; i < totalPlayers; i++) {
			if (symbol.equals(player[i].getSymbol())) {
				turnPosition = i;
				break;
			}
		}
		
		b.displayBoard();
		
		while(true){
			
			do{
				turnUpdater(player);
				b.updateBoard(currentValue, symbol);
				b.displayBoard();
				winning();
				if(currentValue==6){turnPosition--;}
			}while(currentValue==6);
		}
	}
	@Override
	public void winning() {
		
		String grid[] = b.getGrid();		
		
		for(int i=0;i<totalGrid;i++){
			if(grid[i].contains(symbol) && i>=totalGrid-1){
				System.out.println(symbol+" is a winner");
				endGame();
			}
		}
	}

	@Override
	public void turnUpdater(Player[] player) {
		
		if (turnPosition > totalPlayers - 1) {
			turnPosition = 0;
		}
		System.out.print(player[turnPosition].getName()
				+ ", Press any key to roll the dice");
		System.out.println();
		sc.next();
		symbol = player[turnPosition].getSymbol();
		player[turnPosition].play();
		currentValue = player[turnPosition].getCurrentValue();
		turnPosition++;
	}
	
	private void endGame() {
		System.exit(0);
	}

}
