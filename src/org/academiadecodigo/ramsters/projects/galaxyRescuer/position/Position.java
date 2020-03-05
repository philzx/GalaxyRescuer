package org.academiadecodigo.ramsters.projects.galaxyRescuer.position;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Position {

    private int col;
    private int row;
    private Grid grid;
    private Picture picture;

    public Position(int col, int row, Grid grid) {

        this.col = col;

        this.row = row;

        this.grid = grid;

    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public int getCol() {

        return col;

    }

    public int getRow() {

        return row;

    }

    public void setRowPlayer(int row){

        int previousHeight = grid.rowToY(this.row);

        this.row = row;

        int height = grid.rowToY(row);

        picture.translate(0, height - previousHeight);
    }

    public void setCol(int col) {

        int previousWidth = grid.colToX(this.col);

        this.col = col;

        int width = grid.colToX(col);

        picture.translate(width - previousWidth, 0);

    }

    public void updateCol(int col) {

        this.col += col;

        int width = grid.colToX(col);

        picture.translate(width, 0);

    }

    public void updateRow(int row) {

        this.row += row;

        int height = grid.rowToY(row);


        picture.translate(0, height);

    }

    @Override
    public boolean equals(Object pos) {

        if (((Position) pos).getCol() == this.getCol() && ((Position) pos).getRow() == this.getRow()){
         return true;
        }
    return false;
    }

}
