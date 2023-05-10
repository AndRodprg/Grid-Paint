package org.academiadecodigo.bootcamp.glass;

import org.academiadecodigo.bootcamp.glass.Grid.Cells;
import org.academiadecodigo.bootcamp.glass.Grid.Grid;
import org.academiadecodigo.bootcamp.glass.Painter.Painter;

import java.io.*;

public class SaveLoad {

    private final Grid grid;
    private final Painter painter;

    public SaveLoad(Painter painter, Grid grid) {
        this.painter = painter;
        this.grid = grid;
    }

    public void eraseFileContent() throws IOException {
        FileWriter writer = new FileWriter("resources/saveFile.txt");
        BufferedWriter bWriter = new BufferedWriter(writer);

        //add text to buffer
        bWriter.write("");

        bWriter.flush();
        bWriter.close();
    }

    public void saveGridContent(String file) throws IOException {

        // create a new file writer
        FileWriter writer = new FileWriter(file);

        // wrap the file writer using a buffered writer
        BufferedWriter bWriter = new BufferedWriter(writer);

        //add text to buffer
        for (Cells cells : grid.getCells()) {
            //col of the cell, row of the cell, boolean isPainted of the cell
            bWriter.write(cells.getCol() + " " + cells.getRow() + " " + cells.isPainted() + "\n");
        }

        bWriter.flush(); // if the buffer is not full, flush will force disk write
        bWriter.close(); // auto-flush is done on close
    }

    public void loadGridContent(String file) throws IOException {


        // create a new file reader
        FileReader reader = new FileReader(file);

        // wrap the file reader using a buffered reader
        BufferedReader bReader = new BufferedReader(reader);

        //verify if the file is not empty
        if (bReader.readLine() != null) {
            String line;

            //erase all cells from the grid and delete them from the linked list
            painter.clearAll();
            grid.getCells().clear();

            // using the buffered reader we can read lines
            while ((line = bReader.readLine()) != null) {

                //every line on the file is written like : "Col of the cell /  Row of the cell / Boolean if the cell in that position is painted"
                String[] lineArray = line.split(" ");
                Cells newCell = new Cells(Integer.parseInt(lineArray[0]), Integer.parseInt(lineArray[1]), Boolean.parseBoolean(lineArray[2]));
                grid.getCells().add(newCell);
            }
            painter.drawPainter();
        }
        bReader.close();


    }

}
