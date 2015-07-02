package fruitNinja;

import java.util.ArrayList;

public class ModPlayingField {

	private ModPlayer m_Player;
	private ModGameObject object;
	private ArrayList<ModGameObject> objectArray;
	private int random;
	
	public ModPlayingField(ModPlayer m_Player) {
		this.m_Player = m_Player;
		objectArray = new ArrayList<ModGameObject>();
		objectArray.add(new ModFruit("apple", 50, 0, 0));
		objectArray.add(new ModFruit("orange", 50, 0, 0));
		objectArray.add(new ModFruit("strawberry", 30, 0, 0));
		objectArray.add(new ModBomb("bomb", 50, 0, 0));
	}
	
	public void setScore(int score){
		m_Player.setScore(m_Player.getScore() + score);
	}
	
	public void bombHit(){
		m_Player.setLives(m_Player.getLives() - 1);
	}
	
	public int getLives(){
		return m_Player.getLives();
	}
	
	public void throwObject(){
		this.object = objectArray.get((int) (Math.random() * 4));
		this.random = (int) (Math.random() * 4);
		int randomxy = (int) (Math.random() * 500 - object.getSize()) + object.getSize();
		//fruit bovenin
		if(random == 0){
			object.setX(randomxy);
			object.setY(500);
		}
		//fruit links
		else if(random == 1){
			object.setY(randomxy);
			object.setX(500);
		}
		//fruit beneden
		else if(random == 2){
			object.setX(randomxy);
			object.setY(0);
		}
		//fruit rechts
		else if(random == 3){
			object.setY(randomxy);
			object.setX(0);
		}
	}
	
	public void update(){
		if(this.random == 0){
			if(this.object.getY() <= 0){
				this.throwObject();
			} else {
				this.object.setY(object.getY() - 2);
				//System.out.println(object.getX() + " " + object.getY() + " boven " + object.getSoort());
			}
		}
		if(this.random == 1){
			if(this.object.getX() <= 0){
				this.throwObject();
			} else {
				this.object.setX(object.getX() - 2);
				//System.out.println(object.getX() + " " + object.getY() + " links " + object.getSoort());
			}
		}
		if(this.random == 2){
			if(this.object.getY() >= 500){
				this.throwObject();
			} else {
				this.object.setY(object.getY() + 2);
				//System.out.println(object.getX() + " " + object.getY() + " beneden "+ object.getSoort());
			}
		}
		if(this.random == 3){
			if(this.object.getX() >= 500){
				this.throwObject();
			} else {
				this.object.setX(object.getX() + 2);
				//System.out.println(object.getX() + " " + object.getY() + " rechts " + object.getSoort());
			}
		}
	}
	
	public int getRandom() {
		return random;
	}

	public ModGameObject getObject() {
		return object;
	}
	
}
