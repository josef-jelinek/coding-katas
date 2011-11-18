(ns game-test (:use clojure.test game))

(deftest gutter-game
  (is (= 0 (score(roll-game (repeat 20 0))))))

(run-tests)