package game;

import java.util.Arrays;

public class TicTacToeBoard implements Board {

	private String board[][];
	private int column;

	public void setBoard(int row, int column) {

		String tempBoard[][] = new String[row][column];
		board = tempBoard;
		this.column = column;

		for (String ch[] : board) {
			Arrays.fill(ch, " ");
		}
	}

	public String[][] getBoard() {
		return board;
	}

	public void displayBoard() {

		StringBuilder divider = new StringBuilder();

		System.out.println("Board: \n");

		if (column == 3) {
			for (int i = 1; i < column; i++) {
				divider.append("----");
			}
		}

		else {
			for (int i = 1; i < column; i++) {
				divider.append("----");
			}
		}

		divider.append("--");

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (j < board[i].length - 1) {
					System.out.print(board[i][j] + " | ");
				} else {
					System.out.print(board[i][j]);
				}
			}
			System.out.println();

			if (i < board.length - 1) {
				System.out.println(divider);
			} else {
				System.out.println();
			}
		}
	}

	@Override
	public boolean validMove(int row, int column) {

		if (board[row][column].equals(" ")) {
			return true;
		}

		else {
			return false;
		}
	}

	@Override
	public boolean insertOnBoard(int row, int column, String symbol) {

		if (validMove(row, column)) {
			board[row][column] = symbol;
			return true;
		} else {
			System.out.println("Position occupied");
			return false;
		}
	}

	@Override
	public String[] getGrid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBoard(int value, String symbol) {
		// TODO Auto-generated method stub
		
	}
}
