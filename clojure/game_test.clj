(ns game-test (:use clojure.test game :reload))

(deftest gutter-game
  (is (= 0 (score (repeat 20 0)))))

(deftest simple-game
  (is (= 20 (score (repeat 20 1)))))

(deftest spare-game
  (is (= 16 (score (concat [5 5 3] (repeat 17 0))))))

(deftest strike-game
  (is (= 24 (score (concat [10 3 4] (repeat 16 0))))))

(deftest perfect-game
  (is (= 300 (score (repeat 12 10)))))
