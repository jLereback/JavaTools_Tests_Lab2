package kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
	Game game = new Game();

	@DisplayName("X rolls with Y pins knocked down result in expected score")
	@ParameterizedTest(name = "{index} ==> {0} roll(s) with {1} pins down = {2} score")
	@CsvSource({"2, 4, 8", "4, 3, 12", "3, 5, 20"})
	void xRollsResultInExpectedScore(int numRolls, int pinsKnockedDown, int expected) {
		rollMultiple(numRolls, pinsKnockedDown);
		assertThat(game.score()).isEqualTo(expected);
	}

	private void rollMultiple(int numRolls, int pinsKnockedDown) {
		for (int i = 0; i < numRolls; i++)
			game.roll(pinsKnockedDown);
	}
}
