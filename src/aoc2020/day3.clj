(ns aoc2020.day3)

(defn count-trees [s ix iy]
  (let [sl (clojure.string/split-lines s)]
    (loop [x ix
           y iy
           t 0]
      (if (<= (count sl) (+ y iy))
        t
        (let [row (nth sl y)]
          (if (= (nth (cycle row) x) \#)
            (recur (+ x ix) (+ y iy) (inc t))
            (recur (+ x ix) (+ y iy) t)))))))
