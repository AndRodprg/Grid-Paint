package org.academiadecodigo.bootcamp.glass.Grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cells {

    private final int col;
    private final int row;
    private boolean painted;
    private final Rectangle rectangle;

    public Cells(int col, int row, boolean painted){
        this.col = col;
        this.row = row;
        this.painted = painted;
        rectangle = new Rectangle(col, row, Grid.CELL_SIZE, Grid.CELL_SIZE);

        //If true, fill the cell, if false draws only the outlines
        if(painted){
            rectangle.fill();
        } else {
            rectangle.draw();
        }
    }

    //Getters to col, row, rectangle and painted
    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }
    public Rectangle getRectangle() {
        return rectangle;
    }
    public boolean isPainted() {
        return painted;
    }

    //Setter to painted
    public void setPainted(boolean painted) {
        this.painted = painted;
    }
}
