package com.test.component;


import com.test.data.Board;

public interface BoardGenerator {
    Board generateBoard(int rows, int cols, int blackHolesCount);
}
