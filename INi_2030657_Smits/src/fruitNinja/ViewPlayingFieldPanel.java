package fruitNinja;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ViewPlayingFieldPanel extends JPanel implements ActionListener{
	
	private Timer timer = new Timer(1, this);
	private ModPlayingField m_PlayingField;
	private Font f = new Font("SansSerif", Font.BOLD, 20);
	private Image img;
	private Image fruit;
	private int x;
	private int y;

	public ViewPlayingFieldPanel(ModPlayingField m_PlayingField) {
		this.m_PlayingField = m_PlayingField;
		timer.start();
		this.setPreferredSize(new Dimension(500, 500));
		try {
			this.img = ImageIO.read(ClassLoader.getSystemResource("images/background.png"));
		} catch (IOException e) {
			System.out.println("kan image niet vinden");
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
		if(m_PlayingField.getThrown() == false){
			m_PlayingField.getObject().fillArray();
			m_PlayingField.throwObject();
			try {
				 this.fruit = ImageIO.read(ClassLoader.getSystemResource("images/" + m_PlayingField.getObject().getSoort() + ".png"));
			} catch (IOException e) {
				System.out.println("kan image niet vinden");
			}
			g.drawImage(fruit, this.x, this.y, null);
		}	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==timer){
			this.x = m_PlayingField.getObject().getX();
			this.y = m_PlayingField.getObject().getY();
			this.repaint();
		}
		
	}

}
