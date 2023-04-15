package com.test.component.impl;

import com.test.component.CellInitializer;
import com.test.data.Cell;

import java.util.*;

public class CellInitializerImpl implements CellInitializer {
    @Override
    public void initAdjacentCells(int[][] locations, Cell[][] cells) {
        // Loop through each location in the provided array of locations
        for (int[] location : locations) {
            // Retrieve the current row and column of the location
            int currentRow = location[0];
            int currentCol = location[1];

            // Use streams to filter out any cells that are black holes and increment the value of the adjacent cells
            Arrays.stream(cells, Math.max(0, currentRow - 1), Math.min(cells.length, currentRow + 2))
                    .flatMap(row -> Arrays.stream(row, Math.max(0, currentCol - 1), Math.min(row.length, currentCol + 2)))
                    .filter(cell -> !cell.isBlackHole())
                    .forEach(Cell::incrementValue);
        }
    }

    @Override
    public int[][] initBlackHoles(int maxRows, int maxColumns, Cell[][] cells, int blackHolesCount) {
        Random random = new Random();
        // Create a two-dimensional array to store the locations of the black holes
        int[][] blackHoleLocations = new int[blackHolesCount][];
        int createdHolesCount = 0;

        while (createdHolesCount < blackHolesCount) {
            // Generate random row and column indices within the limits of the game board
            int i = random.nextInt(maxRows - 1);
            int y = random.nextInt(maxColumns - 1);

            // Check if the cell at the current indices is already a black hole
            if (!cells[i][y].isBlackHole()) {
                cells[i][y].setBlackHole(true);
                // Store the location of the black hole in the array
                blackHoleLocations[createdHolesCount] = new int[]{i, y};
                createdHolesCount++;
            }
        }
        return blackHoleLocations;
    }
}
