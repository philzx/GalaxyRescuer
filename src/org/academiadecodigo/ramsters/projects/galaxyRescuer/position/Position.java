package org.academiadecodigo.ramsters.projects.galaxyRescuer.position;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Position {

    private int col;
    private int row;
    private Grid grid;
    private Rectangle rectange;


    public Position(int col, int row) {
        this.col = col;
        this.row = row;
        this.grid = new Grid();
    }

    public int getCol() {

        return col;

    }

    public int getRow() {

        return row;

    }

    public void updateCol(int col) {

        this.col += col;

        int width = grid.colToX(col);

        rectange.translate(width, 0);

    }

    public void updateRow(int row) {

        this.row += row;

        int height = grid.rowToY(row);

        rectange.translate(0, height);

    }

}
