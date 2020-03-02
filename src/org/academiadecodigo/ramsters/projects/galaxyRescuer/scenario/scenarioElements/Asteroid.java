package org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements;

import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Movable;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Position;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Asteroid implements Movable {

    private static int decrementedRow = -1;

    private Position position;
    private Position positionInitial;
    private Grid grid;
    private Rectangle rectangle;
    private Picture geodude;

    private int col;

    public Asteroid(Grid grid) {

        this.grid = grid;

        int row = decrementedRow;

        col = (int) (Math.ceil(Math.random() * this.grid.getCols()));

        this.position = new Position(col, row, this.grid);

        decrementedRow -= 2;

        this.rectangle = new Rectangle(this.grid.colToX(position.getCol()), this.grid.rowToY(position.getRow()), this.grid.getCellSize(), this.grid.getCellSize());
        this.geodude = new Picture(this.grid.colToX(position.getCol()), this.grid.rowToY(position.getRow()), "//users/codecadet/Desktop/geodude.png");
        this.position.setRectangle(this.rectangle);
        this.position.setPicture(this.geodude);


        positionInitial = new Position(this.position.getCol(), this.position.getRow(), grid);

    }


    public void init() {

        rectangle.setColor(Color.YELLOW);

        rectangle.fill();
        geodude.draw();

    }

    @Override
    public void move() {

        if (position.getRow() >= grid.getRows()) {

            position.setRow(0);

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

    public Rectangle getRectangle() {
        return rectangle;
    }
}
