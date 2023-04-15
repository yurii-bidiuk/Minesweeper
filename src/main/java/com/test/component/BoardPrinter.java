package com.test.component;


import com.test.data.Board;

public interface BoardPrinter {
    void printState(Board board);

    void printGameOver(Board board);

}
