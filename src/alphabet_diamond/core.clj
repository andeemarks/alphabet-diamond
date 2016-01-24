(ns alphabet-diamond.core
	(:require [clojure.string :as str :refer [upper-case trim]]))

(def ^:const row-template "ZYXWVUTSRQPONMLKJIHGFEDCBABCDEFGHIJKLMNOPQRSTUVWXYZ")

(defn- ucase-letter [letter]
	(int (.charAt (upper-case letter) 0)))

(defn- letter-range [start-letter end-letter]
  (map char (range (int start-letter) (inc (int end-letter)))))

(defn- instruction [index letter]
	{:number (+ 1 index) :letter (str (char letter))})

(defn row-instructions-for [end-letter]
	(let [letters (letter-range \A (ucase-letter end-letter))
				rows-and-letters (reverse (map-indexed (fn [index letter] (instruction index letter)) letters))]
			(into rows-and-letters (rest rows-and-letters))))

(defn- everything-but [letter]
	(re-pattern (str "[^" letter "]")))

(defn row [{row-number :number letter :letter}]
	(str/replace row-template (everything-but letter) " "))

(defn diamond [letter]
	(let [instructions (row-instructions-for letter)]
		(map row instructions)))

(defn check-spec [spec]
	{:pre [(not (nil? spec))
				 (re-seq #"^[A-Za-z]$" (trim spec))]}
		true)

(defn -main
  	[& args]
  	(let [spec (first args)]
	  	(try (check-spec spec)
	  		(doall (map println (diamond spec)))
	  		(catch AssertionError inputError (println "INVALID INPUT")))))
