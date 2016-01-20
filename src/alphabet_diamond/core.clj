(ns alphabet-diamond.core
  	(:gen-class))

(defn- letter-str->ucase-letter [letter]
	(.charAt (clojure.string/upper-case letter) 0))

(defn letters-to [end-letter]
	(map char (range (int \A) 
		 (inc (int (letter-str->ucase-letter end-letter))))))

(def ^:const row-template "ZYXWVUTSRQPONMLKJIHGFEDCBABCDEFGHIJKLMNOPQRSTUVWXYZ")

(defn row [row-number letter]
	(let [row-letter (nth (letters-to letter) (- row-number 1))]
		(clojure.string/replace row-template (re-pattern (str "[^" row-letter "]")) " ")
	))

(defn -main
  	"I don't do a whole lot ... yet."
  	[& args]
  	(println "Hello, World!"))
