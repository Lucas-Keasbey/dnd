package Player;
import java.util.*;

public class PC extends Creature {
	protected String name;
	protected PlayerClass pcClass;
	protected int hpMax;
	protected int hp;
	
	protected int ac;
	
	public PC(String name) {
		this(name,10,10,10,10,10,10);
	}
	
	public PC(String name, int str, int dex, int con, int inte, int wis, int cha) {
		super(str, dex, con, inte, wis, cha);
		this.name = name;
	}
	
	public int[] rollStats() {
		int[][] rolls = new int[6][4];
		for (int i=0;i<rolls.length;i++)
			for (int j=0;j<rolls[i].length;j++)
				rolls[i][j] = rollD(6);
		int[] stats = new int[6];
		for (int i=0;i<6;i++) {
			int min = Integer.MAX_VALUE;
			for (int j : rolls[i]) {
				stats[i] += j;
				if (j<min)
					min=j;
			}
			stats[i] -= min;
		}
		setStats(stats);
		return stats;
	}
	
	@Override
	public String toString() {
		String s = String.format("Name: %s\n", name);
		s += String.format("Str: %d\tDex: %d\tCon: %d\n", stats[0], stats[1], stats[2]);
		s += String.format("Int: %d\tWis: %d\tCha: %d\n", stats[3], stats[4], stats[5]);
		return s;
	}
	
	public int save(int stat) {
		int result = rollD(20);
		result += this.getMod(stat);
		if (pcClass.saveProf[stat]) {
			result += pcClass.getProf();
		}
		return result;
	}
	
	public static void main(String[] args) {
		PC player = new PC("John");
		player.rollStats();
		System.out.println(player);
	}

	

}
