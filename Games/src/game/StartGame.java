package game;

import java.util.Scanner;

public class StartGame {

	public static void main(String args[]) {

		Board t3board = new TicTacToeBoard();
		Board slboard = new SnakeLadderBoard();

		Scanner sc = new Scanner(System.in);

		TicTacToe t3game = new TicTacToe(t3board);
		SnakeLadder slgame = new SnakeLadder(slboard);

		System.out.println("1. Snake Ladder");
		System.out.println("2. Tic Tac Toe");

		System.out.print("\nEnter which you want to play: ");
		
		do {
			int choice = sc.nextInt();

			if (choice == 1) {
				slgame.startGame();
				break;
			} else if (choice == 2) {
				t3game.startGame();
				break;
			} else
				System.out.print("\nWrong Choice! Enter again: ");
		} while (true);
	}
}
