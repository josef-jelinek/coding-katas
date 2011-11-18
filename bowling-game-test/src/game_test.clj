(ns game-test (:use clojure.test game))

(deftest gutter-game
  (is (= 0 (score(roll-game (repeat 20 0))))))

(deftest simple-game
  (is (= 20 (score(roll-game (repeat 20 1))))))

(deftest spare-game
  (let [rolls (concat [5 5 3] (repeat 17 0))]
	  (is (= 16 (score(roll-game rolls))))))

(run-tests)