(ns alphabet-diamond.midje
  (:require [alphabet-diamond.core :refer :all])
  (:use [midje.sweet]))

(fact (clojure.string/trim (row [1 "A"])) => "A")

(fact (clojure.string/trim (row [1 "B"])) => "A")
(fact (clojure.string/trim (row [2 "B"])) => "B B")

(fact (clojure.string/trim (row [2 "C"])) => "B B")
(fact (clojure.string/trim (row [3 "C"])) => "C   C")

(fact (commands-for "C") => [[1 "A"] [2 "B"] [3 "C"] [2 "B"] [1 "A"]])
(fact (commands-for "A") => [[1 "A"]])
(fact (commands-for "d") => [[1 "A"] [2 "B"] [3 "C"] [4 "D"] [3 "C"] [2 "B"] [1 "A"]])

(fact (check-spec "A") => truthy)
(fact (check-spec "c") => truthy)
(fact (check-spec "Z") => truthy)
(fact (check-spec "  E   ") => truthy)
(fact (check-spec "") => (throws AssertionError))
(fact (check-spec "AA") => (throws AssertionError))
(fact (check-spec " ") => (throws AssertionError))
(fact (check-spec "4") => (throws AssertionError))
(fact (check-spec "(") => (throws AssertionError))
(fact (check-spec nil) => (throws AssertionError))
