package fruitNinja;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ViewContentPane extends JPanel {
	
	private ViewPlayingFieldPanel myPlayingFieldPanel;
	private ViewPlayerPanel myPlayerPanel;

	public ViewContentPane(ConApplication conApplication, ModPlayingField m_PlayingField, ModPlayer m_Player) {
		// TODO Auto-generated constructor stub
		myPlayingFieldPanel = new ViewPlayingFieldPanel(m_PlayingField);
		myPlayerPanel = new ViewPlayerPanel(m_Player);
		
		this.setLayout(new BorderLayout());
		this.add(myPlayingFieldPanel, BorderLayout.CENTER);
		this.add(myPlayerPanel, BorderLayout.NORTH);
	}

}
