package kata;

public class Game {
	private final int[] rolls = new int[21];
	private int counter;

	public void roll(int pinsKnockedDown) {
		rolls[counter] += pinsKnockedDown;
		counter++;
	}

	public int score() {
		int score = 0;
		for (int i = 0; i < counter; i++) {
			if (i % 2 == 0 && rolls[i] + rolls[i+1] == 10) {
				score += rolls[i] + rolls[i + 1] + rolls[2];
				i++;
			}
			else score += rolls[i];
		}
		return score;
	}
}
