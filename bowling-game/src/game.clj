(ns game)

(defn- roll [game pins]
  (conj game pins))

(defn roll-game [rolls]
  (reduce roll [] rolls))

(defn- is-spare [game]
  (= 10 (+ (nth game 0) (nth game 1))))

(defn- spare-bonus [game]
  (+ 10 (nth game 2)))

(defn- frame-pins [game]
  (+ (nth game 0) (nth game 1)))

(defn score [game]
  (cond
    (empty? game) 0
    (is-spare game) (+ (spare-bonus game)
                       (score (drop 2 game)))
    :else (+ (frame-pins game)
             (score (drop 2 game)))))