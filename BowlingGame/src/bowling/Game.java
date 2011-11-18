package bowling;

public final class Game {
  private int[] rolls = new int[21];
  private int currentRoll = 0;

  public void roll(int pins) {
    rolls[currentRoll] = pins;
    currentRoll += 1;
  }

  public int score() {
    int score = 0;
    for (int frame = 0; frame < 10; frame++) {
      if (isSpare(frame)) {
        score += 10 + rolls[frame * 2 + 2];
      } else {
        score += rolls[frame * 2] + rolls[frame * 2 + 1];
      }
    }
    return score;
  }

  private boolean isSpare(int frame) {
    return rolls[frame * 2] + rolls[frame * 2 + 1] == 10;
  }
}
