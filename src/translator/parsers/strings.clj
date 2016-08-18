(ns translator.parsers.strings
  (:require [instaparse.core :as insta]))

(def grammar
  "<key-value> = string <'='> string
   <string> = dqoute #'([^\"\\\\]|\\\\.)*' dqoute
   <dqoute> = <'\\\"'>")

(def parser (insta/parser grammar :auto-whitespace :standard))
