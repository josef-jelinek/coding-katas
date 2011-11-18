var BOWLING_GAME = function () {
  'use strict';
  var score = 0;
  return {
    roll: function (pins) {
      score += pins;
    },
    score: function () {
      return score;
    }
  };
};
