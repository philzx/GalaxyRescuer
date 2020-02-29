package org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements;

import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Movable;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Position;

public class Player implements Movable {

    private Position position;
    private int xSpeed = 0;
    private int ySpeed = 0;

    public void collide() {

    }

    @Override
    public Position move() {
        if(evenlistenerUp){
            ySpeed = -1;
        }
        if(evenlisternerUpRelease){
            ySpeed = 0;
        }
        if(evenlistenerDown){
            ySpeed = 1;
        }
        if(evenlistenerDownRelease){
            ySpeed = 0;
        }
        if(evenlistenerLeft){
            xSpeed = -1;
        }
        if (evenlistenerLeftRelease){
            xSpeed = 0;
        }
        if (evenlistenerRight){
            xSpeed = 1;
        }
        if(evenlistenerRightRelease){
            xSpeed = 0;
        }
        this.getPos().updateCol(xSpeed);
        this.getPos().updateCol(ySpeed);
        return this.getPos();
    }

    public void land() {

    }
}
