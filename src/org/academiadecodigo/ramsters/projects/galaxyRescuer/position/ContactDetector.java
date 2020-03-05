package org.academiadecodigo.ramsters.projects.galaxyRescuer.position;

import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenarioElement.Asteroid;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenarioElement.Player;

public class ContactDetector {

    private boolean crashDetected = false;

    public boolean checkForCrashed(Player player, Asteroid asteroid) {

        if (asteroid.getPosition().equals(player.getPosition())) {

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
