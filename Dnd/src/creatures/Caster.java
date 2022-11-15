package creatures;

public abstract class Caster extends PlayerClass {
	int[][] maxSlots = {
			{2,0,0,0,0,0,0,0,0},
			{3,0,0,0,0,0,0,0,0},
			{4,2,0,0,0,0,0,0,0},
			{4,3,0,0,0,0,0,0,0},
			{4,3,2,0,0,0,0,0,0},
			{4,3,3,0,0,0,0,0,0},
			{4,3,3,1,0,0,0,0,0},
			{4,3,3,2,0,0,0,0,0},
			{4,3,3,3,1,0,0,0,0},
			{4,3,3,3,2,0,0,0,0},
			{4,3,3,3,2,1,0,0,0},
			{4,3,3,3,2,1,0,0,0},
			{4,3,3,3,2,1,1,0,0},
			{4,3,3,3,2,1,1,0,0},
			{4,3,3,3,2,1,1,1,0},
			{4,3,3,3,2,1,1,1,0},
			{4,3,3,3,2,1,1,1,1},
			{4,3,3,3,3,1,1,1,1},
			{4,3,3,3,3,2,1,1,1},
			{4,3,3,3,3,2,2,1,1}};
	int[] currentSlots = new int[9];

	@Override
	public String getFeatures() {
		String features = "Caster class\nMax spell slots:\n";
		features += "1\t2\t3\t4\t5\t6\t7\t8\t9\n";
		for (int i=0;i<9;i++) {
			features += String.format("%d\t", maxSlots[level-1][i]);
		}
		features += "\n";
		return features;
	}

}
