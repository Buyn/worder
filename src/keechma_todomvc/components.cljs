(ns keechma-todomvc.components
  "# Todo UI Component system"
  (:require [keechma-todomvc.components.app :as app]
            [keechma-todomvc.components.footer :as footer]
            [keechma-todomvc.components.new-todo :as new-todo]
            [keechma-todomvc.components.todo-edit :as todo-edit]
            [keechma-todomvc.components.timer-button :as timer-button]
            [keechma-todomvc.components.todo-item :as todo-item]
            [keechma-todomvc.components.todo-list :as todo-list]
            [keechma-todomvc.components.export-txt :as export-txt]
            [keechma-todomvc.components.import-txt :as import-txt]
            [keechma-todomvc.components.toggle-todos :as toggle-todos]))

(def system
  "Defines the component `system`. All the components that send commands
  are configured to send them to the `:todos` topic controller."
  {:main app/component
   :footer (assoc footer/component :topic :todos)
   :new-todo (assoc new-todo/component :topic :todos)
   :todo-edit (assoc todo-edit/component :topic :todos)
   :todo-item (assoc todo-item/component :topic :todos)
   :timer-button (assoc timer-button/component :topic :todos)
   :import-txt (assoc import-txt/component :topic :todos)
   ;; :export-txt (assoc export-txt/component :topic :todos)
   :export-txt export-txt/component
   :todo-list todo-list/component
   :toggle-todos (assoc toggle-todos/component :topic :todos)})
