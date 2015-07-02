package fruitNinja;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class ViewPlayerPanel extends JPanel implements ActionListener {

		private ModPlayer m_Player;
		private Font f = new Font("SansSerif", Font.BOLD, 20);
		private Font f1 = new Font("SansSerif",Font.PLAIN , 12);
		private Font f2 = new Font("SansSerif", Font.BOLD, 15);
		private Timer timer = new Timer(1, this);
		
		public ViewPlayerPanel(ModPlayer m_Player) {
				this.m_Player = m_Player;
				this.setPreferredSize(new Dimension(500, 70));
				this.setBackground(Color.GRAY);	
				timer.start();	
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			FontMetrics fontMetrics1 = g.getFontMetrics(f2);
			FontMetrics fontMetrics2 = g.getFontMetrics(f);
			FontMetrics fontMetrics3 = g.getFontMetrics(f1);
			
			g.setColor(Color.WHITE);
			g.setFont(f2);
			int titleLen1 = fontMetrics1.stringWidth("Lives: " + m_Player.getLives());
			g.drawString("Lives: " + m_Player.getLives(), (500/2) - (titleLen1/2), 20);
			
			g.setColor(Color.YELLOW);
			g.setFont(f);
			int titleLen2 = fontMetrics2.stringWidth("Score: " + m_Player.getScore());
			g.drawString("Score: " + m_Player.getScore(), (500/2) - (titleLen2/2), 40);
			
			g.setColor(Color.GREEN);
			g.setFont(f1);
			int titleLen3 = fontMetrics3.stringWidth("Gertjan Smits 2030657");
			g.drawString("Gertjan Smits 2030657", (500/2) - (titleLen3/2), 60);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==timer){
				this.repaint();
			}
			
		}

}
