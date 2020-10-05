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
		System.out.println("The Computer Letter is :"+computer);
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
}
