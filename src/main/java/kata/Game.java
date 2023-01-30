package kata;

import java.util.Arrays;

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
		int rollCount = 0;
		System.out.println(Arrays.toString(rolls));
		for (int i = 0; i < 10; i++) {
			if (rollCount % 2 == 0 && rolls[rollCount] + rolls[rollCount+1] == 10) {
				score += rolls[rollCount] + rolls[rollCount + 1] + rolls[2];
				rollCount++;
			}
			else if (rolls[rollCount] == 10 && (rollCount % 2 == 1 || i == 0 )) {
				score += rolls[rollCount] + rolls[rollCount + 1] + rolls[2];
			}
			else {
				score += rolls[rollCount] + rolls[rollCount + 1];
				rollCount++;
			}
			rollCount++;
		}
		return score;
	}
}
