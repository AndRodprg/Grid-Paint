package org.academiadecodigo.bootcamp.glass.Painter;

import org.academiadecodigo.bootcamp.glass.Grid.Cells;
import org.academiadecodigo.bootcamp.glass.Grid.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Painter {

    private final Rectangle painter;
    private final Grid grid;

    public Painter(Grid grid) {
        this.grid = grid;
        painter = new Rectangle(Grid.PADDING, Grid.PADDING, Grid.CELL_SIZE, Grid.CELL_SIZE);
        drawPainter();
    }

    //Compares the position of every node on the linked list with the painter
    //if it's the same and not painted, paint it.
    //if it's already painted, erase that
    public void paint() {
        for (Cells cells : grid.getCells()) {
            if (painter.getX() == cells.getCol() && painter.getY() == cells.getRow() && !cells.isPainted()) {
                cells.getRectangle().delete();
                cells.getRectangle().fill();
                cells.setPainted(true);
                drawPainter();
                break;
            } else if (painter.getX() == cells.getCol() && painter.getY() == cells.getRow() && cells.isPainted()) {
                cells.getRectangle().delete();
                cells.getRectangle().draw();
                cells.setPainted(false);
            }
        }
    }

    //Erase every single cell on the greed
    //Press "E" to execute this
    public void clearAll() {
        for (Cells cells : grid.getCells()) {
            cells.setPainted(false);
            cells.getRectangle().delete();
            cells.getRectangle().draw();
        }
    }

    //Movement of the painter
    public void move(PainterDirection direction) {
        switch (direction) {
            case UP:
                if (!(painter.getY() - Grid.CELL_SIZE < Grid.PADDING)) {
                    painter.translate(0, -Grid.CELL_SIZE);
                }
                break;
            case LEFT:
                if (!(painter.getX() - Grid.CELL_SIZE < Grid.PADDING)) {
                    painter.translate(-Grid.CELL_SIZE, 0);
                }
                break;
            case RIGHT:
                if (!(painter.getX() + Grid.CELL_SIZE > grid.getWIDTH())) {
                    painter.translate(Grid.CELL_SIZE, 0);
                }
                break;
            case DOWN:
                if (!(painter.getY() + Grid.CELL_SIZE > grid.getHEIGHT())) {
                    painter.translate(0, Grid.CELL_SIZE);
                }
                break;
        }
    }

    //Method always called after painting a single cell to have the painter on top of everything
    public void drawPainter() {
        painter.delete();
        painter.setColor(Color.GREEN);
        painter.fill();
    }

    //Getter of the grid
    public Grid getGrid() {
        return grid;
    }
}
