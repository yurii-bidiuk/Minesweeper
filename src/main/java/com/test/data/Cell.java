package com.test.data;

public class Cell {
    private boolean isOpen;
    private boolean isBlackHole;
    private int value;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isBlackHole() {
        return isBlackHole;
    }

    public void setBlackHole(boolean blackHole) {
        isBlackHole = blackHole;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void incrementValue() {
        this.value++;
    }
}
