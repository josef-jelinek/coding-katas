(ns game-test (:use clojure.test game))

(deftest gutter-game
  (is (= 0 (score(roll-game (repeat 20 0))))))

(deftest simple-game
  (is (= 20 (score(roll-game (repeat 20 1))))))

(deftest spare-game
  (let [rolls (concat [5 5 3] (repeat 17 0))]
	  (is (= 16 (score(roll-game rolls))))))

(deftest strike-game
  (let [rolls (concat [10 3 4] (repeat 16 0))]
	  (is (= 24 (score(roll-game rolls))))))

(deftest perfect-game
  (is (= 300 (score(roll-game (repeat 12 10))))))

(run-tests)