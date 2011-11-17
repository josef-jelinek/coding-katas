package bowling.test;

import org.junit.Assert;
import org.junit.Test;

import bowling.Game;

public class BowlingGameTest {

  @Test
  public void gutter_game_yields_zero() {
    Game g = new Game();
    for (int i = 0; i < 20; i++)
      g.roll(0);
    Assert.assertEquals(0, g.score());
  }
}
