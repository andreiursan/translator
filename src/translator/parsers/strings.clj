(ns translator.parsers.strings
  (:require [instaparse.core :as insta]))

(def grammar
  "<key-value> = translation | comment
   <translation> = key <'='> value <';'>
   <key> = string
   <value> = string
   <string> = dqoute #'([^\"\\\\]|\\\\.)*' dqoute
   <dqoute> = <'\\\"'>
   <comment> = <'/*'> #'[a-zA-Z, ]+' <'*/'>")

(def parser (insta/parser grammar :auto-whitespace :standard))
