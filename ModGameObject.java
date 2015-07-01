package fruitNinja;

import java.util.ArrayList;
import java.util.List;

public class ModGameObject {

	private String soort;
	private int size;
	private int x;
	private int y;
	private List<ModGameObject> objectArray;
	
	public ModGameObject(String Soort, int size, int x, int y){
	}
	
	public String getSoort(){
		return soort;	
	}
	
	public int getSize(){
		return size;		
	}
	
	//vul de array met objecten
	public void fillArray(){
		objectArray = new ArrayList<ModGameObject>();
		objectArray.add(new ModFruit("apple", 50, 0, 0));
		objectArray.add(new ModFruit("orange", 50, 0, 0));
		objectArray.add(new ModFruit("strawberry", 30, 0, 0));
		objectArray.add(new ModBomb("bomb", 50, 0, 0));
	}
	
	//pak een random object
	public ModGameObject getRandom(){
		int random = (int) (Math.random() * (4));
		return objectArray.get(random);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
