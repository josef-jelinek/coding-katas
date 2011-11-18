(ns game)

(defn- roll [game pins]
  (conj game pins))

(defn roll-game [rolls]
  (reduce roll [] rolls))

(defn score [game]
  (reduce + game))
