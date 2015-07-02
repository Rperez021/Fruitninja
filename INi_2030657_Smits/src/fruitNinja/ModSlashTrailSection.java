package fruitNinja;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ModSlashTrailSection {

	private boolean gameover = false;
	private ConMouseController mouse;
	private ModPlayingField m_PlayingField;
	private ConApplication c_Application;

	public ModSlashTrailSection(ConApplication c_Application, ConMouseController mouse, ModPlayingField m_PlayingField) {
		this.mouse = mouse;
		this.m_PlayingField = m_PlayingField;
		this.c_Application = c_Application;
	}

	public boolean hit() {
		ModGameObject object = m_PlayingField.getObject();
		if (this.mouse.getxStart() != this.mouse.getxEnd()) {
			Rectangle rec = new Rectangle(object.getX(), object.getY(), object.getSize(), object.getSize());
			Line2D line = new Line2D.Float(this.mouse.getxStart(), this.mouse.getyStart(), this.mouse.getxEnd(),
					this.mouse.getyEnd());
			if (line.intersects(rec)) {
				return true;
			}
		}
		return false;
	}

	public void checkhit() {

		if (this.mouse.getxStart() != 0 && this.mouse.getyEnd() != 0) {
			if (this.mouse.getxStart() != this.mouse.getxEnd() || this.mouse.getyStart() != this.mouse.getyEnd()) {
				if (this.hit()) {
					if (this.m_PlayingField.getRandom() == 0) {
						this.m_PlayingField.getObject().setY(0);
					}
					if (this.m_PlayingField.getRandom() == 1) {
						this.m_PlayingField.getObject().setX(0);
					}
					if (this.m_PlayingField.getRandom() == 2) {
						this.m_PlayingField.getObject().setY(500);
					}
					if (this.m_PlayingField.getRandom() == 3) {
						this.m_PlayingField.getObject().setX(500);
					}
					if (!this.m_PlayingField.getObject().getSoort().equals("bomb")) {
						if (!this.m_PlayingField.getObject().getSoort().equals("strawberry")) {
							this.m_PlayingField.setScore(50);
						} else {
							this.m_PlayingField.setScore(100);
						}
					} else {
						this.m_PlayingField.bombHit();
						if (this.m_PlayingField.getLives() == 0) {
							this.gameover = true;
							this.c_Application.gameOver();
						}
					}

				}
				this.playSound();
			}
			mouse.setxStart(0);
			mouse.setxEnd(0);
			mouse.setyStart(0);
			mouse.setyEnd(0);
		}
	}

	private void playSound() {
		try {
			URI musicURI = null;
			try {
				URL musicURL = this.getClass().getResource("/music/slash.wav");
				musicURI = musicURL.toURI();
			} catch (URISyntaxException ex) {
				ex.printStackTrace();
			}
			if (musicURI != null) {
				File f = new File(musicURI);
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
				Clip clip = AudioSystem.getClip();

				clip.open(audioInputStream);
				clip.start();
			}
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	public boolean isGameover() {
		return gameover;
	}

}
