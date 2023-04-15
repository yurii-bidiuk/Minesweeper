package com.test.component;


import com.test.data.Cell;
import com.test.exception.GameOverException;
import com.test.exception.InvalidIndexException;

public interface ActionHandler {
    void handleCellClick(int row, int col, Cell[][] cells) throws GameOverException, InvalidIndexException;
}
