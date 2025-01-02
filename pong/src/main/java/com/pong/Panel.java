package com.pong;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;

public class Panel extends JPanel {
    // Player Left && Player Right
    public Player PL = new Player();
    public Player PR = new Player(900 - 35, 350);
    int SPEED = 20;

    // Entradas de teclado
    public Panel() {
        setBackground(Color.BLACK);
        addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    PL.y -= SPEED;
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    PL.y += SPEED;
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    PR.y -= SPEED;
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    PR.y += SPEED;
                    repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

        });
        this.setFocusable(true);
    }

    // dibujando graficos
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        PL.draw(g);
        PR.draw(g);
        repaint();
    }
}