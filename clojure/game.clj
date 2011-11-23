(ns game)

(defn- score-by-frame [game frame]
  (letfn [
    (score-rest [skip] (score-by-frame (drop skip game) (inc frame)))
    (spare? [] (= 10 (frame-pins)))
    (strike? [] (= 10 (first game)))
    (bonus [] (apply + (take 3 game)))
    (frame-pins [] (apply + (take 2 game)))]

    (cond (> frame 10) 0
          (strike?) (+ (bonus) (score-rest 1))
          (spare?) (+ (bonus) (score-rest 2))
          :else (+ (frame-pins) (score-rest 2)))))

(defn score [game] (score-by-frame game 1))
