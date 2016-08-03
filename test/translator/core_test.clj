(ns translator.core-test
  (:require [clojure.test :refer :all]
            [translator.core :refer :all]
            [clojure.java.io :as io]))

(deftest transforming-translations
  (testing "reading strings files"
    (is (= (translation->clojure :strings (io/reader "./fixtures/translations/strings/en.strings"))
           {:en {"hello" "Hello!"
                 "click_button" "Click"}}))))
