(ns alphabet-diamond.midje
  (:require [alphabet-diamond.core :as ad])
  (:use [midje.sweet]))

(fact (ad/half-height "a") => 1)
(fact (ad/half-height "A") => 1)
(fact (ad/half-height "Z") => 26)
(fact (ad/half-height "j") => 10)

(fact (ad/interrow-gap 1) => 0)
(fact (ad/interrow-gap 2) => 1)
(fact (ad/interrow-gap 3) => 3)
(fact (ad/interrow-gap 4) => 5)
(fact (ad/interrow-gap 5) => 7)

(fact (ad/line-width "A") => 1)
(fact (ad/line-width "B") => 3)
(fact (ad/line-width "C") => 5)
(fact (ad/line-width "D") => 7)

(fact (ad/row 1 "A") => "A")

(fact (ad/row 1 "B") => " A ")
(fact (ad/row 2 "B") => "B B")

(fact (ad/row 2 "C") => " B B ")
(fact (ad/row 3 "C") => "C   C")

(future-fact (ad/top-half "A") => nil)
(future-fact (ad/top-half "B") => [" A "])