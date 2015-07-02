package fruitNinja;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewGameOverPanel extends JPanel{
	
		private int score;
		private JLabel label;
	
		public ViewGameOverPanel(int score){
			this.score = score;
			label = new JLabel();
			label.setSize(new Dimension(500, 500));
			label.setText("GAME OVERR");
			label.setVisible(true);
			this.setPreferredSize(new Dimension(500, 500));
			this.setBackground(Color.GRAY);
			this.setVisible(true);
			
		}
	

}
