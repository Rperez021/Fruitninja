package fruitNinja;

public class ModPlayer {
	
	private int lives;
	private int score;
	
	public ModPlayer(){
		this.setLives(3);
		this.setScore(0);
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	

}
