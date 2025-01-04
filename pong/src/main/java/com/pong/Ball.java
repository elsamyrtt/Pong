package com.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends Rectangle {

    int HEIGHT = 25, WIDTH = 25, x = 442, y = 330;

    public Ball() {
        setRect(x, y, WIDTH, HEIGHT);
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

}
