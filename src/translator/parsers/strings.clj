(ns translator.parsers.strings
  (:require [instaparse.core :refer [parser]]))


(def strings-grammar
  "<key-value> = string <'='> string
   string = #'\"[^\"]*\"'")

(defn make-parser [g]
  (parser g :auto-whitespace :standard))

(def strings (make-parser strings-grammar))


