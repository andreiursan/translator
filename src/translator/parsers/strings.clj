(ns translator.parsers.strings
  (:require [instaparse.core :as insta]))

(def grammar
  "<file-line> = translation | <comment> | <''>
   <translation> = key <'='> value <';'>
   <key> = string
   <value> = string
   <string> = dqoute #'([^\"\\\\]|\\\\.)*' dqoute
   <dqoute> = <'\\\"'>
   <comment> = <'/*'> <#'[\\s\\S]+?(?=\\*\\/)'> <'*/'>")

(def parser (insta/parser grammar :auto-whitespace :standard))
