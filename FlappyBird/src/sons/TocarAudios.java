package sons;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import java.io.File;

public class TocarAudios {
  
  public void tocarAudio(String caminhoArquivo) {
    try {
        // Carrega o arquivo de áudio
        File arquivo = new File(caminhoArquivo);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);

        // Cria o Clip e abre o áudio
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        // Toca o áudio
        clip.start();

        // Espera o áudio terminar
        clip.drain();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
