package org.academiadecodigo.ramsters.projects.galaxyRescuer.position;

import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements.Asteroid;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class ContactDetector {


    public boolean checkForCrashed(Player player, Asteroid asteroid) {

        if (asteroid.getPosition().equals(player.getPosition())) {

            player.getRectangle().setColor(Color.PINK);

            player.getRectangle().fill();
        }

        return true;

    }


}
