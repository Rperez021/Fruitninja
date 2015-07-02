package fruitNinja;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class ViewPlayingFieldPanel extends JPanel implements ActionListener{
	
	private Timer timer = new Timer(1, this);
	private ModPlayingField m_PlayingField;
	private Image img;
	private Image fruit;
	private ConMouseController mouse;
	private ModSlashTrailSection section;

	public ViewPlayingFieldPanel(ModPlayingField m_PlayingField, ConMouseController mouse, ModSlashTrailSection section) {
		this.m_PlayingField = m_PlayingField;
		this.mouse = mouse;
		this.section = section;
		this.addMouseListener(mouse);
		m_PlayingField.throwObject();
		try {
			this.img = ImageIO.read(ClassLoader.getSystemResource("images/background.png"));
		} catch (IOException e) {
			System.out.println("kan image niet vinden");
		}
		this.setPreferredSize(new Dimension(500, 500));
		timer.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
		try {
			this.fruit = ImageIO.read(ClassLoader.getSystemResource("images/" + m_PlayingField.getObject().getSoort() + ".png"));
		} catch (IOException e) {
			System.out.println("kan image niet vinden");
		}
		g.drawImage(fruit, this.m_PlayingField.getObject().getX(), this.m_PlayingField.getObject().getY(), null);
	}	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!this.section.isGameover()){
			if(e.getSource()==timer){
				this.section.checkhit();
				this.m_PlayingField.update();
				this.repaint();
			}
		}
		
	}

}
