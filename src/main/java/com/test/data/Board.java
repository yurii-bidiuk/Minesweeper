package com.test.data;

public class Board {
    private final Cell[][] cells;
    private final int blackHolesCount;
    private int[][] blackHolesLocation;

    public Board(int rows, int columns, int blackHolesCount) {
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

    public int[][] getBlackHolesLocation() {
        return blackHolesLocation;
    }

    public void setBlackHolesLocation(int[][] blackHolesLocation) {
        this.blackHolesLocation = blackHolesLocation;
    }
}
