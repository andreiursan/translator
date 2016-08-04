(ns translator.core-test
  (:require [clojure.test :refer :all]
            [translator.core :refer :all]
            [clojure.java.io :as io]))

(deftest transforming-translations
  (testing "reading strings files"
    (is (= {:en {"helo" "Hello!"
                 "click_button" "Click"}}
           (translation->clojure :strings (io/reader "./test/translator/fixtures/translations/strings/en.strings"))))))
