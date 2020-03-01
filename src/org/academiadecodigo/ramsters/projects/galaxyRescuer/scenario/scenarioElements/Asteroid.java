package org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements;

import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Movable;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Position;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Asteroid implements Movable {

    private static int decrementedRow = -1;

    private Position position;
    private Grid grid;
    private Rectangle rectangle;

    public Asteroid(Grid grid) {

        this.grid = grid;

        int row = decrementedRow;

        int col = (int) (Math.ceil(Math.random() * this.grid.getCols()));

        this.position = new Position(col, row, this.grid);

        decrementedRow -= 2;

        this.rectangle = new Rectangle(this.grid.colToX(position.getCol()), this.grid.rowToY(position.getRow()), this.grid.getCellSize(), this.grid.getCellSize());

        this.position.setRectangle(this.rectangle);

    }

    public void init() {

        rectangle.setColor(Color.YELLOW);

        rectangle.fill();

    }

    @Override
    public void move() {

        if (position.getRow() >= grid.getRows()) {

            System.out.println("IM IN BITCH");

            position.setRow(0);

            return;

        }

        position.updateRow(1);

    }

    public Position getPosition() {
        return position;
    }
}
