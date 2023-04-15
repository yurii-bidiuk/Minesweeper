package com.test;


import com.test.component.ActionHandler;
import com.test.component.BoardGenerator;
import com.test.component.BoardPrinter;
import com.test.data.Board;
import com.test.exception.GameOverException;
import com.test.exception.InvalidIndexException;

public abstract class Game {
    private BoardGenerator boardGenerator;
    private ActionHandler actionHandler;
    public BoardPrinter boardPrinter;

    protected Game(BoardGenerator boardGenerator, ActionHandler actionHandler, BoardPrinter boardPrinter) {
        this.boardGenerator = boardGenerator;
        this.actionHandler = actionHandler;
        this.boardPrinter = boardPrinter;
    }

    private Board board;

    public void start() {
        int rows = getRowsCount();
        int columns = getColumnsCount();
        int blackHolesCount = getBlackHolesCount();
        initGame(rows, columns, blackHolesCount);

        try {
            while (true) {
                try {
                    input();
                    boardPrinter.printState(board);
                } catch (InvalidIndexException exception) {
                    printMessage(exception.getMessage());
                }
            }
        } catch (GameOverException e) {
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
