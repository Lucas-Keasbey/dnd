package Player;

public abstract class PlayerClass {
	protected int level;
	protected boolean[] saveProf= {false, false, false, false, false, false};
	
	public PlayerClass() {
		this(1);
	}
	
	public PlayerClass(int level) {
		this.level = level;
	}
	
	public int getProf() {
		if (level<5)
			return 2;
		else if (level<9)
			return 3;
		else if (level<13)
			return 4;
		else if (level<17)
			return 5;
		return 6;
	}
	
	public abstract String getFeatures();

}
