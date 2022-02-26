import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.*;
public class Zvocnik{
	
private Clip trk;
private Clip odboj;
private Clip konec;
public Zvocnik(){
	
try{
	AudioInputStream aisTrk = AudioSystem.getAudioInputStream(getClass().getResource("impact.wav"));

	trk = AudioSystem.getClip();

	trk.open(aisTrk);
	AudioInputStream aisOdboj = AudioSystem.getAudioInputStream(getClass().getResource("bounce.wav"));
odboj=AudioSystem.getClip();
odboj.open(aisOdboj);
AudioInputStream aisKonec=AudioSystem.getAudioInputStream(getClass().getResource("gameOver.wav"));
konec=AudioSystem.getClip();
konec.open(aisKonec);
}catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {

	e.printStackTrace();
}
}
public void trk(){
trk.setFramePosition(0);
trk.start();
}
public void odboj(){
	odboj.stop();
	odboj.flush();
  odboj.setFramePosition(0);
  odboj.start();
}
public void konec(){
	konec.stop();
	konec.flush();
  konec.setFramePosition(0);
  konec.start();
}
}

