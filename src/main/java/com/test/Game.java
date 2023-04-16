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
            while (!isAllCellsOpened()) {
                playTurn();
            }
        } catch (GameOverException e) {
            handleGameOver();
        }
    }

    private void initGame(int rows, int columns, int blackHolesCount) {
        this.board = boardGenerator.generateBoard(rows, columns, blackHolesCount);
        boardPrinter.printState(board);
    }

    private void playTurn() throws GameOverException {
        try {
            handleUserInput();
            if (isAllCellsOpened()) {
                handleGameOver();
            } else {
                boardPrinter.printState(board);
            }
        } catch (InvalidIndexException exception) {
            displayMessage(exception.getMessage());
        }
    }

    private void handleUserInput() throws GameOverException, InvalidIndexException {
        int clickedRowIndex = getRowIndex();
        int clickedColumnIndex = getColumnIndex();
        actionHandler.handleCellClick(clickedRowIndex, clickedColumnIndex, board);
    }

    private boolean isAllCellsOpened() {
        int totalCellsCount = (board.getRows() * board.getColumns()) - board.getBlackHolesCount();
        return totalCellsCount == board.getOpenedCells();
    }

    private void handleGameOver() {
        boardPrinter.printGameOver(board);
        if (isAllCellsOpened()) {
            displayMessage("You won!");
        }
    }

    protected abstract int getRowsCount();

    protected abstract int getColumnsCount();

    protected abstract int getBlackHolesCount();

    protected abstract int getRowIndex();

    protected abstract int getColumnIndex();

    protected abstract void displayMessage(String message);

}
