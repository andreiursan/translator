(ns translator.core-test
  (:require [clojure.test :refer :all]
            [translator.core :refer :all]
            [clojure.java.io :as io]))

(deftest transforming-strings-translations
  (testing "transforming a file"
    (is (= {:en {"hello" "Hello!"
                 "click_button" "Click"}}
           (translation->clojure :strings (io/file "./test/translator/fixtures/translations/strings/en.strings")))))

  (testing "transforming all files in a directory"
    (is (= {:en {"hello" "Hello!"
                 "click_button" "Click"}
            :de {"hello" "Hallo!"
                 "click_button" "Klick"}}
           (translations->clojure :strings (file-seq (io/file "./test/translator/fixtures/translations/strings/")))))))
