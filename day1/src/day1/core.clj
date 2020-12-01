(ns day1.core)

(defn find2020-part1
  [x]
  (first (for [x1 x
        x2 x
        :let [y (+ x1 x2)
              z (* x1 x2)]
      :when (= 2020 y)]
    z)
         ))

(defn find2020-part2
  [x]
  (first (for [x1 x
               x2 x
               x3 x
        :let [y (+ x1 x2 x3)
              z (* x1 x2 x3)]
      :when (= 2020 y)]
    z)
  ))
