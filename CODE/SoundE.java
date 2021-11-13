package sample;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class SoundE {

    protected static final String AudioPlayer = null;

    public Clip PACS = loadClip("/MUSIC/beginning.wav");
    public Clip Pacm = loadClip("/MUSIC/STEP.wav");
    public Clip PACg = loadClip("/MUSIC/EATGHOST.wav");
    public Clip DEATH = loadClip("/MUSIC/DEATH.wav");

    public SoundE() {

    }

    public Clip loadClip(String filename) {
        Clip music = null;

        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(filename));
            music = AudioSystem.getClip();
            music.open(audioIn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (music);

    }


    public void MusicS(int index) {

        if (index == 1) {
            Stop(1);
            PACS.start();
        } else if (index == 2) {
            if (!Pacm.isRunning()) {
                Stop(2);
                Pacm.start();
            }
        } else if (index == 3) {
            if (!PACg.isRunning()) {
                Stop(3);
                PACg.start();
            }
            PACg.setFramePosition(0);
        } else if (index == 4) {
            if (!DEATH.isRunning()) {
                DEATH.start();
            }
            DEATH.setFramePosition(0);

        }

    }


    public void Stop(int index) {
        if (index == 1) {
            if (PACS.isRunning())
                PACS.stop();
            PACS.setFramePosition(0);
        } else if (index == 2) {
            if (Pacm.isRunning())
                Pacm.stop();
            Pacm.setFramePosition(0);
        }
    }
}
