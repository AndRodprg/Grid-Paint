package org.academiadecodigo.bootcamp.glass.Grid;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;

public class Grid {
    public static final int PADDING = 10;
    public static final int CELL_SIZE = 20;
    public static final int COL_NUMS = 30;
    public static final int ROW_NUMS = 30;

    private final int WIDTH;
    private final int HEIGHT;

    private LinkedList<Cells> cells;

    public Grid(){
        //Convert the number of cols and rows to pixels
        WIDTH = COL_NUMS * CELL_SIZE;
        HEIGHT = ROW_NUMS * CELL_SIZE;

        //Create and draw the outline of the grid
        Rectangle rectangle = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);
        rectangle.draw();
        //Create and draw the inlines of the grid
        generateGridInlines();
    }


    private void generateGridInlines(){
        cells = new LinkedList<>();

        for(int col = 0; col <= COL_NUMS; col++){
            for (int row = 0; row <= ROW_NUMS; row++){
                cells.add(new Cells((col * CELL_SIZE + PADDING),(row * CELL_SIZE + PADDING), false));
            }
        }
    }

    //Getters for grid's width, height and cells linked list
    public int getWIDTH() {
        return WIDTH;
    }
    public int getHEIGHT() {
        return HEIGHT;
    }
    public LinkedList<Cells> getCells() {
        return cells;
    }
}
