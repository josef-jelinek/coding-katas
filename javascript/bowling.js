var BOWLING_GAME = function () {
  'use strict';
  var rolls = [];

  function isSpare(index) {
    return rolls[index] + rolls[index + 1] == 10;
  }

  function spareBonus(index) {
    return 10 + rolls[index + 2];
  }

  function framePins(index) {
    return rolls[index] + rolls[index + 1];
  }

  return {
    roll: function (pins) {
      rolls.push(pins);
    },
    score: function () {
      var frame, frameIndex = 0, score = 0;
      for (frame = 0; frame < 10; frame++) {
        if (isSpare(frameIndex)) {
          score += spareBonus(frameIndex);
          frameIndex += 2;
        } else {
          score += framePins(frameIndex);
          frameIndex += 2;
        }
      }
      return score;
    }
  };
};
