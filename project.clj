(defproject node-benchmark "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :cljsbuild {:builds [{:source-paths ["src-cljs"]
                        :compiler {:output-to "target/cljsbuild-main.js"
                                   :target :nodejs
                                   :optimizations :advanced
                                   :pretty-print true}}]})
