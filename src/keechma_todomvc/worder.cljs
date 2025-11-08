(ns ^:figwheel-hooks keechma-todomvc.worder
  (:require
   [keechma-todomvc.components :as components]
   [keechma-todomvc.controllers.todos :as todos]
   [keechma-todomvc.subscriptions :as subscriptions]
   [reagent.core :as reagent :refer [atom]]
   [keechma.app-state :as app-state]))

(defn multiply [a b] (* a b))

(defonce running-app (atom nil))

(def app-definition
  {:routes [["/:status" {:status "all"}]]
   :controllers {:todos (todos/->Controller)}
   :components components/system
   :subscriptions subscriptions/subscriptions
   :html-element (.getElementById js/document "app")})

(defn start! []
  (reset! running-app (app-state/start! app-definition)))

(defn restart! []
  (if-let [current @running-app]
    (app-state/stop! current start!)
    (start!)))

(defn dev-setup []
  (when ^boolean js/goog.DEBUG
    (enable-console-print!)
    (println "dev mode")))

(defn ^:export main []
  (dev-setup)
  (start!))

(defn ^:after-load on-reload []
  (restart!))
