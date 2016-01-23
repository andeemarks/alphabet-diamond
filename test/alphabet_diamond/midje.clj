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
