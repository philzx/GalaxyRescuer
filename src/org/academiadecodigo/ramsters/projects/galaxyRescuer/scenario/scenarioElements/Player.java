package org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements;

import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Grid;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Movable;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Player implements Movable, KeyboardHandler {

    private Position position;
    private int xSpeed;
    private int ySpeed;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private Keyboard keyboard;
    private Rectangle rectangle;
    private Grid grid;

    public Player(Grid grid) {

        this.xSpeed = 0;
        this.ySpeed = 0;
        this.up = false;
        this.down = false;
        this.left = false;
        this.right = false;

        this.grid = grid;

        this.keyboard = new Keyboard(this);
        this.rectangle = new Rectangle(grid.getWidth() / 2, grid.getHeight() - Grid.PADDING, grid.getCellSize(), grid.getCellSize());

    }

    public void init() {

        rectangle.setColor(Color.BLACK);
        rectangle.fill();

        KeyboardEvent upKey = new KeyboardEvent();
        KeyboardEvent downKey = new KeyboardEvent();
        KeyboardEvent leftKey = new KeyboardEvent();
        KeyboardEvent rightKey = new KeyboardEvent();

        upKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upKey.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        upKey.setKey(KeyboardEvent.KEY_UP);

        downKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downKey.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        downKey.setKey(KeyboardEvent.KEY_DOWN);

        leftKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftKey.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        leftKey.setKey(KeyboardEvent.KEY_LEFT);

        rightKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightKey.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        rightKey.setKey(KeyboardEvent.KEY_RIGHT);

        keyboard.addEventListener(upKey);
        keyboard.addEventListener(downKey);
        keyboard.addEventListener(leftKey);
        keyboard.addEventListener(rightKey);

    }

    public void collide() {

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:

                this.up = true;

                break;

            case KeyboardEvent.KEY_DOWN:

                this.down = true;

                break;

            case KeyboardEvent.KEY_LEFT:

                this.left = true;

                break;

            case KeyboardEvent.KEY_RIGHT:

                this.right = true;

                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:

                this.up = false;

                break;

            case KeyboardEvent.KEY_DOWN:

                this.down = false;

                break;

            case KeyboardEvent.KEY_LEFT:

                this.left = false;

                break;

            case KeyboardEvent.KEY_RIGHT:

                this.right = false;

                break;

        }

    }

    @Override
    public Position move() {

        if (this.up) {

            ySpeed = -1;

        }

        if (this.down) {

            ySpeed = 1;

        }

        if (!this.up || !this.down) {

            ySpeed = 0;

        }

        if (this.left) {

            xSpeed = -1;

        }

        if (this.right) {

            xSpeed = 1;

        }

        if (!this.left || !this.right) {

            xSpeed = 0;

        }

        this.getPos().updateCol(xSpeed);
        this.getPos().updateCol(ySpeed);
        return this.getPos();
    }

    public void land() {

    }
}
