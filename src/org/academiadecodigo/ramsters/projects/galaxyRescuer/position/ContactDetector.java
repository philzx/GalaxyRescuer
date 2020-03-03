package org.academiadecodigo.ramsters.projects.galaxyRescuer.position;

import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements.Asteroid;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class ContactDetector {

    private boolean crashDetected = false;

    public boolean checkForCrashed(Player player, Asteroid asteroid) {

        if (asteroid.getPosition().equals(player.getPosition())) {

            //player.getRectangle().setColor(Color.PINK);

            player.getRectangle().fill();

            crashDetected = true;
        }

        return true;

    }

    public boolean getCrashDetected() {

        return crashDetected;

    }

    public void unCrashDetected() {
        this.crashDetected = false;
    }

    public boolean playerAtTop(Player player) {

        if (player.getPosition().getRow() == 1) {
            return true;
        }
        return false;
    }
}
