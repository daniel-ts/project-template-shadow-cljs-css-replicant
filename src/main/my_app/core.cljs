(ns my-app.core
  (:require [replicant.dom :as r]
            [shadow.css :refer (css)]))

(defn greeting []
  [:h2 {:class (css {:color "red"})}
   "Hello from src/main/my_app/core.cljs."
   [:p "Adjust the namespaces here and in shadow-cljs.edn, and src/dev/build.clj."]
   ])


(defn ^:dev/before-load stop []
  (js/console.log "stop"))

(defn ^:dev/after-load start []
  (js/console.log "start")
  (r/render (js/document.getElementById "app") (greeting))
  )

(defn init
  "Execute once on initialization."
  []
  (js/console.log "init")
  (start))
