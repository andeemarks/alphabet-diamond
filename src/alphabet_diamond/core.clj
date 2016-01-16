(ns alphabet-diamond.core
  	(:gen-class))

(defn top-half [letter]
	nil)
	
(defn half-height [letter]
	(- 	(int (.charAt (clojure.string/upper-case letter) 0)) 
		(- (int \A) 1)))

(defmulti interrow-gap identity)
(defmethod interrow-gap 1 [_] 0)
(defmethod interrow-gap 2 [_] 1)
(defmethod interrow-gap :default [row-number] 
	(+ 2 (interrow-gap (- row-number 1))))

(defn line-width [letter]
	(if (= "A" letter)
		1
		(+ 2 (interrow-gap (half-height letter)))))

(defn row [row-number letter]
	(if (= row-number 1)
		(format "%s" (clojure.pprint/cl-format nil "~v<~;~a~;~>" (line-width letter) letter))
		(format (str "%s" (apply str (repeat (interrow-gap row-number) " ")) "%s") letter letter)))

(defn -main
  	"I don't do a whole lot ... yet."
  	[& args]
  	(println "Hello, World!"))
