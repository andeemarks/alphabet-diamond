(ns alphabet-diamond.core
	(:require [clojure.string :as str :refer [upper-case trim]]))

(def ^:const row-template "ZYXWVUTSRQPONMLKJIHGFEDCBABCDEFGHIJKLMNOPQRSTUVWXYZ")

(defn- ucase-letter [letter]
	(int (.charAt (upper-case letter) 0)))

(defn- letter-range [start-letter end-letter]
  (map char (range (int start-letter) (inc (int end-letter)))))

(defn- instruction [index letter]
	[(+ 1 index) (str (char letter))])

(defn commands-for [end-letter]
	(let [letters (letter-range \A (ucase-letter end-letter))
				rows-and-letters (reverse (map-indexed (fn [index letter] (instruction index letter)) letters))]
			(into rows-and-letters (rest rows-and-letters))))

(defn row [row-instructions]
	(let [row-number (first row-instructions)
				letter (second row-instructions)
				row-letter (nth (letter-range \A (ucase-letter letter)) (- row-number 1))]
			(str/replace row-template (re-pattern (str "[^" row-letter "]")) " ")
	))

(defn diamond [letter]
	(let [commands (commands-for letter)]
		(map row commands)))

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
