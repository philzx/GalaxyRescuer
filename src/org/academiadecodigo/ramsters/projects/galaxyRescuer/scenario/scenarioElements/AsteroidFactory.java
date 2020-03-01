package org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements;

import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Grid;

public class AsteroidFactory {

    public Asteroid[] createAsteroid(int asteroidNumber, Grid grid) {
        Asteroid[] asteroids = new Asteroid[asteroidNumber];

        for (int i = 0; i < asteroids.length; i++) {
            asteroids[i] = new Asteroid(grid);
        }

        return asteroids;
    }

}
