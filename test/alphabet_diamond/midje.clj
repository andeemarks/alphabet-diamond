(ns alphabet-diamond.midje
  (:require [alphabet-diamond.core :refer :all])
  (:use [midje.sweet]))

(fact (clojure.string/trim (row "A")) => "A")
(fact (clojure.string/trim (row "B")) => "B B")
(fact (clojure.string/trim (row "C")) => "C   C")

(fact (row-instructions-for "C") => ["A" "B" "C" "B" "A"])
(fact (row-instructions-for "A") => ["A"])
(fact (row-instructions-for "d") => ["A" "B" "C" "D" "C" "B" "A"])

(facts "Valid specs are single alphabetic characters"
	(fact (check-spec "A") => truthy)
	(fact (check-spec "c") => truthy)
	(fact (check-spec "Z") => truthy)
	(fact (check-spec "  E   ") => truthy)
	(fact (check-spec "") => (throws AssertionError))
	(fact (check-spec "AA") => (throws AssertionError))
	(fact (check-spec " ") => (throws AssertionError))
	(fact (check-spec "4") => (throws AssertionError))
	(fact (check-spec "(") => (throws AssertionError))
	(fact (check-spec nil) => (throws AssertionError)))

(facts "Smoke test shows no smoke"
	(fact (-main "Z") => truthy))
