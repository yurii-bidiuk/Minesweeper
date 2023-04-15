package com.test.component.impl;

import com.test.component.ActionHandler;
import com.test.data.Cell;
import com.test.exception.GameOverException;
import com.test.exception.InvalidIndexException;

import java.util.Arrays;
import java.util.List;

public class ActionHandlerImpl implements ActionHandler {
    private static final List<int[]> NEIGHBORS_ROUTES = Arrays.asList(
            new int[]{-1, 0}, // one row up
            new int[]{1, 0}, // one row down
            new int[]{0, -1}, // one column to the left
            new int[]{0, 1}, // one column to the right
            new int[]{-1, -1}, // diagonally up and to the left
            new int[]{-1, 1}, // diagonally up and to the right
            new int[]{1, -1}, // diagonally down and to the left
            new int[]{1, 1} // diagonally down and to the right
    );

    public static void openAdjacentCells(int row, int col, Cell[][] cells) {
        if (!isValidIndex(row, col, cells)) {
            return;
        }
        if (cells[row][col].isBlackHole() || cells[row][col].isOpen()) {
            return;
        }
        cells[row][col].setOpen(true);
        if (cells[row][col].getValue() == 0) {
            for (int[] neighbor : NEIGHBORS_ROUTES) {
                int r = row + neighbor[0];
                int c = col + neighbor[1];
                openAdjacentCells(r, c, cells);
            }
        }
    }

    public static boolean isValidIndex(int row, int col, Cell[][] cells) {
        return row >= 0 && row < cells.length && col >= 0 && col < cells[row].length;
    }

    @Override
    public void handleCellClick(int row, int col, Cell[][] cells) throws GameOverException, InvalidIndexException {
        if (!isValidIndex(row, col, cells)) {
            throw new InvalidIndexException();
        }
        if (cells[row][col].isBlackHole()) {
            throw new GameOverException();
        }

        if (cells[row][col].getValue() > 0) {
            cells[row][col].setOpen(true);
            return;
        }
        openAdjacentCells(row, col, cells);
    }
}
