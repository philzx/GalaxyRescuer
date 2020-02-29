package org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Scenario {

    private Scenario scenario;
    private boolean active;


    public Scenario() {

        this.canvas = new Rectangle();

    }


    public void init() {

        canvas.fill();

    }

    public void stringPrinter(String string) {

    }

}
