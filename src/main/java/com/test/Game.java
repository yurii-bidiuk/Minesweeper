package com.test;


import com.test.component.ActionHandler;
import com.test.component.BoardGenerator;
import com.test.component.BoardPrinter;
import com.test.data.Board;
import com.test.exception.GameOverException;
import com.test.exception.InvalidIndexException;

public abstract class Game {
    private final BoardGenerator boardGenerator;
    private final ActionHandler actionHandler;
    private final BoardPrinter boardPrinter;
    private Board board;

    protected Game(BoardGenerator boardGenerator, ActionHandler actionHandler, BoardPrinter boardPrinter) {
        this.boardGenerator = boardGenerator;
        this.actionHandler = actionHandler;
        this.boardPrinter = boardPrinter;
    }

    public void start() {
        // Get the number of rows, columns, and black holes count from user input
        int rows = getRowsCount();
        int columns = getColumnsCount();
        int blackHolesCount = getBlackHolesCount();

        // Initialize the game with the given parameters
        initGame(rows, columns, blackHolesCount);

        try {
            while (true) {
                try {
                    // Receive input from the user
                    input();
                    // Print the current state of the game board after each change
                    boardPrinter.printState(board);
                } catch (InvalidIndexException exception) {
                    // If the user's input is invalid, print an error message
                    printMessage(exception.getMessage());
                }
            }
            // If the game is over, catch the GameOverException
        } catch (GameOverException e) {
            // Print the game over message
            boardPrinter.printGameOver(board);
        }
    }

    private void initGame(int rows, int columns, int blackHolesCount) {
        this.board = boardGenerator.generateBoard(rows, columns, blackHolesCount);
        boardPrinter.printState(board);
    }

    private void input() throws GameOverException, InvalidIndexException {
        int clickedRowIndex = getRowIndex();
        int clickedColumnIndex = getColumnIndex();
        actionHandler.handleCellClick(clickedRowIndex, clickedColumnIndex, board.getCells());
    }

    protected abstract int getRowsCount();
    protected abstract int getColumnsCount();
    protected abstract int getBlackHolesCount();

    protected abstract int getRowIndex();
    protected abstract int getColumnIndex();
    protected abstract void printMessage(String message);

}
