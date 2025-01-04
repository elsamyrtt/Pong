package com.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {

    int WIDTH = 20, HEIGHT = 150, x = 0, y = 270;
    int R = 80, G = 67, B = 89;

    public Player() {
        setRect(x, y, WIDTH, HEIGHT);
    }

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        setRect(x, y, WIDTH, HEIGHT);
    }

    public void draw(Graphics g) {
        Color C = new Color(R, G, B);
        g.setColor(C);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

}