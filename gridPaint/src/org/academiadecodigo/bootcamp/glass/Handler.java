package org.academiadecodigo.bootcamp.glass;

import org.academiadecodigo.bootcamp.glass.Painter.Painter;
import org.academiadecodigo.bootcamp.glass.Painter.PainterDirection;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class Handler implements KeyboardHandler {

    private final Painter painter;
    private final SaveLoad saveLoad;
    private final Keyboard keyboard;

    public Handler(Painter painter) {
        this.painter = painter;
        saveLoad = new SaveLoad(painter,painter.getGrid());
        keyboard = new Keyboard(this);

        createKeyboardEvents();
    }

    public void createKeyboardEvents(){

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventUp);

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventDown);

        //Draw and erase cell
        KeyboardEvent keyboardEventDraw = new KeyboardEvent();
        keyboardEventDraw.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventDraw.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventDraw);

        //clear save file
        KeyboardEvent keyboardEventErase = new KeyboardEvent();
        keyboardEventErase.setKey(KeyboardEvent.KEY_BACK_SLASH);
        keyboardEventErase.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventErase);

        //Save painted cells on file
        KeyboardEvent keyboardEventSave = new KeyboardEvent();
        keyboardEventSave.setKey(KeyboardEvent.KEY_S);
        keyboardEventSave.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventSave);

        //Load painted cells on file
        KeyboardEvent keyboardEventLoad = new KeyboardEvent();
        keyboardEventLoad.setKey(KeyboardEvent.KEY_L);
        keyboardEventLoad.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLoad);

        //Erase all cells on the grid
        KeyboardEvent keyboardEventEraseGrid = new KeyboardEvent();
        keyboardEventEraseGrid.setKey(KeyboardEvent.KEY_E);
        keyboardEventEraseGrid.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventEraseGrid);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                painter.move(PainterDirection.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                painter.move(PainterDirection.LEFT);
                break;
            case KeyboardEvent.KEY_UP:
                painter.move(PainterDirection.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                painter.move(PainterDirection.DOWN);
                break;
            case KeyboardEvent.KEY_SPACE:
                painter.paint();
                break;
            case KeyboardEvent.KEY_BACK_SLASH:
                try {
                    saveLoad.eraseFileContent();
                } catch (IOException e) {
                    System.out.println("Wrong file path");
                }
                break;
            case KeyboardEvent.KEY_S:
                try {
                    saveLoad.saveGridContent("resources/saveFile.txt");
                } catch (IOException e) {
                    System.out.println("Wrong file path");
                }
                break;
            case KeyboardEvent.KEY_L:
                try {
                    saveLoad.loadGridContent("resources/saveFile.txt");
                } catch (IOException e) {
                    System.out.println("Wrong file path");
                }
                break;
            case KeyboardEvent.KEY_E:
                painter.clearAll();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

