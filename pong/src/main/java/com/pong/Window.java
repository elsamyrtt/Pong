package com.pong;

import javax.swing.JFrame;

public class Window extends JFrame {
    // iniciamos el Panel
    Panel PANEL = new Panel();

    public Window() {
        setTitle("Pong");
        setSize(900, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(PANEL);
    }

}
