package com.pong;

import javax.swing.JFrame;

public class Window extends JFrame {
    Panel PANEL = new Panel();

    public Window() {
        setTitle("Pong");
        setSize(900, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(PANEL);
        setVisible(true);
    }

}
