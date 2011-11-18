package bowling.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bowling.Game;

public class BowlingGameTest {
  private Game g;

  @Before
  public void setUp() {
    g = new Game();
  }

  private void rollMany(int n, int pins) {
    for (int i = 0; i < n; i++)
      g.roll(pins);
  }

  @Test
  public void gutter_game_yields_zero() {
    rollMany(20, 0);
    Assert.assertEquals(0, g.score());
  }

  @Test
  public void all_ones_yield_20() {
    rollMany(20, 1);
    Assert.assertEquals(20, g.score());
  }

  @Test
  public void one_spare_gives_bonus() {
    rollSpare();
    g.roll(3);
    rollMany(17, 0);
    Assert.assertEquals(16, g.score());
  }

  @Test
  public void one_strike_gives_bonus() {
    rollStrike();
    g.roll(4);
    g.roll(3);
    rollMany(16, 0);
    Assert.assertEquals(24, g.score());
  }

  private void rollStrike() {
    g.roll(10);
  }

  private void rollSpare() {
    g.roll(5);
    g.roll(5);
  }
}
