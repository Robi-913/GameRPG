package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameInputKeys implements KeyListener {

    // Boolean flags to track the state of specific keys
    public boolean upkey, downkey, leftkey, rightkey;


    // Handle keyTyped event (not used in this implementation)
    @Override
    public void keyTyped(KeyEvent k) {
    }

    // Handle keyPressed event
    @Override
    public void keyPressed(KeyEvent k) {

        // Retrieve the keycode of the pressed key
        int keypress = k.getKeyCode();

        // Check which key was pressed and set the corresponding flag to true
        if (keypress == KeyEvent.VK_W) {

            upkey = true;

        }

        if (keypress == KeyEvent.VK_S) {

            downkey = true;

        }

        if (keypress == KeyEvent.VK_A) {

            leftkey = true;

        }

        if (keypress == KeyEvent.VK_D) {

            rightkey = true;

        }


    }

    // Handle keyReleased event
    @Override
    public void keyReleased(KeyEvent k) {

        // Retrieve the keycode of the released key
        int keypress = k.getKeyCode();

        // Check which key was released and set the corresponding flag to false
        if (keypress == KeyEvent.VK_W) {

            upkey = false;

        }

        if (keypress == KeyEvent.VK_S) {

            downkey = false;

        }

        if (keypress == KeyEvent.VK_A) {

            leftkey = false;

        }

        if (keypress == KeyEvent.VK_D) {

            rightkey = false;

        }

    }

}
