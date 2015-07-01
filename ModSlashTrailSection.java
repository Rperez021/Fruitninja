package fruitNinja;

import java.awt.Rectangle;
import java.awt.geom.Line2D;

public class ModSlashTrailSection {
		
	private	ConMouseController c_mouseController;
	private ModPlayingField m_PlayingField;
	
	public ModSlashTrailSection(ConMouseController c_mouseController, ModPlayingField m_PlayingField){
		this.c_mouseController = c_mouseController;
		this.m_PlayingField = m_PlayingField;
	}
	
	public boolean hit(){
		ModGameObject object = m_PlayingField.getObject();
		if (this.c_mouseController.getxStart() != this.c_mouseController.getxEnd() ){
			Rectangle rec = new Rectangle(object.getX(), object.getY(), object.getSize(), object.getSize());
			Line2D line = new Line2D.Float(this.c_mouseController.getxStart(), this.c_mouseController.getyStart(), this.c_mouseController.getxEnd(), this.c_mouseController.getyEnd());
			if(line.intersects(rec)){
				return true;
			}
		}
		return false;
	}
}
