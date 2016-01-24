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
	(fact (valid-spec? "A") => truthy)
	(fact (valid-spec? "c") => truthy)
	(fact (valid-spec? "Z") => truthy)
	(fact (valid-spec? "  E   ") => truthy)
	(fact (valid-spec? "") => falsey)
	(fact (valid-spec? "AA") => falsey)
	(fact (valid-spec? " ") => falsey)
	(fact (valid-spec? "4") => falsey)
	(fact (valid-spec? "(") => falsey)
	(fact (valid-spec? nil) => falsey))

(facts "Smoke test shows no smoke"
	(fact (-main "Z") => truthy))
