package com.example.midtermoop;

import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Pacman extends Sprite {

    Animation animation;
    protected int movement;
    private Input input;
    private double speed;
    SoundE SoundE;
    boolean timer;


    public Pacman(Pane layer, Image image, double x, double y, double dx, double dy, double speed, Input input, SoundE SE) {

        super(layer, image, x, y,  dx, dy);

        this.speed = speed;
        this.input = input;
        SoundE = SE;


    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


    public void InputP() {

        if( input.isMoveUp()) {
            movement = 1;
            Xdir = 0;
            Ydir = -speed;

        } else if( input.isMoveDown()) {
            movement = 2;
            Ydir = speed;
            Xdir = 0;
        }

        if( input.isMoveLeft()) {
            movement = 3;
            Xdir = -speed;
            Ydir = 0;

        } else if( input.isMoveRight()) {
            movement = 4;
            Xdir = speed;
            Ydir = 0;
        }



    }

    public boolean imageTimer() {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        timer = true;
                    }
                },
                50
        );

        return timer;
    }

    @Override
    public void Mot() {
        super.Mot();

        Bonus();
    }

    private void Bonus() {

        if( Y < 0 ) {
            Y = 0;
        } else if( (Y + HEIGHT) > size.SCENE_H ) {
            Y = size.SCENE_H- HEIGHT;
        }

        if( X < 0) {
            X = 0;
        } else if( (X + WIDTH) > size.SCENE_W ) {
            X = size.SCENE_W- WIDTH;
        }
    }

}
