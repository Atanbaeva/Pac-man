package com.example.midtermoop;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.BitSet;

public class Input {

    private BitSet KBitSet = new BitSet();

    private KeyCode upK = KeyCode.UP;
    private KeyCode downK = KeyCode.DOWN;
    private KeyCode leftK = KeyCode.LEFT;
    private KeyCode rightK = KeyCode.RIGHT;
    private KeyCode primaryK = KeyCode.SPACE;
    private KeyCode secondaryWK = KeyCode.CONTROL;

    Scene scene;

    public Input( Scene scene) {
        this.scene = scene;
    }

    public void addListeners() {

        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
        scene.addEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);

    }

    public void removeListeners() {

        scene.removeEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
        scene.removeEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);

    }

    private EventHandler<KeyEvent> keyPressedEventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            KBitSet.set(event.getCode().ordinal(), true);

        }
    };

    private EventHandler<KeyEvent> keyReleasedEventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            KBitSet.set(event.getCode().ordinal(), false);

        }
    };

    public boolean isMoveUp() {
        return KBitSet.get( upK.ordinal()) && !KBitSet.get( downK.ordinal());

    }

    public boolean isMoveDown() {
        return KBitSet.get( downK.ordinal()) && !KBitSet.get( upK.ordinal());
    }

    public boolean isMoveLeft() {
        return KBitSet.get( leftK.ordinal()) && !KBitSet.get( rightK.ordinal());
    }

    public boolean isMoveRight() {
        return KBitSet.get( rightK.ordinal()) && !KBitSet.get( leftK.ordinal());
    }

    public boolean isFirePrimaryWeapon() {
        return KBitSet.get( primaryK.ordinal());
    }

    public boolean isFireSecondaryWeapon() {
        return KBitSet.get( secondaryWK.ordinal());
    }

}
