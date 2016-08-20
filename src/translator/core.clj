(ns translator.core
  (:require [translator.parsers.strings :as strings]
            [clojure.java.io :as io]
            [clojure.string :refer [split]]))

(defmulti translation->clojure (fn [format _] format))

(defmethod translation->clojure :default
  [format file]
  {:error (str "I don't know the " format " format. Known formats: :yml, :strings.")})

(defmethod translation->clojure :strings
  [format file]
  (let [file-name (.getName file)
        locale (-> file-name (split #"\.") first keyword)
        lines (line-seq (io/reader file))
        parsed-lines (map strings/parser lines)]
    {locale (into {} (map vec parsed-lines))}))

(defmethod translation->clojure :yml
  [format file]
  (let [file-name (.getName file)
        locale (-> file-name (split #"\.") first keyword)
        lines (line-seq (io/reader file))]
    {locale {}}))

(defn translations->clojure
  [format files]
  (let [only-files (filter #(not (.isDirectory %)) files)]
    (into {} (map #(translation->clojure format %) only-files))))
