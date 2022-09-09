(ns build
  (:require [clojure.tools.build.api :as b]))

(defn compile-java
  "Compiles Java sources, with the Servlet API on the classpath."
  [_]
  (let [basis (b/create-basis {:aliases [:servlet-api]})]
    (b/javac {:src-dirs ["java"]
              :class-dir "target/classes"
              :basis basis
              :javac-opts ["-target" "1.8"
                           "-source" "1.8"]})))