package com.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends Rectangle {

    int HEIGHT = 25, WIDTH = 25, x = 442, y = 331, dx = 3, dy = -3;

    public Ball() {
        setRect(x, y, WIDTH, HEIGHT);
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public void move(int w, int h) {
        if (x + dx > w - 25 || x + dx < 1) {
            dx = -dx;
        }
        if (y + dy > h - 25 || y + dy < 1) {
            dy = -dy;
        }
        y += dy;
        x += dx;
        setBounds(x, y, WIDTH, HEIGHT);
    }

}