(ns translator.core-test
  (:require [clojure.test :refer :all]
            [translator.core :refer :all]
            [clojure.java.io :as io]))

(deftest transforming-translations
  (testing "strings files"
    (testing "transforming a file"
      (is (= {:en {"hello" "Hello!"
                   "click_button" "Click"
                   "bar_print_$_selected_products" "You Selected %@ Products"}}
             (translation->clojure :strings (io/file "./test/translator/fixtures/translations/strings/en.strings")))))

    (testing "transforming all files in a directory"
      (is (= {:en {"hello" "Hello!"
                   "click_button" "Click"
                   "bar_print_$_selected_products" "You Selected %@ Products"}
              :de {"hello" "Hallo!"
                   "click_button" "Klick"
                   "bar_print_$_selected_products" "Ausgewählte Sie %@ Produkte"}}
             (translations->clojure :strings (file-seq (io/file "./test/translator/fixtures/translations/strings/")))))))

  (testing "yml files"
    (testing "transforming a file"
      (is (= {:en {"hello" "Hello!"
                   "click_button" "Click"}}
             (translation->clojure :yml (io/file "./test/translator/fixtures/translations/yml/en.yml")))))

    (testing "transforming all files in a directory"
      (is (= {:en {"hello" "Hello!"
                   "click_button" "Click"}
              :de {"hello" "Hallo!"
                   "click_button" "Klick"}}
             (translations->clojure :yml (file-seq (io/file "./test/translator/fixtures/translations/yml/"))))))))
