package jogo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sons.TocarAudios;
import tela.TamanhoTela;

public class FlappyBird extends JPanel implements ActionListener {
  private static FlappyBird instancia;
  // Imagens do jogo
  Image fundoTela;
  Image flappyBird;
  Image canoSuperiorImg;
  Image canoInferiorImg;

  Timer gameLoop;
  Timer colocarCanosTimer;

  // Sons
  TocarAudios somPulo = new TocarAudios();
  private TocarAudios somColisao;
  private TocarAudios somPontuacao;

  double pontuacao = 0;

  public static FlappyBird getInstancia() {
    if (instancia == null) {
      instancia = new FlappyBird();
    }
    return instancia;
  }

  FlappyBird() {
    setPreferredSize(new Dimension(TamanhoTela.getCOMPRIMENTO(), TamanhoTela.getALTURA()));
    setFocusable(true);
    somPulo.tocarAudio("sons/flappy.wav");
    // Carregando as texturas do jogo
    fundoTela = new ImageIcon(getClass().getResource("/graficos/flappybirdbg.png")).getImage();
    flappyBird = new ImageIcon(getClass().getResource("/graficos/flappybird.png")).getImage();
    canoSuperiorImg = new ImageIcon(getClass().getResource("/graficos/toppipe.png")).getImage();
    canoInferiorImg = new ImageIcon(getClass().getResource("/graficos/bottompipe.png")).getImage();


    // Criando um novo passaro
    addKeyListener(Passaro.getPassaro());

    // Tempo de aparecimento dos canos
    colocarCanosTimer = new Timer(1500, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        colocarCanos();
      }
    });

    // Criando um loop de jogo
    gameLoop = new Timer(1000 / 60, this);
    gameLoop.start();
    colocarCanosTimer.start();
  }

  public void colocarCanos() {
    int abertura = TamanhoTela.getALTURA() / 4;

    Cano canoSuperior = new Cano(canoSuperiorImg);
    canoSuperior.setY(canoSuperior.canoAleatorioY());
    Cano.getInstacia().add(canoSuperior);

    Cano canoInferior = new Cano(canoInferiorImg);
    canoInferior.setY(canoSuperior.getY() + canoInferior.getAltura() + abertura);
    Cano.getInstacia().add(canoInferior);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    desenhar(g);
  }

  public void desenhar(Graphics g) {
    // Fundo da tela
    g.drawImage(fundoTela, 0, 0, TamanhoTela.getCOMPRIMENTO(), TamanhoTela.getALTURA(), null);

    // Desenhando o passaro na tela
    g.drawImage(Passaro.getPassaro().getImg(), Passaro.getPassaro().getX(), Passaro.getPassaro().getY(),
        Passaro.getPassaro().getComprimento(), Passaro.getPassaro().getAltura(), null);

    // Desenhando os canos na tela
    for (int i = 0; i < Cano.getInstacia().size(); i++) {
      Cano cano = Cano.getInstacia().get(i);
      g.drawImage(cano.getImg(), cano.getX(), cano.getY(), cano.getComprimento(), cano.getAltura(), null);
    }

    // Desenhando a pontuação na tela
    g.setColor(Color.white);
    g.setFont(new Font("Arial", Font.PLAIN, 32));
    if (GameOver.getInstancia().isGameOver()) {
      g.drawString("Fim de Jogo: " + String.valueOf((int) pontuacao), 10, 35);
    } else {
      g.drawString(String.valueOf((int) pontuacao), 10, 35);
    }
  }

  public void movimento() {
    for (int i = 0; i < Cano.getInstacia().size(); i++) {
      Cano cano = Cano.getInstacia().get(i);
      cano.movimentarHorizontal();

      if (!cano.getPassou() && Passaro.getPassaro().getX() > cano.getX() + cano.getComprimento()) {
        cano.isPassou(true);
        pontuacao += 0.5;

      }

      if (colisao(Passaro.getPassaro(), cano)) {
        GameOver.getInstancia().setGameOver(true);
      }

      if (Passaro.getPassaro().getY() > TamanhoTela.getALTURA()) {
        GameOver.getInstancia().setGameOver(true);
      }
    }
  }

  public boolean colisao(Passaro a, Cano b) {
    return a.getX() < b.getX() + b.getComprimento() &&
        a.getX() + a.getComprimento() > b.getX() &&
        a.getY() < b.getY() + b.getAltura() &&
        a.getY() + a.getAltura() > b.getY();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Passaro.getPassaro().movimento();
    movimento();
    repaint();
    if (Passaro.getPassaro().getVelocidadeY() == -10) {
      somPulo.tocarAudio("sons/flappy.wav");
    }
    if (GameOver.getInstancia().isGameOver()) {
      colocarCanosTimer.stop();
      gameLoop.stop();
    }
  }
}
