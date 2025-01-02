package com.pong;

import java.awt.Rectangle;

public class Player extends Rectangle{

    int WIDTH = 20,HEIGHT = 150,x = 0,y = 350;

    public Player(){
        setRect(x,y, WIDTH, HEIGHT);
    }

    public Player(int x, int y){
        this.x = x;
        this.y = y;
        setRect(x,y, WIDTH, HEIGHT);
    }

}
