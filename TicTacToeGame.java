package com.bridgelabz.tictactoe;

public class TicTacToeGame {
	// Variables
	private static char[] board;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome To Tic-Tac-Toe Game");
		board = createBoard();
	}

	// Create Board and Assign Empty Spaces
	private static char[] createBoard() {
		char[] board = new char[10];
		for (int index = 1; index < board.length; index++)
			board[index] = ' ';
		return board;
	}
}
