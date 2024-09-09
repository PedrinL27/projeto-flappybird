package jogo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tela.TamanhoTela;

public class GameOver implements KeyListener {
    private boolean gameOver;

    GameOver() {
        gameOver = false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(gameOver) {
            Passaro.getPassaro().setY(TamanhoTela.getALTURA()/2);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
