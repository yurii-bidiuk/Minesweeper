package com.test;

import com.test.component.ActionHandler;
import com.test.component.BoardGenerator;
import com.test.component.impl.ConsoleBoardPrinter;

import java.util.Scanner;

public class ConsoleGame extends Game {

    private final Scanner scanner = new Scanner(System.in);

    public ConsoleGame(BoardGenerator boardGenerator, ActionHandler actionHandler) {
        super(boardGenerator, actionHandler, new ConsoleBoardPrinter());
    }
    @Override
    protected int getRowsCount() {
        System.out.println("Enter width: ");
        return scanner.nextInt();
    }

    @Override
    protected int getColumnsCount() {
        System.out.println("Enter height: ");
        return scanner.nextInt();
    }

    @Override
    protected int getBlackHolesCount() {
        System.out.println("Enter black holes: ");
        return scanner.nextInt();
    }

    @Override
    protected int getRowIndex() {
        System.out.println("Enter row index: ");
        return scanner.nextInt();
    }

    @Override
    protected int getColumnIndex() {
        System.out.println("Enter column index: ");
        return scanner.nextInt();
    }

    @Override
    protected void printMessage(String message) {
        System.out.println(message);
    }
}
