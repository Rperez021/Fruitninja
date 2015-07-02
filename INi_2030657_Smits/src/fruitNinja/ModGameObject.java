package fruitNinja;

public class ModGameObject {

	private String soort;
	private int size;
	private int x;
	private int y;
	
	public ModGameObject(String soort, int size, int x, int y){
		this.soort = soort;
		this.size = size;
		this.x = x;
		this.y = y;
	}
	
	public String getSoort(){
		return soort;	
	}
	
	public int getSize(){
		return size;		
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
