package com.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {

    int WIDTH = 20, HEIGHT = 150, x = 0, y = 270;
    int R = 255, G = 255, B = 255;

    public Player() {
        setRect(x, y, WIDTH, HEIGHT);
    }

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        setRect(x, y, WIDTH, HEIGHT);
    }

    public Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.HEIGHT = height;
        this.WIDTH = width;
        setRect(x, y, width, height);
    }

    public void draw(Graphics g) {
        Color C = new Color(R, G, B);
        g.setColor(C);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public void move(Player P, boolean Up, boolean Do, int SPEED) {
        if (Up && P.y != 0) {
            P.y -= SPEED;
        }
        if (Do && P.y != 510) {
            P.y += SPEED;
        }
        setBounds(x, y, WIDTH, HEIGHT);
    }

}