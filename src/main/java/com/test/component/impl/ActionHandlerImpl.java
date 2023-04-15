package com.test.component.impl;

import com.test.component.ActionHandler;
import com.test.data.Cell;
import com.test.exception.GameOverException;
import com.test.exception.InvalidIndexException;

import java.util.Arrays;
import java.util.List;

public class ActionHandlerImpl implements ActionHandler {
    // Array that contains directions from the current element
    private static final List<int[]> NEIGHBORS_DIRECTIONS = Arrays.asList(
            new int[]{-1, 0}, // one row up
            new int[]{1, 0}, // one row down
            new int[]{0, -1}, // one column to the left
            new int[]{0, 1}, // one column to the right
            new int[]{-1, -1}, // diagonally up and to the left
            new int[]{-1, 1}, // diagonally up and to the right
            new int[]{1, -1}, // diagonally down and to the left
            new int[]{1, 1} // diagonally down and to the right
    );

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

    private void openAdjacentCells(int row, int col, Cell[][] cells) {
        // Check if the given row and column indices are valid
        if (!isValidIndex(row, col, cells)) {
            return;
        }
        if (cells[row][col].isBlackHole() || cells[row][col].isOpen()) {
            return;
        }
        // Set the current cell as open
        cells[row][col].setOpen(true);
        // Check if the current cell has a value of zero
        if (cells[row][col].getValue() == 0) {
            // If current cell is 0, go through the neighbor cells using directions from NEIGHBORS_ROUTES
            for (int[] neighbor : NEIGHBORS_DIRECTIONS) {
                // Calculate the row and column indices of the neighbor cell
                int r = row + neighbor[0];
                int c = col + neighbor[1];
                openAdjacentCells(r, c, cells);
            }
        }
    }

    private boolean isValidIndex(int row, int col, Cell[][] cells) {
        return row >= 0 && row < cells.length && col >= 0 && col < cells[row].length;
    }
}
