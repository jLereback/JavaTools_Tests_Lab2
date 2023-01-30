package kata;

public class Game {
	private static final int STRIKE = 10;
	private static final int SPARE = 10;
	private final int[] rolls = new int[21];
	private int counter;

	public void roll(int pinsKnockedDown) {
		if (counter >= 21)
			throw new IllegalArgumentException("""
					The game is over
					Please start a new game""");
		rolls[counter++] += pinsKnockedDown;
		if (counter == 20 && rolls[18] + rolls[19] < 10)
			counter++;
	}

	public int score() {
		int score = 0;
		int rollCount = 0;
		for (int i = 0; i < 10; i++) {
			if (isStrike(rollCount))
				score += STRIKE + getStrikeBonus(rollCount);
			else if (isSpare(rollCount))
				score += SPARE + getSpareBonus(rollCount++);
			else
				score += getFrame(rollCount++);
			rollCount++;
		}
		return score;
	}

	private int getStrikeBonus(int rollCount) {
		return rolls[rollCount + 1] + rolls[rollCount + 2];
	}

	private int getSpareBonus(int rollCount) {
		return rolls[rollCount + 2];
	}

	private boolean isSpare(int rollCount) {
		return rolls[rollCount] + rolls[rollCount + 1] == 10;
	}

	private boolean isStrike(int rollCount) {
		return rolls[rollCount] == 10;
	}

	private int getFrame(int rollCount) {
		return rolls[rollCount] + rolls[rollCount + 1];
	}
}
