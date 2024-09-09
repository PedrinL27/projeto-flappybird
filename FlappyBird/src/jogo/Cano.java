package jogo;

import java.awt.*;
import java.util.Random;

import tela.TamanhoTela;

public class Cano {
  private int x;
  private int y;
  private int comprimento;
  private int altura;
  private Image img;
  private boolean passou;
  private int velocidadeX = -4;
  private Random random = new Random();

  Cano(Image img) {
    this.img = img;
    x = TamanhoTela.getCOMPRIMENTO();
    y = 0;
    comprimento = 64;
    altura = 512;
    passou = false;
  }

  public void movimentarHorizontal() {
    x += velocidadeX;
  }

  public int canoAleatorioY() {
    int aleatorio;
    return aleatorio = (int) (y - altura / 4 - Math.random() * (altura / 2));
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

  public void isPassou(boolean passou) {
    this.passou = passou;
  }

  public boolean getPassou() {
    return passou;

  }
}
