(ns alphabet-diamond.core)

(def ^:const row-template "ZYXWVUTSRQPONMLKJIHGFEDCBABCDEFGHIJKLMNOPQRSTUVWXYZ")

(defn- ucase-letter [letter]
	(int (.charAt (clojure.string/upper-case letter) 0)))

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
				(clojure.string/replace row-template (re-pattern (str "[^" row-letter "]")) " ")
	))

(defn diamond [letter]
	(let [commands (commands-for letter)]
		(map row commands)))

(defn -main
  	[& args]
  	(doall (map println (diamond (first args)))))
