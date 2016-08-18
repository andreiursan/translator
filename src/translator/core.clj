(ns translator.core
  (:require [translator.parsers.strings :as strings]
            [clojure.java.io :as io]
            [clojure.string :refer [split]]))


(defn translation->clojure
  "parses translation files"
  [translation-type file]
  (let [file-name (.getName file)
        locale (-> file-name (split #"\.") first keyword)
        lines (line-seq (io/reader file))
        parsed-lines (map strings/parser lines)]
    {locale (into {} (map vec parsed-lines))}))

