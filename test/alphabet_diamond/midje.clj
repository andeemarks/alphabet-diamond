(ns alphabet-diamond.midje
  (:require [alphabet-diamond.core :refer :all])
  (:use [midje.sweet]))

(fact (clojure.string/trim (row {:number 1 :letter "A"})) => "A")
(fact (clojure.string/trim (row {:number 2 :letter "B"})) => "B B")
(fact (clojure.string/trim (row {:number 3 :letter "C"})) => "C   C")

(fact (commands-for "C") => [{:number 1 :letter "A"} {:number 2 :letter "B"} {:number 3 :letter "C"} {:number 2 :letter "B"} {:number 1 :letter "A"}])
(fact (commands-for "A") => [{:number 1 :letter "A"}])
(fact (commands-for "d") => [{:number 1 :letter "A"} {:number 2 :letter "B"} {:number 3 :letter "C"} {:number 4 :letter "D"} {:number 3 :letter "C"} {:number 2 :letter "B"} {:number 1 :letter "A"}])

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
