(ns aoc2020.day1-test
  (:require [clojure.test :refer :all]
            [aoc2020.day1 :refer :all]))

(deftest a-test
  (testing "find pair that has sum of 2020 in list"
    (is nil? (find2020-part1 []))
    (is nil? (find2020-part1 [100 200 300]))
    (is 102000 (find2020-part1 [1000 2000 1020 3000])))
  (testing "find 3 elements that have sum 2020 in list"
    (is nil? (find2020-part2 []))
    (is nil? (find2020-part2 [100 200 300]))
    (is 40000000 (find2020-part2 [500 1000 2000 20 3000]))))
