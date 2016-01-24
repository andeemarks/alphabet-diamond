(ns alphabet-diamond.core
	(:require [clojure.string :as str]))

(def ^:const row-template "ZYXWVUTSRQPONMLKJIHGFEDCBABCDEFGHIJKLMNOPQRSTUVWXYZ")

(defn- ucase-letter [letter]
	(-> letter
			str/upper-case
			(.charAt 0)
			int))

(defn- letter-range [start-letter end-letter]
  (map char (range 	(int start-letter) 
  									(inc (int end-letter)))))

(defn row-instructions-for [letter]
	(let [letters (reverse (letter-range \A (ucase-letter letter)))]
			(into letters (rest letters))))

(defn- everything-but [letter]
	(re-pattern (str "[^" letter "]")))

(defn row [letter]
	(str/replace row-template (everything-but letter) " "))

(defn diamond [letter]
	(map row (row-instructions-for letter)))

(defn valid-spec? [spec]
	(and (not (nil? spec))
			 (re-seq #"^[A-Za-z]$" (str/trim spec))))

(defn -main [& args]
  	(let [spec (first args)]
	  	(if (valid-spec? spec)
	  		(doall (map println (diamond spec)))
	  		(println "INVALID INPUT"))))
