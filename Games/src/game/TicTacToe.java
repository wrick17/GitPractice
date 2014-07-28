package game;

import java.util.Scanner;

public class TicTacToe implements Game {

	private int totalPlayers;
	private int totalRow;
	private int totalColumn;
	private int totalTurns = 0;
	private int currentRow;
	private int currentColumn;
	private int tempRow;
	private int tempColumn;
	private int turnPosition;
	private int winCondition;
	private Board b;
	private int count = 0;
	private boolean roll;
	private String symbol;
	private Scanner sc;

	public TicTacToe(Board b) {

		this.b = b;
	}

	public void startGame() {

		sc = new Scanner(System.in);
		System.out.print("\nEnter grid size: ");
		totalRow = sc.nextInt();
		totalColumn = totalRow;

		// System.out.println("Enter column length");
		// totalColumn = sc.nextInt();

		System.out.print("Enter the number players: ");
		totalPlayers = sc.nextInt();

		b.setBoard(totalRow, totalColumn);

		TicTacToePlayer player[] = new TicTacToePlayer[totalPlayers];
		int i = 0;

		while (i < totalPlayers) {
			player[i] = new TicTacToePlayer();
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

		while (totalTurns <= totalRow * totalColumn) {

			if (totalTurns < totalRow * totalColumn) {
				do {
					turnUpdater(player);
					roll = !b.insertOnBoard(currentRow, currentColumn, symbol);
					if (roll) {
						turnPosition--;
					}
				} while (roll);

				b.displayBoard();
				winning();
			} else {
				System.out.println("The match is draw");
			}
			totalTurns++;
		}
	}

	@Override
	public void winning() {

		String board[][] = b.getBoard();

		if (totalRow > 3) {
			winCondition = 5;
		} else {
			winCondition = 3;
		}

		symbol = board[currentRow][currentColumn];

		checkRow(board);
		checkColumn(board);
		checkLeftDiagonal(board);
		checkRightDiagonal(board);
	}

	public void checkRow(String board[][]) {
		count = 0;
		for (int i = 0; i < totalRow; i++) {

			if (symbol.equals(board[i][currentColumn])) {
				checkWin(++count);
			} else {
				count = 0;
			}
		}
	}

	private void checkColumn(String board[][]) {
		count = 0;
		for (int j = 0; j < totalColumn; j++) {

			if (symbol.equals(board[currentRow][j])) {
				checkWin(++count);
			} else {
				count = 0;
			}
		}
	}

	private void checkLeftDiagonal(String board[][]) {
		tempRow = currentRow;
		tempColumn = currentColumn;

		while (tempRow > 0 && tempColumn > 0) {
			tempRow--;
			tempColumn--;
		}

		count = 0;
		while (tempRow < totalRow && tempColumn < totalColumn) {
			if (symbol.equals(board[tempRow][tempColumn])) {
				checkWin(++count);
			} else {
				count = 0;
			}
			tempRow++;
			tempColumn++;
		}
	}

	private void checkRightDiagonal(String board[][]) {
		tempRow = currentRow;
		tempColumn = currentColumn;

		while (tempRow > 0 && tempColumn < totalColumn - 1) {
			tempRow--;
			tempColumn++;
		}
		count = 0;

		while (tempRow < totalRow && tempColumn >= 0) {
			if (symbol.equals(board[tempRow][tempColumn])) {
				checkWin(++count);
			} else {
				count = 0;
			}
			tempRow++;
			tempColumn--;
		}
	}

	private void checkWin(int count) {

		if (count == winCondition) {
			System.out.println(symbol + " wins");
			endGame();
		}
	}

	private void endGame() {
		System.exit(0);
	}

	@Override
	public void turnUpdater(Player player[]) {

		if (turnPosition > totalPlayers - 1) {
			turnPosition = 0;
		}

		System.out.println(player[turnPosition].getName() + "'s turn next");
		player[turnPosition].play();
		currentRow = player[turnPosition].getCurrentRowPosition() - 1;
		currentColumn = player[turnPosition].getCurrentColumnPosition() - 1;
		symbol = player[turnPosition].getSymbol();

		turnPosition++;
	}
}