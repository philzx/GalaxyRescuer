package org.academiadecodigo.ramsters.projects.galaxyRescuer;

import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.ContactDetector;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.Galaxy;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Grid;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements.Player;

public class Game {

    private ContactDetector contactDetector;
    private Galaxy galaxy;
    private Grid grid;
    private Player player;

    public void init() {

        this.grid = new Grid(20, 30);

        this.player = new Player(this.grid);

    }

    public void start() {

        this.grid.init();

        this.player.init();

    }

}
