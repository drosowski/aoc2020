(ns aoc2020.day4)

(defn- parse-pps [s]
  (let [lines (clojure.string/split s #"\n\n")
        keys (map #(clojure.string/replace % #"\n" " ") lines)
        pairs (map (fn [l] (reduce #(assoc % (read-string (nth %2 1)) (nth %2 2)) {} (re-seq #"(\S+):(\S+)" l))) keys)]
    pairs))

(defn count-valid-passports-p1 [pps]
  (let [pps (map #(set (keys %))  (parse-pps pps))]
    (count (filter #(clojure.set/subset? #{'byr 'iyr 'hgt 'hcl 'ecl 'pid} %) pps))))

(defn- valid-hgt? [hgt]
  (cond
    (and (clojure.string/ends-with? hgt "cm")
    (<= 150 (Integer. (re-find #"\d+" hgt)) 193)) true
    (and (clojure.string/ends-with? hgt "in")
    (<= 59 (Integer. (re-find #"\d+" hgt)) 76)) true
    :else false))

(defn- is-valid? [pp]
  (and
   (<= 1920 (Integer. (or ('byr pp) "0")) 2002)
   (<= 2010 (Integer. (or ('iyr pp) "0")) 2020)
   (<= 2020 (Integer. (or ('eyr pp) "0")) 2030)
   (valid-hgt? (or ('hgt pp) ""))
   (not (nil? (re-find #"^#[0-9|a-f]{6}$" (or ('hcl pp) ""))))
   (not (nil? (re-find #"(amb|blu|brn|gry|grn|hzl|oth)" (or ('ecl pp) ""))))
   (not (nil? (re-find #"^[0-9]{9}$" (or ('pid pp) ""))))))


(defn count-valid-passports-p2 [pps]
  (let [pps (parse-pps pps)]
    (count (filter #(is-valid? %) pps))))
