# translator

A Clojure library designed to parse translation files.

## Usage


```clojure
[translator “x.x.x”]

;; In your ns statement:
(ns my.ns
  (:require [translator.core :as t]))

;; In your code:

(t/translation-file->clojure :strings io-file-reader)
;; => {…} 
```

## License

Copyright © 2016 Andrei Ursan

TODO: Choose license.