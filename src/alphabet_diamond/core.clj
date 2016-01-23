(ns alphabet-diamond.core
  	(:gen-class))

(defn- ucase-letter [letter]
	(int (.charAt (clojure.string/upper-case letter) 0)))

(defn- char-range [start end]
  (map char (range (int start) (inc (int end)))))

(defn commands-for [end-letter]
	(let [letters (map-indexed (fn [index letter] [(+ 1 index) (str (char letter))]) (char-range \A (ucase-letter end-letter)))]
				(into (reverse letters) (rest (reverse letters)))))

(def ^:const row-template "ZYXWVUTSRQPONMLKJIHGFEDCBABCDEFGHIJKLMNOPQRSTUVWXYZ")

(defn row [row-number letter]
	(let [row-letter (nth (letters-to letter) (- row-number 1))]
		(clojure.string/replace row-template (re-pattern (str "[^" row-letter "]")) " ")
	))

(defn -main
  	"I don't do a whole lot ... yet."
  	[& args]
  	(println "Hello, World!"))
