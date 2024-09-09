package jogo;

import tela.TamanhoTela;

public class GameOver {
    private static GameOver instancia;
    private boolean gameOver;    

  GameOver() {
    gameOver = false;
  }

  public static GameOver getInstancia() {
    if (instancia == null) {
        instancia = new GameOver();
    }
    return instancia;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public void setGameOver(boolean gameOver) {
    this.gameOver = gameOver;
  }

  public void resetarJogo() {
    Passaro.getPassaro().setY(TamanhoTela.getALTURA()/2);
    Passaro.getPassaro().setVelocidadeY(0);
    Cano.getInstacia().clear();
    FlappyBird.getInstancia().pontuacao = 0;
    GameOver.getInstancia().setGameOver(false);
    FlappyBird.getInstancia().gameLoop.start();
    FlappyBird.getInstancia().colocarCanosTimer.start();
    }
}
