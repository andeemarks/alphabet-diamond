(ns alphabet-diamond.midje
  (:require [alphabet-diamond.core :as ad])
  (:use [midje.sweet]))

(fact (clojure.string/trim (ad/row 1 "A")) => "A")

(fact (clojure.string/trim (ad/row 1 "B")) => "A")
(fact (clojure.string/trim (ad/row 2 "B")) => "B B")

(fact (clojure.string/trim (ad/row 2 "C")) => "B B")
(fact (clojure.string/trim (ad/row 3 "C")) => "C   C")

(fact (ad/letters-to "C") => [\A \B \C])
(fact (ad/letters-to "A") => [\A])
(fact (ad/letters-to "d") => [\A \B \C \D])
