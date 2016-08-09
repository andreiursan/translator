(ns translator.core)


(defn translation->clojure
  "parses translation files"
  [translation-type io-file]
  (line-seq io-file))
