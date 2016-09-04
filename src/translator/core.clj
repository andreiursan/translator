(ns translator.core
  (:require [translator.parsers.strings :as strings]
            [clojure.java.io :as io]
            [clojure.string :refer [split]]
            [yaml.core :as yaml]))

(defmulti translation->clojure
  (fn [format _] format))

(defmethod translation->clojure :default
  [format _]
  {:error (str "I don't know the " format " format. Known formats: :yml, :strings.")})

(defmethod translation->clojure :strings
  [_ file]
  (let [file-name (.getName file)
        locale (-> file-name (split #"\.") first keyword)
        lines (line-seq (io/reader file))
        parsed-lines (filter seq (map strings/parser lines))
        translation-map (into {} (map vec parsed-lines))]
    {locale translation-map}))

(defmethod translation->clojure :yml
  [_ file]
  (let [file-content (slurp (io/reader file))
        yaml-parse (yaml/parse-string file-content false)]
    (into {} (for [[k v] yaml-parse] [(keyword k) v]))))

(defn translations->clojure
  [format files]
  (let [only-files (filter #(not (.isDirectory %)) files)]
    (into {} (map #(translation->clojure format %) only-files))))
