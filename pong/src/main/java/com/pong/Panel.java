package com.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel {
    boolean W = false, S = false, Up = false, Do = false;
    // Player Left && Player Right
    public Player PL = new Player(0, 270, 20, 150);
    public Player PR = new Player(865, 270, 20, 150);
    public Player WALL_L = new Player(0, 1, 8, 700);
    public Player WALL_R = new Player(883, 1, 8, 700);
    public Ball BALL = new Ball();
    public int SL = 0, SR = 0;
    public JLabel scoreR = new JLabel("SCORE P2: " + SR);
    public JLabel scoreL = new JLabel("SCORE P1: " + SL);
    int SPEED = 30;

    // Entradas de teclado

    public Panel() {
        setFocusTraversalKeysEnabled(false);
        requestFocusInWindow();
        setLayout(null);
        scoreL.setBounds(150, 10, 200, 15);
        scoreR.setBounds(600, 10, 200, 15);
        scoreL.setForeground(Color.WHITE);
        scoreR.setForeground(Color.WHITE);

        add(scoreL);
        add(scoreR);

        setBackground(Color.BLACK);
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    W = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    S = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    Up = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
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

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });
        setFocusable(true);
        new Thread(() -> {
            while (true) {
                updateMoves();
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }).start();
    }

    private int calculateBounceAngle(Player player, Ball ball) {
        int playerCenter = player.y + player.height / 2;
        int ballCenter = ball.y + ball.height / 2;
        return (ballCenter - playerCenter) / 5; // Ajusta el divisor según lo necesites
    }

    public void updateMoves() {
        PL.move(PL, W, S, SPEED);
        PR.move(PR, Up, Do, SPEED);
        if (PL.intersects(BALL)) {
            BALL.dx = Math.abs(BALL.dx);
            BALL.dy += calculateBounceAngle(PL, BALL);
        }
        if (PR.intersects(BALL)) {
            BALL.dx = -Math.abs(BALL.dx);
            BALL.dy += calculateBounceAngle(PR, BALL);
        }
        if (WALL_L.intersects(BALL)) {
            BALL.x = 442;
            BALL.y = 331;
            BALL.dx = 3;
            BALL.dy = -3;
            SR++;
        }
        if (WALL_R.intersects(BALL)) {
            BALL.x = 442;
            BALL.y = 331;
            BALL.dx = 3;
            BALL.dy = -3;
            SL++;
        }
        scoreL.setText("SCORE P1: " + SL);
        scoreR.setText("SCORE P2: " + SR);
        BALL.move(getWidth(), getHeight());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        BALL.draw(g);
        PL.draw(g);
        PR.draw(g);
    }
}