package org.academiadecodigo.ramsters.projects.galaxyRescuer.position;

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
        this.field = new Picture(PADDING, PADDING, "resource/img/SPACE_BG_GIMP.jpg");

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

    public int getHeight() {

        return field.getHeight();

    }

    public int rowToY(int row) {

        return row * cellSize;

    }

    public int colToX(int col) {

        return col * cellSize;

    }

}
