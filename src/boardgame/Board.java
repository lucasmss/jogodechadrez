package boardgame;

public class Board {
	
	private int row;
	private int column;
	private Piece [][] pieces;
	
	public Board(int row, int column) {
		if(row < 1 || column < 1) {
			throw new BoardException("Erro criando taboleiro � necess�rio que haja pelo menos uma linha e uma coluna");
		}
		this.row = row;
		this.column = column;
		pieces = new Piece[row][column];
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	
	public Piece piece(int rows, int columns) {
		if(!positionExists(rows , columns)) {
			throw new BoardException("Posi��o n�o encontrada");
		}
		
		return pieces[rows][columns];
	}
	
	public Piece piece(Position position){
		if(!positionExists(position)) {
			throw new BoardException("Posi��o n�o encontrada");
		}
		return pieces[position.getRow()][position.getColumn()];
		
	}
	
	public void placePiece(Piece piece, Position position){
		if (thereIsAPiece(position)) {
			throw new BoardException("J� tem uma pe�a nessa posi��o ");
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int rows, int columns) {
		return rows >= 0 && rows < row && column >= 0 && columns < column;
	}
	
	public boolean positionExists(Position position) {
		
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posi��o n�o encontrada");
		}
		return piece(position) != null;
	}
	

}
