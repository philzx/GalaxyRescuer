package org.academiadecodigo.ramsters.projects.galaxyRescuer.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    public static final int PADDING = 10;

    private final int cellSize = 15;
    private int cols;
    private int rows;

    private Rectangle field;

    public Grid(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;
        this.field = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);

    }

    public void init() {

        field.setColor(Color.BLACK);
        field.fill();

    }

    public int getCols() {

        return cols;

    }

    public int getRows() {

        return rows;

    }

    public int getWidth() {

        return field.getWidth();

    }

    public int getHeight() {

        return field.getHeight();

    }

    public int getX() {

        return field.getX();

    }

    public int getY() {

        return field.getY();

    }

    public int getCellSize() {

        return cellSize;

    }

    /*public Position makeGridPosition() {

        return new Position();

    }*/

    public int rowToY(int row) {

        return row * cellSize;

    }

    public int colToX(int col) {

        return col * cellSize;

    }

}
