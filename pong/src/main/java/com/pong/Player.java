package com.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {

    int WIDTH = 20, HEIGHT = 150, x = 0, y = 350;
    int R = 255, G = 0, B = 0; // Comienza en rojo
    int colorPhase = 0; // Fase del ciclo de color

    public Player() {
        setRect(x, y, WIDTH, HEIGHT);
    }

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        setRect(x, y, WIDTH, HEIGHT);
    }

    public void draw(Graphics g) {
        updateColor(); // Actualiza los colores
        Color C = new Color(R, G, B);
        g.setColor(C);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    private void updateColor() {
        int step = 1; // Velocidad del cambio de color (ajustable)

        switch (colorPhase) {
            case 0: // Incrementa G
                G += step;
                if (G >= 255) {
                    G = 255;
                    colorPhase = 1;
                }
                break;
            case 1: // Decrementa R
                R -= step;
                if (R <= 0) {
                    R = 0;
                    colorPhase = 2;
                }
                break;
            case 2: // Incrementa B
                B += step;
                if (B >= 255) {
                    B = 255;
                    colorPhase = 3;
                }
                break;
            case 3: // Decrementa G
                G -= step;
                if (G <= 0) {
                    G = 0;
                    colorPhase = 4;
                }
                break;
            case 4: // Incrementa R
                R += step;
                if (R >= 255) {
                    R = 255;
                    colorPhase = 5;
                }
                break;
            case 5: // Decrementa B
                B -= step;
                if (B <= 0) {
                    B = 0;
                    colorPhase = 0;
                }
                break;
        }
    }
}