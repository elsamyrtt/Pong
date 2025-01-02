package com.pong;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel{
    //Player Left && Player Right
    Player PL = new Player();
    Player PR = new Player(900 - 35,350);

    public Panel(){
        setBackground(Color.decode("#292929"));
    }

    //dibujando graficos
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(PL.x, PL.y, PL.WIDTH, PL.HEIGHT);
        g.fillRect(PR.x, PR.y, PR.WIDTH, PR.HEIGHT);
    }

}