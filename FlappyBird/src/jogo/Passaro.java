package jogo;

import tela.TamanhoTela;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Passaro implements KeyListener {
  private static Passaro instancia;
  private int x;
  private int y;
  private int comprimento;
  private int altura;
  private Image img;
  private int velocidadeY;
  private double gravidade = 1;

  public static Passaro getPassaro() {
    if (instancia == null) {
      instancia = new Passaro();
    }
    return instancia;
  }

  Passaro() {
    img = new ImageIcon(getClass().getResource("/graficos/flappybird.png")).getImage();
    x = TamanhoTela.getCOMPRIMENTO() / 8;
    y = TamanhoTela.getALTURA() / 2;
    comprimento = 34;
    altura = 24;
  }

  public void movimento() {
    velocidadeY += gravidade;
    y += velocidadeY;
    y = Math.max(y, 0);
  }

  public int getX() {
    return x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getY() {
    return y;
  }

  public int getComprimento() {
    return comprimento;
  }

  public int getAltura() {
    return altura;
  }

  public Image getImg() {
    return img;
  }

  public void setVelocidadeY(int velocidadeY) {
    this.velocidadeY = velocidadeY;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      velocidadeY = -10;
      if (GameOver.getInstancia().isGameOver())
        GameOver.getInstancia().resetarJogo();
    }

  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }
}
