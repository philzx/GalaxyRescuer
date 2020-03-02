package org.academiadecodigo.ramsters.projects.galaxyRescuer;

import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.ContactDetector;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.Galaxy;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Grid;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements.Asteroid;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements.AsteroidFactory;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenario.scenarioElements.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {

    private ContactDetector contactDetector;
    private Galaxy galaxy;
    private Grid grid;
    private Player player;
    private AsteroidFactory asteroidFactory;
    private Asteroid[] asteroids;
    private boolean restart = false;

    private Keyboard keyboard2;
    KeyboardEvent sPressed;

    public Game() {
        this.keyboard2 = new Keyboard(this);

    }


    public void setRestart() {
        this.restart = true;
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            System.out.println("test");
            setRestart();
            contactDetector.unCrashDetected();
            System.out.println(this.restart);
        }
    }

    public void init() {

        this.grid = new Grid(20, 50);

        this.player = new Player(this.grid);

        this.asteroidFactory = new AsteroidFactory();

        this.contactDetector = new ContactDetector();


        KeyboardEvent sPressed = new KeyboardEvent();

        sPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        sPressed.setKey(KeyboardEvent.KEY_S);

        keyboard2.addEventListener(sPressed);

        this.grid.init();

        this.player.init();


    }

    public void start() throws InterruptedException {

        contactDetector.unCrashDetected();

        this.player.getRectangle().fill();

        this.asteroids = this.asteroidFactory.createAsteroid((this.grid.getRows() / 2) - 1, this.grid);

        for (Asteroid each : asteroids) {

            each.init();

        }


        while (!(contactDetector.getCrashDetected())) {

            Thread.sleep(35);

            player.move();

            for (Asteroid each : asteroids) {

                Thread.sleep(0); // For some reason this works, only god knows

                each.move();

                contactDetector.checkForCrashed(this.player, each);

            }

        }



        this.restart = false;
        for (Asteroid a : asteroids) {
            a.getRectangle().delete();
        }

        this.player.getRectangle().delete();

        while (!this.restart) {
            Thread.sleep(100);
        }

        //need to create a new player if re.init() the old one it moves 2 units, might be due to keyboard events repeating
        // this is super slow, and makes game restart with a big lag, player can creep up too easily
        this.player = new Player(this.grid);
        this.player.init();

        this.start();


    }

}
