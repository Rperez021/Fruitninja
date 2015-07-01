package fruitNinja;

import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

public class ConMouseController extends MouseAdapter{

	private int xStart;
	private int xEnd;
	private int yStart;
	public int getxStart() {
		return xStart;
	}

	public int getxEnd() {
		return xEnd;
	}

	public int getyStart() {
		return yStart;
	}

	public int getyEnd() {
		return yEnd;
	}

	private int yEnd;
	
	//start slash
	public void mousePressed(MouseEvent e){
		Point point = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(point, (Component) e.getSource());
		this.xStart = (int) point.getX();
		this.yStart = (int) point.getY();
	}
	
	//eind slash
	public void mouseReleased(MouseEvent e){
		Point point = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(point, (Component) e.getSource());
		this.xEnd = (int) point.getX();
		this.yEnd = (int) point.getY();
	}

}
