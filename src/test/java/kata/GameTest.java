package kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
	Game game = new Game();

	@Test
	void twoRollsResultInScoreEqualToSum() {
		game.roll(4);
		game.roll(4);
		assertThat(game.score()).isEqualTo(8);
	}
}
