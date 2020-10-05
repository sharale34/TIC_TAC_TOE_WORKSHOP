package com.bridgelabz.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
	private final static int TAIL = 0;
	private final static int HEAD = 1;

	// Variables
	private static char computer;
	private static char[] board;
	private static char userLetter;

	// Create Board and Assign Empty Spaces
	private static char[] createBoard() {
		char[] board = new char[10];
		for (int index = 1; index < board.length; index++)
			board[index] = ' ';
		return board;
	}

	// Selection of Letter by User
	private static char chooseUserLetter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose Your User Letter X or O");
		char userLetter = sc.next().toUpperCase().charAt(0);
		return userLetter;
	}

	// Display the Board
	private static void showBoard(char[] board) {
		System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
	}

	// Selection of location by Player
	private static int getUserMove(char[] board) {
		Scanner sc = new Scanner(System.in);
		boolean available = false;
		int position = 0;
		Integer[] validCells = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		do {
			System.out.println("Choose a Desired Location on Board from 1 to 9 :");
			position = sc.nextInt();
			if (isSpaceFree(board, position) && Arrays.asList(validCells).contains(position))
				available = true;
			else
				System.out.println("Invalid position. Choose another empty position");
		} while (available == false);
		return position;

	}

	public static boolean isSpaceFree(char[] board, int position) {
		return board[position] == ' ';
	}

	// Make Move on Board
	private static void makeMove(char[] board, char Choice) {
		if (Choice == userLetter) {
			int position = getUserMove(board);
			board[position] = Choice;
		} else {
			int position = computerPlaysLikeUser(board, Choice);
			board[position] = Choice;
		}
		showBoard(board);
	}

	// Toss of Head & Tail. Head - User, Tail - Computer
	private static int tossToWhoPlayFirst() {
		int gameToss = (int) (Math.floor(Math.random() * 10) % 2);
		return gameToss;
	}

	// Choose The First Player
	private static void getWhoPlaysFirst(int gameToss) {
		if (gameToss == HEAD) {
			System.out.println("User Plays First");
			isWinner(gameToss);
		}
		if (gameToss == TAIL) {
			System.out.println("Computer Plays First");
			isWinner(gameToss);
		}
	}

	// Check who is Winner or game is Tie
	private static void isWinner(int gameToss) {

		if (gameToss == HEAD) {
			makeMove(board, userLetter);
		} else if (gameToss == TAIL) {
			makeMove(board, computer);
		}

		if ((board[1] == board[2] && board[2] == board[3] && board[1] != ' ')
				|| (board[4] == board[5] && board[5] == board[6] && board[6] != ' ')
				|| (board[7] == board[8] && board[8] == board[9] && board[9] != ' ')
				|| (board[1] == board[4] && board[4] == board[7] && board[7] != ' ')
				|| (board[2] == board[5] && board[5] == board[8] && board[8] != ' ')
				|| (board[3] == board[6] && board[6] == board[9] && board[9] != ' ')
				|| (board[1] == board[5] && board[5] == board[9] && board[9] != ' ')
				|| (board[3] == board[5] && board[5] == board[7] && board[7] != ' ')) {
			if (gameToss == HEAD)
				System.out.println("Player Won The Game.");
			if (gameToss == TAIL)
				System.out.println("Computer Won The Game.");
			System.exit(0);
		} else {
			if (board[1] != ' ' && board[2] != ' ' && board[3] != ' ' && board[4] != ' ' && board[5] != ' '
					&& board[6] != ' ' && board[7] != ' ' && board[8] != ' ' && board[9] != ' ') {
				System.out.println("Game is Tie");
				System.exit(0);
			} else {
				if (gameToss == HEAD) {
					gameToss--;
					isWinner(gameToss);
				} else if (gameToss == TAIL) {
					gameToss++;
					isWinner(gameToss);
				}
			}
		}
		showBoard(board);
	}

	// Computer plays like me to win
	public static int computerPlaysLikeUser(char[] board, char choice) {
		int position = 0;
		while (position == 0) {
			int i = (int) (Math.floor((Math.random() * 10) % 9) + 1);
			if (isSpaceFree(board, i))
				position = i;
		}
		if (choice == computer) {
			if (((board[1] == board[2] && board[1] == computer) || (board[5] == board[7] && board[5] == computer)
					|| (board[6] == board[9] && board[6] == computer)) && board[3] == ' ') {
				position = 3;
			} else if (((board[4] == board[5] && board[4] == computer)
					|| (board[3] == board[9] && board[3] == computer)) && board[6] == ' ') {
				position = 6;
			} else if (((board[5] == board[1] && board[1] == computer) || (board[8] == board[7] && board[7] == computer)
					|| (board[6] == board[3] && board[6] == computer)) && board[9] == ' ') {
				position = 9;
			} else if (((board[3] == board[2] && board[3] == computer) || (board[4] == board[7] && board[4] == computer)
					|| (board[5] == board[9] && board[5] == computer)) && board[1] == ' ') {
				position = 1;
			} else if (((board[1] == board[7] && board[1] == computer)
					|| (board[5] == board[6] && board[5] == computer)) && board[4] == ' ') {
				position = 4;
			} else if (((board[1] == board[4] && board[1] == computer) || (board[5] == board[3] && board[5] == computer)
					|| (board[8] == board[9] && board[8] == computer)) && board[7] == ' ') {
				position = 7;
			} else if (((board[1] == board[3] && board[1] == computer)
					|| (board[5] == board[8] && board[5] == computer)) && board[2] == ' ') {
				position = 2;
			} else if (((board[5] == board[2] && board[5] == computer)
					|| (board[7] == board[9] && board[7] == computer)) && board[8] == ' ') {
				position = 8;
			} else if (((board[1] == board[9] && board[1] == computer) || (board[3] == board[7] && board[3] == computer)
					|| (board[6] == board[4] && board[6] == computer)) && board[5] == ' ') {
				position = 5;
			}
		}
		return position;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe Game");
		board = createBoard();
		userLetter = chooseUserLetter();

		// Assigning Letter to Computer
		if (userLetter == 'X')
			computer = 'O';
		else
			computer = 'X';
		System.out.println("The Computer Letter is :" + computer);
		int toss = tossToWhoPlayFirst();
		getWhoPlaysFirst(toss);
	}

}
