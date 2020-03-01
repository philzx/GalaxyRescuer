package org.academiadecodigo.ramsters.projects.galaxyRescuer;

import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.ContactDetector;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.Galaxy;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Grid;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements.Asteroid;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements.AsteroidFactory;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements.Player;

public class Game {

    private ContactDetector contactDetector;
    private Galaxy galaxy;
    private Grid grid;
    private Player player;
    private AsteroidFactory asteroidFactory;
    private Asteroid[] asteroids;

    public void init() {

        this.grid = new Grid(20, 30);

        this.player = new Player(this.grid);

        this.asteroidFactory = new AsteroidFactory();

    }

    public void start() throws InterruptedException {

        this.grid.init();

        this.player.init();

        this.asteroids = this.asteroidFactory.createAsteroid(20, this.grid);

        for (int i = 0; i < 200; i++) {

            for (Asteroid each : asteroids) {

                Thread.sleep(5);

                each.init();

                each.move();

                

            }

            System.out.println("HIHIHIHIHI");
        }

    }

}
