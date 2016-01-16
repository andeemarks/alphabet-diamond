(ns alphabet-diamond.core
  	(:gen-class))

(defn top-half [letter]
	nil)

(defn- letter-str->ucase-letter [letter]
	(.charAt (clojure.string/upper-case letter) 0))

(defn half-height [letter]
	(- 	(int (letter-str->ucase-letter letter)) 
		(- (int \A) 1)))

(defmulti letter-gap identity)
(defmethod letter-gap 1 [_] 0)
(defmethod letter-gap 2 [_] 1)
(defmethod letter-gap :default [row-number] 
	(+ 2 (letter-gap (- row-number 1))))

(defn letters-to [end-letter]
	(map char (range (int \A) 
									 (inc (int (letter-str->ucase-letter end-letter))))))

(defn line-width [letter]
	(if (= "A" letter)
		1
		(+ 2 (interrow-gap (half-height letter)))))

(defn- top-row? [row-number]
	(= row-number 1))

(defn- gap [row-number]
	(apply str 
		(repeat (letter-gap row-number) " ")))

(defn row [row-number letter]
	(let [current-letter (nth (letters-to letter) (- row-number 1))
				line-width (line-width letter)]
		(if (top-row? row-number)
			(clojure.pprint/cl-format nil "~v<~;~a~;~>" line-width current-letter)
			(clojure.pprint/cl-format nil (str "~v<~;~a~;" (gap row-number) "~a~;~>") line-width current-letter current-letter))
	))

(defn -main
  	"I don't do a whole lot ... yet."
  	[& args]
  	(println "Hello, World!"))
