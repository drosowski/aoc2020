(ns aoc2020.day5)

(defn- halfies [data upb lower upper]
  (loop [rdata data
         i 0
         lobound 0
         upbound upb]
    (let [d (first rdata)
          delta (- upbound (/ (- upbound lobound) 2))]
      (cond
        (= i (count data)) (int upbound)
        (= d lower) (recur (rest rdata) (inc i) lobound (Math/floor delta))
        (= d upper) (recur (rest rdata) (inc i) (Math/ceil delta) upbound)))))

(defn- determine-row [rows]
  (halfies rows 127 \F \B))

(defn- determine-col [cols]
  (halfies cols 7 \L \R))

(defn- determine-seat-id [bp]
  (let [rows (take 7 bp)
        cols (nthrest bp 7)
        row (determine-row rows)
        col (determine-col cols)]
    (+ (* row 8) col)))

(defn highest-seat-id [boardingpasses]
  (apply max (map #(determine-seat-id %) (clojure.string/split-lines boardingpasses))))

(defn my-seat [boardingpasses]
  (let [seatids (set (map #(determine-seat-id %) (clojure.string/split-lines boardingpasses)))
        allids (set (range (apply min seatids) (apply max seatids)))]
    (clojure.set/difference allids seatids)))
