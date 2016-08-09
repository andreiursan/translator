(ns translator.core
  (:require [translator.parsers.strings :as strings]))


(defn translation->clojure
  "parses translation files"
  [translation-type io-file]
  (map strings/parser (line-seq io-file)))
