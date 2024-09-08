package jogo;

import tela.TamanhoTela;
import java.awt.*;

public class Passaro {
  private int x;
  private int y;
  private int comprimento;
  private int altura;
  private Image img;
  private int velocidadeY = -6;
  private int gravidade = 1;
  
  Passaro(Image img) {
    this.img = img;
    x = TamanhoTela.getCOMPRIMENTO()/8;
    y = TamanhoTela.getALTURA()/2;
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
}
