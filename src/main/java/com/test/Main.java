package com.test;

import com.test.component.impl.ActionHandlerImpl;
import com.test.component.impl.BoardGeneratorImpl;
import com.test.component.impl.CellInitializerImpl;

public class Main {
    public static void main(String[] args) {
        Game game = new ConsoleGame(new BoardGeneratorImpl(new CellInitializerImpl()), new ActionHandlerImpl());
        game.start();
    }
}