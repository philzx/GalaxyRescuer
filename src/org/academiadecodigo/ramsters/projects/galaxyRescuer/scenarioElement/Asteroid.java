package org.academiadecodigo.ramsters.projects.galaxyRescuer.scenarioElement;

import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Movable;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Position;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Asteroid implements Movable {

    private static int decrementedRow = -1;

    private Position position;
    private Position positionInitial;
    private Grid grid;
    private Picture picture;

    private int col;

    public Asteroid(Grid grid) {

        this.grid = grid;

        int row = decrementedRow;

        col = (int) (Math.ceil(Math.random() * this.grid.getCols()));

        this.position = new Position(col, row, this.grid);

        decrementedRow -= 2;

        this.picture = new Picture(this.grid.colToX(position.getCol()), this.grid.rowToY(position.getRow()), "resource/img/ASTEROID_GIMP.jpg");
        this.position.setPicture(this.picture);


        positionInitial = new Position(this.position.getCol(), this.position.getRow(), grid);

    }


    public void init() {

        picture.draw();

    }

    @Override
    public void move() {

        if (position.getRow() == 0){
            init();
        }
        if (position.getRow() >= grid.getRows()) {

            position.updateRow(-49);

            position.setCol((int) (Math.ceil(Math.random() * this.grid.getCols())));

            return;

        }

        position.updateRow(1);

    }

    public Position getPosition() {

        return position;

    }

    public Position getPositionInitial(){

        return positionInitial;

    }

    public Picture getPicture(){
        return picture;
    }
}
