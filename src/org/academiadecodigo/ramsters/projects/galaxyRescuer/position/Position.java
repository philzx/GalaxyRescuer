package org.academiadecodigo.ramsters.projects.galaxyRescuer.position;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Position {

    private int col;
    private int row;
    private Grid grid;
    private Rectangle rectangle;


    public Position(int col, int row, Grid grid) {

        this.col = col;

        this.row = row;

        this.grid = grid;

    }

    public int getCol() {

        return col;

    }

    public int getRow() {

        return row;

    }

    public void setRow(int row) {

        this.row = row;

        int height = grid.getHeight();

        rectangle.translate(0, - height);

    }

    public void updateCol(int col) {

        this.col += col;

        int width = grid.colToX(col);

        rectangle.translate(width, 0);

    }

    public void updateRow(int row) {

        this.row += row;

        int height = grid.rowToY(row);

        rectangle.translate(0, height);

    }

    public void setRectangle(Rectangle rectangle) {

        this.rectangle = rectangle;

    }

    @Override
    public boolean equals(Object pos) {

        if (((Position) pos).getCol() == this.getCol() && ((Position) pos).getRow() == this.getRow()){
         return true;
        }
    return false;
    }

}
