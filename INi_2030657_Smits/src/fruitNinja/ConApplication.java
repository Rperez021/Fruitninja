package fruitNinja;

import java.awt.Dimension;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ConApplication extends JFrame{

	private ModPlayingField m_PlayingField;
	private ModPlayer m_Player;
	private ModSlashTrailSection m_Section;
	
	private ConMouseController c_Mouse;
	
	private ViewContentPane v_ContentPane;
	private ViewGameOverPanel v_GameOver;
	
	//maakt het spel aan
	public ConApplication(){
		m_Player = new ModPlayer();
		c_Mouse = new ConMouseController();
		m_PlayingField = new ModPlayingField(m_Player);
		m_Section = new ModSlashTrailSection(this, c_Mouse, m_PlayingField);
		v_ContentPane = new ViewContentPane(this, m_PlayingField, m_Player, c_Mouse, m_Section);
		this.setTitle("Fruit Ninja");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(v_ContentPane);
		
		this.pack();
		this.setVisible(true);		
		run();
	}
	
	//speelt de muziek
	public void run(){
		playSound("game_music.wav", true);
		while (true)
		{

		}
	}
	
	//zoekt de muziek
	public void playSound(String filename, boolean shouldLoop)
	{
		try
		{
			URI threesURI = null;
			try
			{
				URL threesURL = this.getClass().getResource(
						"/music/" + filename);
				threesURI = threesURL.toURI();
			} catch (URISyntaxException ex)
			{
				ex.printStackTrace();
			}
			if (threesURI != null)
			{
				File f = new File(threesURI);
				AudioInputStream audioInputStream = AudioSystem
						.getAudioInputStream(f.getAbsoluteFile());
				Clip clip = AudioSystem.getClip();

				clip.open(audioInputStream);
				if (shouldLoop)
				{
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				} else
				{
					clip.start();
				}
			}
		} catch (Exception ex)
		{
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	public void gameOver(){
		this.setTitle("Game Over YEAHH!!");
		v_GameOver = new ViewGameOverPanel(m_Player.getScore());
		v_GameOver.requestFocus();
		v_GameOver.setBounds(10, 10, 10, 10);
		this.add(v_GameOver);
		this.setComponentZOrder(v_GameOver, 0);
	}

}
