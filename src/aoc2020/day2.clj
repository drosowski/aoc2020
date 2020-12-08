(ns aoc2020.day2)

(defn- check-pw [min max ch pw]
  (let [f ((frequencies pw) ch)]
    (<= min (if (nil? f) 0 f) max)))

(defn- parse-args [s]
  (re-matches #"(\d+)-(\d+)\s([a-z]):\s([a-z]+)" s))

(defn- valid-pw-p1? [input]
  (let [[_ min max ch pw] (parse-args input)]
    (check-pw (Integer. min) (Integer. max) (.charAt ch 0) pw)))

(defn count-valid-pws-p1 [pws]
  (count (filter valid-pw-p1? (clojure.string/split-lines pws))))

(defn- valid-pw-p2? [input]
    (let [[_ pos1 pos2 ch pw] (parse-args input)]
    (= 1 (count (filter #(= (.charAt ch 0) %) (str (nth pw (dec (Integer. pos1))) (nth pw (dec (Integer. pos2)))))))))

(defn count-valid-pws-p2 [pws]
  (count (filter valid-pw-p2? (clojure.string/split-lines pws))))
