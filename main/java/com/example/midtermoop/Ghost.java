package com.example.midtermoop;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Enemy extends Sprite {

    public Enemy(Pane layer,
                 Image image,
                 double x,
                 double y,
                 double dx,
                 double dy ) {
        super(layer, image, x, y, dx, dy);
    }

    public void Mot() {

        switch (dir){
            case 0: Ydir = -1;
                Xdir =0;
                break;
            case 1 :
                Ydir = 1;
                Xdir =0;
                break;
            case 2 :
                Xdir = 1;
                Ydir =0;
                break;
            case 3 :
                Xdir = -1;
                Ydir =0;
                break;
        }

        super.Mot();

    }
}
