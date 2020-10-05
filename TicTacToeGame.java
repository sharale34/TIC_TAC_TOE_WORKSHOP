package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	// Variables
	private static char computer;
	private static char[] board;
	private static char userLetter;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome To Tic-Tac-Toe Game");
		board = createBoard();
		userLetter = chooseUserLetter();

		// Assigning Letter to Computer
		if (userLetter == 'X')
			computer = 'O';
		else
			computer = 'X';
		System.out.println("The Computer Letter is :" + computer);
		showBoard(board);
	}

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
}
