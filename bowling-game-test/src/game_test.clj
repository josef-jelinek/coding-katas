(ns game-test (:use clojure.test game))

(deftest gutter-game
  (is (= 0 (score (repeat 20 0)))))

(deftest simple-game
  (is (= 20 (score (repeat 20 1)))))

(deftest spare-game
  (let [rolls (concat [5 5 3] (repeat 17 0))]
    (is (= 16 (score rolls)))))

(deftest strike-game
  (let [rolls (concat [10 3 4] (repeat 16 0))]
    (is (= 24 (score rolls)))))

(deftest perfect-game
  (is (= 300 (score (repeat 12 10)))))

(run-tests)