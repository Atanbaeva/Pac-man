package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public abstract class Sprite {

    protected Image image;
    protected ImageView imageView;
    private Pane layer;
    protected double X;
    protected double Y;
    protected double Xdir;
    protected double Ydir;
    protected double WIDTH;
    protected double HEIGHT;
    protected double fWidth = 20;
    protected double fHeight = 20;
    int dir = 0;
    protected boolean collision2 = false;

    public Sprite(Pane layer, Image image, double x, double y, double dx, double dy) {

        this.layer = layer;
        this.image = image;
        this.X = x;
        this.Y = y;

        this.Xdir = dx;
        this.Ydir = dy;

        this.imageView = new ImageView(image);
        this.imageView.relocate(x, y);

        this.WIDTH = image.getWidth();
        this.HEIGHT = image.getHeight();

        addToLayer();
    }

    public void setImageView(Image image) {
        this.imageView = new ImageView(image);
        this.imageView.relocate(X, Y);
    }


    public void Mot() {
        X += Xdir;
        Y += Ydir;
    }

    public void spriteMovement() {
        X += Xdir;
        Y += Ydir;
    }

    public boolean collidesWithCoord(Rectangle block, double x, double y) {
        return (block.intersects(x, y, WIDTH, HEIGHT));

    }

    public boolean collidesWith(Rectangle block) {
        return (block.intersects(X, Y, fWidth, fHeight));

    }

    public boolean collidesWith(Circle dot) {
        return (dot.intersects(X, Y, fWidth, fHeight));

    }

    public void freeze() {
        X -= Xdir;
        Y -= Ydir;
    }

    public void updateUI() {
        imageView.relocate(X, Y);
    }

    public void updateUI(double x, double y) {
        this.X = x;
        this.Y = y;
        imageView.relocate(x, y);
    }


    public boolean collidesWith(Sprite otherSprite) {
        return (otherSprite.X + otherSprite.WIDTH >= X && otherSprite.Y + otherSprite.HEIGHT >= Y && otherSprite.X <= X + WIDTH && otherSprite.Y <= Y + HEIGHT);
    }

    public void addToLayer() {
        this.layer.getChildren().add(this.imageView);
    }

    public void removeFromLayer() {
        this.layer.getChildren().remove(this.imageView);
    }

    public double getCenterX() {
        return X + WIDTH * 0.5;
    }

    public double getCenterY() {
        return Y + HEIGHT * 0.5;
    }

}

