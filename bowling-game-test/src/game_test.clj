(ns game-test (:use clojure.test game))

(deftest gutter-game
  (is (= 0 (score(roll-game (repeat 20 0))))))

(deftest simple-game
  (is (= 20 (score(roll-game (repeat 20 1))))))

(run-tests)