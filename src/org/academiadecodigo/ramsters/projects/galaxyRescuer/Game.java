package org.academiadecodigo.ramsters.projects.galaxyRescuer;

import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.ContactDetector;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.position.Grid;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenarioElement.Asteroid;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenarioElement.AsteroidFactory;
import org.academiadecodigo.ramsters.projects.galaxyRescuer.scenarioElement.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

    private ContactDetector contactDetector;
    private Grid grid;
    private Player player;
    private AsteroidFactory asteroidFactory;
    private Asteroid[] asteroids;
    private boolean restart = false;
    private Keyboard keyboard2;
    private Picture gameOver;
    private Picture winScreen;
    private Picture beginningScreen;
    private boolean wonGame;
    private boolean gameStarted;

    public Game() {

        this.keyboard2 = new Keyboard(this);
        this.gameOver = new Picture(Grid.PADDING, Grid.PADDING, "resource/img/OVER_GIMP.jpg");
        this.winScreen = new Picture(Grid.PADDING, Grid.PADDING, "resource/img/WINNING_GIMP.jpg");
        this.beginningScreen = new Picture(Grid.PADDING, Grid.PADDING, "resource/img/BEGINNING_GIMP.jpg");
        this.wonGame = false;
        this.gameStarted = false;
    }

    public void reset() {

        for (Asteroid asteroid : asteroids) {

            asteroid.getPosition().setCol((int) (Math.ceil(Math.random() * this.grid.getCols())));
            asteroid.getPosition().setRowPlayer(asteroid.getPositionInitial().getRow());

        }

        player.getPosition().setCol(this.grid.getCols() / 2);
        player.getPosition().setRowPlayer(this.grid.getRows());
        this.player.getPicture().draw();

    }


    public void setRestart() {
        this.restart = true;
    }

    public void setStarted() {
        if (!gameStarted) {
            gameStarted = true;
        }
    }

    public boolean getRestart() {
        return this.restart;
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {

            setRestart();
            setStarted();
            contactDetector.unCrashDetected();

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
        this.beginningScreen.draw();

        this.player.init();

        this.asteroids = this.asteroidFactory.createAsteroid((this.grid.getRows() / 2) - 1, this.grid);

    }

    public void start() throws InterruptedException {

        contactDetector.unCrashDetected();

        this.restart = false;

        while (!gameStarted) {

            Thread.sleep(30);

        }

        this.beginningScreen.delete();

        while (!(contactDetector.getCrashDetected())) {

            Thread.sleep(30);

            player.move();

            if (contactDetector.playerAtTop(this.player)) {

                this.winScreen.draw();
                wonGame = true;
                break;

            }

            for (Asteroid each : asteroids) {

                contactDetector.checkForCrashed(this.player, each);

                each.move();

                contactDetector.checkForCrashed(this.player, each);

            }

        }

        for (Asteroid a : asteroids) {

            a.getPicture().delete();
        }


        this.player.getPicture().delete();

        if (!wonGame) {
            this.gameOver.draw();
        }

        while (!this.restart) {

            Thread.sleep(1);

            if (restart) {

                reset();
                this.wonGame = false;
                this.gameOver.delete();
                this.winScreen.delete();

            }

        }

    }

}
