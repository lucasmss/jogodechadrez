package application;

import java.util.Scanner;

import boardgame.BoardException;
import chess.ChessPiece;
import chess.ChessPosition;

public class UI {
	
	
	public static ChessPosition readChessPosition(Scanner sc) {
		try {
		String s = sc.nextLine();
		char column = s.charAt(0);
		int row = Integer.parseInt(s.substring(1));
		return new ChessPosition(column, row);
			
		}
		catch (RuntimeException e) {
			throw new BoardException("Erro ao ler a posição, valores validos são de 1 até 8");
		}
	}
	
	public static void printBoard(ChessPiece[][] pieces){
		
		for(int i=0; i<pieces.length; i++) {
			System.out.print((8 - i) + " ");
			
			for (int j=0; j<pieces.length; j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		System.out.print("  a b c d e f g h");
	
	}
	
	private static void printPiece(ChessPiece piece){
		if (piece == null) {
			System.out.print("-");
		}
		else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}

}
