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
    int frameIndex = 0;
    for (int frame = 0; frame < 10; frame++) {
      if (isString(frameIndex)) {
        score += 10 + strikeBonus(frameIndex);
        frameIndex += 1;
      } else if (isSpare(frameIndex)) {
        score += 10 + spareBonus(frameIndex);
        frameIndex += 2;
      } else {
        score += sumOfPinsInFrame(frameIndex);
        frameIndex += 2;
      }
    }
    return score;
  }

  private boolean isString(int frameIndex) {
    return rolls[frameIndex] == 10;
  }

  private int sumOfPinsInFrame(int frameIndex) {
    return rolls[frameIndex] + rolls[frameIndex + 1];
  }

  private int strikeBonus(int frameIndex) {
    return rolls[frameIndex + 1] + spareBonus(frameIndex);
  }

  private int spareBonus(int frameIndex) {
    return rolls[frameIndex + 2];
  }

  private boolean isSpare(int frameIndex) {
    return sumOfPinsInFrame(frameIndex) == 10;
  }
}
