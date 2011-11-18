(ns game)

(defn- strike? [game]
  (= 10 (+ (nth game 0))))

(defn- strike-bonus [game]
  (+ 10 (nth game 1) (nth game 2)))

(defn- spare? [game]
  (= 10 (+ (nth game 0) (nth game 1))))

(defn- spare-bonus [game]
  (+ 10 (nth game 2)))

(defn- frame-pins [game]
  (+ (nth game 0) (nth game 1)))

(defn- score-n [game frame]
  (let [score-frame (fn [f len]
                        (+ (f game) (score-n (drop len game) (inc frame))))]
    (cond (= frame 10) 0
          (strike? game) (score-frame strike-bonus 1)
          (spare? game) (score-frame spare-bonus 2)
          :else (score-frame frame-pins 2))))

(defn score [game] (score-n game 0))
