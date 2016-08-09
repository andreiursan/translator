(ns translator.parsers.strings
  (:require [instaparse.core :as insta]))


(def grammar
  "<key-value> = string <'='> string
   <string> = #'\"[^\"]*\"'")

(defn make-parser [g]
  (insta/parser g :auto-whitespace :standard))

(def parser (make-parser grammar))
