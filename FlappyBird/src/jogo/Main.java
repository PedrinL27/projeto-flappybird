package jogo;

import javax.swing.*;
import tela.TamanhoTela;

public class Main {
  public static void main(String[] args) throws Exception {

    JFrame tela = new JFrame("Flappy Bird");
    tela.setSize(TamanhoTela.getCOMPRIMENTO(), TamanhoTela.getALTURA());
    tela.setLocationRelativeTo(null);
    tela.setResizable(false);
    tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    tela.add(FlappyBird.getInstancia());
    tela.pack();
    FlappyBird.getInstancia().requestFocus();
    tela.setVisible(true);
  }
}
