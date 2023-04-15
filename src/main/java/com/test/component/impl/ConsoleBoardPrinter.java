package com.test.component.impl;

import com.test.component.BoardPrinter;
import com.test.data.Board;
import com.test.data.Cell;

public class ConsoleBoardPrinter implements BoardPrinter {

    @Override
    public void printState(Board board) {
        for (Cell[] cells : board.getCells()) {
            for (Cell cell : cells) {
                System.out.print(" " + (cell.isOpen() ? " " + cell.getValue() : "[]"));
            }
            System.out.println();
        }

        System.out.println();
    }

    @Override
    public void printGameOver(Board board) {
        for (Cell[] cells : board.getCells()) {
            for (Cell cell : cells) {
                if (cell.isBlackHole()) {
                    System.out.print("  *");
                } else {
                    System.out.print(" " + (cell.isOpen() ? " " + cell.getValue() : "[]"));
                }
            }
            System.out.println();
        }

        System.out.println("Game over!");
    }
}
