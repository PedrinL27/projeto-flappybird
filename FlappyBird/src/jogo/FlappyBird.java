package jogo;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import tela.TamanhoTela;

public class FlappyBird extends JPanel implements ActionListener{
  //Imagens do jogo
  Image fundoTela;
  Image flappyBird;
  Image canoSuperior;
  Image canoInferior;

  //Logica do jogo
  Passaro passaro;
  Timer gameLoop;

  FlappyBird() {
    setPreferredSize(new Dimension(TamanhoTela.getCOMPRIMENTO(), TamanhoTela.getALTURA()));
    //Carregando as texturas do jogo
    fundoTela = new ImageIcon(getClass().getResource("/graficos/flappybirdbg.png")).getImage();
    flappyBird = new ImageIcon(getClass().getResource("/graficos/flappybird.png")).getImage();
    canoSuperior = new ImageIcon(getClass().getResource("/graficos/toppipe.png")).getImage();
    canoInferior = new ImageIcon(getClass().getResource("/graficos/bottompipe.png")).getImage();

    //Criando um novo passaro
    passaro = new Passaro(flappyBird);

    //Criando um loop de jogo
    gameLoop = new Timer(1000/60, this);
    gameLoop.start();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    desenhar(g);
  }

  public void desenhar(Graphics g) {  
    //Fundo da tela
    g.drawImage(fundoTela, 0, 0, TamanhoTela.getCOMPRIMENTO(), TamanhoTela.getALTURA(), null);

    //Desenhando o passaro na tela
    g.drawImage(passaro.getImg(), passaro.getX(), passaro.getY(), passaro.getComprimento(), passaro.getAltura(), null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    passaro.movimento();
    repaint();
  }

}

  
