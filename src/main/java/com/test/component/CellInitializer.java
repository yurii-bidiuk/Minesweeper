package com.test.component;


import com.test.data.Cell;

public interface CellInitializer {
    void initAdjacentCells(int[][] locations, Cell[][] cells);

    int[][] initBlackHoles(int maxRows, int maxColumns, Cell[][] cells, int blackHolesCount);
}
