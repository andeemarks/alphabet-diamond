(ns alphabet-diamond.midje
  (:require [alphabet-diamond.core :as ad])
  (:use [midje.sweet]))

(fact (clojure.string/trim (ad/row [1 "A"])) => "A")

(fact (clojure.string/trim (ad/row [1 "B"])) => "A")
(fact (clojure.string/trim (ad/row [2 "B"])) => "B B")

(fact (clojure.string/trim (ad/row [2 "C"])) => "B B")
(fact (clojure.string/trim (ad/row [3 "C"])) => "C   C")

(fact (ad/commands-for "C") => [[1 "A"] [2 "B"] [3 "C"] [2 "B"] [1 "A"]])
(fact (ad/commands-for "A") => [[1 "A"]])
(fact (ad/commands-for "d") => [[1 "A"] [2 "B"] [3 "C"] [4 "D"] [3 "C"] [2 "B"] [1 "A"]])

(fact (ad/check-spec "A") => truthy)
(fact (ad/check-spec "c") => truthy)
(fact (ad/check-spec "Z") => truthy)
(fact (ad/check-spec "  E   ") => truthy)
(fact (ad/check-spec "") => (throws AssertionError))
(fact (ad/check-spec "AA") => (throws AssertionError))
(fact (ad/check-spec " ") => (throws AssertionError))
(fact (ad/check-spec "4") => (throws AssertionError))
(fact (ad/check-spec "(") => (throws AssertionError))
(fact (ad/check-spec nil) => (throws AssertionError))
