package org.academiadecodigo.ramsters.projects.galaxyRescuer.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int PADDING = 15;

    private final int cellSize = 15;
    private int cols;
    private int rows;

    private Picture field;

    public Grid(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;
        this.field = new Picture(PADDING, PADDING, "/Users/codecadet/java/javaprojects/groupprojects/GalaxyRescuer/resource/img/SPACE_BG_GIMP.jpg");

    }

    public void init() {

        field.draw();

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
