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

(fact (ad/top-half "A") => nil)