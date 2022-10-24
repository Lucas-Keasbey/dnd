package Player;

public abstract class Creature {
	protected int[] stats = new int[6];
	
	public Creature() {
		this(10,10,10,10,10,10);
	}
	
	public Creature(int str, int dex, int con, int inte, int wis, int cha) {
		stats[0] = str;
		stats[1] = dex;
		stats[2] = con;
		stats[3] = inte;
		stats[4] = wis;
		stats[5] = cha;
	}
	
	public int[] getStats() {
		return stats;
	}
	
	public void setStats(int[] i) {
		this.stats = i;
	}
	
	protected int getMod(int statIndex) {
		int mod = stats[statIndex]/2 -5;
		return mod;
	}
	
	public int rollD(int i) {
		int roll = (int)(Math.random()*i)+1;
		return roll;
	}
	
	public abstract int save(int stat);

}
