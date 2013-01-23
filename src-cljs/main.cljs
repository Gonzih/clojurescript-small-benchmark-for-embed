(ns benchmark.core)

(defn factorial [x]
  (reduce * (range 1 (inc x))))

(defn fib [n]
  (if (<= n 1)
    1
    (+ (fib (- n 1)) (fib (- n 2)))))

(defn sort-seq []
  (sort (repeat 100000 (rand-int 2000000))))

(defn time-fun [fun] 
  (let [start  (.getTime (js/Date.))
        _      (fun)
        end    (.getTime (js/Date.))
        result (- end start)]
    result))

(defn time-it [fun]
  (let [values  (for [i (range 200)] (time-fun fun))]
    (/ (apply + values)
       (count values))))

(defn -main []
  (println "(factorial 5000) \t Avg: " (time-it #(factorial 5000)))
  (println "(fib 20) \t Avg: "         (time-it #(fib 20)))
  (println "(sort-seq) \t Avg: "       (time-it #(sort-seq))))

(set! *main-cli-fn* -main)
