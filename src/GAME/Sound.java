package GAME;


import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;



public class Sound {

    public int Sound_off=0;
    private Clip clip;

    public static Sound sound1 = new Sound("sounds/pacman_beginning.wav");

    public static Sound sound2 = new Sound("sounds/pacman_chomp.wav");

    public static Sound sound3 = new Sound("sounds/pacman_death.wav");


    public Sound(String fileName) {

        try {

            AudioInputStream ais = AudioSystem.getAudioInputStream(Sound.class.getResource(fileName));
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    public void play() {

        if(Sound_off==0) {
            try {
                if (clip != null) {
                    new Thread() {
                        public void run() {
                            synchronized (clip) {
                                clip.stop();
                                clip.setFramePosition(0);
                                clip.start();
                            }
                        }
                    }.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public void stop() {
        if (clip == null) return;
        clip.stop();
    }


    public void loop() {
        if(Sound_off==0) {
            try {
                if (clip != null) {
                    new Thread() {
                        public void run() {
                            synchronized (clip) {
                                clip.stop();
                                clip.setFramePosition(0);
                                clip.loop(Clip.LOOP_CONTINUOUSLY);
                            }
                        }
                    }.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public boolean isActive() {
        return clip.isActive();
    }
}
