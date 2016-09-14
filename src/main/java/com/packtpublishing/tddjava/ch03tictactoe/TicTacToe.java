package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by dsarmiento on 12/09/2016.
 */
public class TicTacToe {
    private Character[][] board = {{'\0', '\0', '\0'},
            {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};

    private char lastPlayer = '\0';
    private static final int SIZE = 3;
    public String play(int x ,int y)
    {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox( x, y,lastPlayer);

        if(isWin(x, y ))
            return    lastPlayer + " is the winner";
        else if (isDraw()) {
            return "The result is draw";
        }
        else
            return "No winner";

    }
    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isWin(int x , int y)
    {
        int playerTotal = lastPlayer * SIZE;
        char  horizontal = '\0', vertical = '\0';
        char diagonalTopBottom = '\0',diagonalBottomTop='\0';


        for (int i = 0; i < SIZE; i++) {
            horizontal += board[i][y - 1];
            vertical += board[x - 1][i];
            diagonalTopBottom += board[i][i] ;
            diagonalBottomTop += board[i][SIZE-i-1] ;

        }

        if (horizontal == playerTotal ||
            vertical == playerTotal ||
            diagonalTopBottom == playerTotal ||
            diagonalBottomTop == playerTotal)
        {
            return true;
        }

        return false;

    }

    public void checkAxis(int axis)
    {
        if(axis < 1 || axis > 3)
            throw new RuntimeException("X is outside board");
    }
    public void setBox(int x,int y, char lastPlayer)
    {
        if(board[x - 1][y - 1] != '\0')
            throw new RuntimeException("Box is occupied");
        else
            board[x - 1][y - 1] = lastPlayer;
    }
    public char nextPlayer()
    {
        if(lastPlayer=='X')
            lastPlayer = 'O';
        else
            lastPlayer = 'X';

        return lastPlayer;
    }

}
