package com.test.component.impl;

import com.test.component.BoardGenerator;
import com.test.component.CellInitializer;
import com.test.data.Board;

public class BoardGeneratorImpl implements BoardGenerator {
    private final CellInitializer cellInitializer;

    public BoardGeneratorImpl(CellInitializer cellInitializer) {
        this.cellInitializer = cellInitializer;
    }

    @Override
    public Board generateBoard(int rows, int cols, int blackHolesCount) {
        Board board = new Board(rows, cols, blackHolesCount);
        int[][] blackHolesLocations = cellInitializer.initBlackHoles(rows, cols, board.getCells(), blackHolesCount);
        cellInitializer.initAdjacentCells(blackHolesLocations, board.getCells());
        return board;
    }
}
