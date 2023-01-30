package kata;

public class Game {
	private final int[] rolls = new int[21];
	private int counter;

	public void roll(int pinsKnockedDown) {
		if (counter >= 21)
			throw new IllegalArgumentException("""
					The game is over
					Please start a new game""");
		rolls[counter] += pinsKnockedDown;
		counter++;
		if (counter == 20 && rolls[18] + rolls[19] < 10)
			counter++;
	}

	public int score() {
		int score = 0;
		for (int i = 0; i < rolls.length-1; i++) {
			if (i % 2 == 0 && rolls[i] + rolls[i+1] == 10) {
				score += rolls[i] + rolls[i + 1] + rolls[2];
				i++;
			}
			else score += rolls[i];
		}
		return score;
	}
}
