package com.test.data;

public class Board {

    private final Cell[][] cells;
    private final int blackHolesCount;
    private final int rows;
    private final int columns;
    private int[][] blackHolesLocation;
    private int openedCells;

    public Board(int rows, int columns, int blackHolesCount) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new Cell[rows][columns];
        this.blackHolesCount = blackHolesCount;

        for (int i = 0; i < rows; i++) {
            for (int y = 0; y < columns; y++) {
                cells[i][y] = new Cell();
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getBlackHolesCount() {
        return blackHolesCount;
    }


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getBlackHolesLocation() {
        return blackHolesLocation;
    }

    public void setBlackHolesLocation(int[][] blackHolesLocation) {
        this.blackHolesLocation = blackHolesLocation;
    }

    public int getOpenedCells() {
        return openedCells;
    }

    public void setOpenedCells(int openedCells) {
        this.openedCells = openedCells;
    }
}
