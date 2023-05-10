package org.academiadecodigo.bootcamp.glass;

import org.academiadecodigo.bootcamp.glass.Grid.Grid;
import org.academiadecodigo.bootcamp.glass.Painter.Painter;

public class Main {


    public static void main(String[] args) {

        Grid grid = new Grid();
        Painter painter = new Painter(grid);
        new Handler(painter);
    }
}