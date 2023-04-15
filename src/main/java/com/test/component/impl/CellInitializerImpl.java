package com.test.component.impl;

import com.test.component.CellInitializer;
import com.test.data.Cell;

import java.util.Arrays;
import java.util.Random;

public class CellInitializerImpl implements CellInitializer {
    @Override
    public void initAdjacentCells(int[][] locations, Cell[][] cells) {
        for (int[] location : locations) {
            int currentRow = location[0];
            int currentCol = location[1];
            Arrays.stream(cells, Math.max(0, currentRow - 1), Math.min(cells.length, currentRow + 2))
                    .flatMap(row -> Arrays.stream(row, Math.max(0, currentCol - 1), Math.min(row.length, currentCol + 2)))
                    .filter(cell -> !cell.isBlackHole())
                    .forEach(Cell::incrementValue);
        }
    }

    @Override
    public int[][] initBlackHoles(int maxRows, int maxColumns, Cell[][] cells, int blackHolesCount) {
        Random random = new Random();
        int[][] blackHoleLocations = new int[blackHolesCount][];
        int createdHolesCount = 0;
        while (createdHolesCount < blackHolesCount) {
            int i = random.nextInt(maxRows - 1);
            int y = random.nextInt(maxColumns - 1);
            if (!cells[i][y].isBlackHole()) {
                cells[i][y].setBlackHole(true);
                blackHoleLocations[createdHolesCount] = new int[]{i, y};
                createdHolesCount++;
            }
        }
        return blackHoleLocations;
    }
}
