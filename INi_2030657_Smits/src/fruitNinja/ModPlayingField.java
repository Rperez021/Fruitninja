package fruitNinja;

public class ModPlayingField {

	private ModPlayer m_Player;
	private ModGameObject object;

	private boolean thrown = false;
	
	public ModPlayingField(ModPlayer m_Player) {
		this.m_Player = m_Player;
		object = new ModGameObject(null, 0, 0, 0);
		object.fillArray();
	}
	
	public void setScore(int score){
		m_Player.setScore(m_Player.getScore() + score);
	}
	
	public void bombHit(){
		m_Player.setLives(m_Player.getLives() - 1);
	}
	
	public void throwObject(){
		object = object.getRandom();
		int random = (int) (Math.random() * 4);
		int randomxy = (int) (Math.random() * 490 - 10) + 10;
		//fruit bovenin
		if(random == 0){
			object.setX(randomxy);
			object.setY(500);
			while(object.getY() > (0 + object.getSize())){
				object.setY(object.getY() - 2);
				System.out.println(object.getX() + " " + object.getY() + " boven " + object.getSoort());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("Something went wrong");
				}
				thrown = true;
			}
		}
		//fruit links
		else if(random == 1){
			object.setY(randomxy);
			object.setX(500);
			while(object.getX() > (0 + object.getSize())){
				object.setX(object.getX() - 2);
				System.out.println(object.getX() + " " + object.getY() + " links " + object.getSoort());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("Something went wrong");
				}
				thrown = true;
			}
		}
		//fruit beneden
		else if(random == 2){
			object.setX(randomxy);
			object.setY(0);
			while(object.getY() < (500 - object.getSize())){
				object.setY(object.getY() + 2);
				System.out.println(object.getX() + " " + object.getY() + " beneden "+ object.getSoort());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("Something went wrong");
				}
				thrown = true;
			}
		}
		//fruit rechts
		else if(random == 3){
			object.setY(randomxy);
			object.setX(0);
			while(object.getX() < (500 - object.getSize())){
				object.setX(object.getX() + 2);
				System.out.println(object.getX() + " " + object.getY() + " rechts " + object.getSoort());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println("Something went wrong");
				}
				thrown = true;
			}
		}
	}

	public boolean getThrown() {
		return thrown;
	}

	public void setThrown(boolean thrown) {
		this.thrown = thrown;
	}
	
	public ModGameObject getObject() {
		return object;
	}
	
}
