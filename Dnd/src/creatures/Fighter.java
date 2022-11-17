package creatures;

public class Fighter extends PlayerClass {
	
	public Fighter() {
		this(1);
	}
	
	public Fighter(int lvl) {
		super(lvl);
		saveProf[0] = true;
		saveProf[2] = true;
	}

	@Override
	public String getFeatures() {
		String features = "--fighter features--";
		return features;
	}

	@Override
	public String toString() {
		return "Fighter " + level;
	}

}
