package com.test.component;


import com.test.data.Board;
import com.test.exception.GameOverException;
import com.test.exception.InvalidIndexException;

public interface ActionHandler {

    void handleCellClick(int row, int col, Board board) throws GameOverException, InvalidIndexException;
}
