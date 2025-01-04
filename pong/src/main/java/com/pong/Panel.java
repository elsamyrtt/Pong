package com.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Panel extends JPanel {
    // Player Left && Player Right
    public Player PL = new Player();
    public Player PR = new Player(865, 270);
    public Ball BALL = new Ball();
    boolean W = false, S = false, Up = false, Do = false;
    int SPEED = 30;

    // Entradas de teclado
    public Panel() {
        repaint();
        setBackground(Color.BLACK);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode() == KeyEvent.VK_W) {
                    W = true;
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_S) {
                    S = true;
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_UP) {
                    Up = true;
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
                    Do = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getExtendedKeyCode() == KeyEvent.VK_W) {
                    W = false;
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_S) {
                    S = false;
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_UP) {
                    Up = false;
                }
                if (e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
                    Do = false;
                }
            }
        });

        this.setFocusable(true);
        new Thread(() -> {
            while (true) {
                updateMoves();
                repaint();
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }).start();
    }

    public void updateMoves() {
        if (W && PL.y != 0) {
            PL.y -= SPEED;
        }
        if (S && PL.y != 510) {
            PL.y += SPEED;
        }
        if (Up && PR.y != 0) {
            PR.y -= SPEED;
            System.out.println(PR.y);
        }
        if (Do && PR.y != 510) {
            PR.y += SPEED;
            System.out.println(PR.y);
        }
    }

    // dibujando graficos
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        PL.draw(g);
        BALL.draw(g);
        PR.draw(g);
        repaint();
    }
}