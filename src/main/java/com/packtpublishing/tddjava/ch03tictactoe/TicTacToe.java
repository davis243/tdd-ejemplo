package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by dsarmiento on 12/09/2016.
 */
public class TicTacToe {
    public void play(int x ,int y)
    {
        if(x < 1 || x > 3)
            throw new RuntimeException("X is outside board");
        if(y < 1 || y > 3)
            throw new RuntimeException("Y is outside board");
    }
}
