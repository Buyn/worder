(ns keechma-todomvc.components.app
  "# Main app component"
  (:require [keechma-todomvc.ui :refer [<comp comp> sub> <cmd]]))


(defn render
  "## Renders the top level UI

  Some elements are rendered inline, others are implemented as
  `components`. Each `component` will have its own `context` provided.

### Component Deps

- `:new-todo` top field where new `todos` are entered
- `:toggle-todos` checkbox to the left of `:new-todo`
- `:todo-list` main body list of `todos`
- `:footer` active count, filtering, clearing

### Subscription Deps

- `:has-todos?` returns true if there are any todos in the EntityDB."
  [ctx]
  [:<>
   [:section.todoapp
    [:header.header
     [:h1 "Worder"]
     [comp> ctx :import-txt]
     [comp> ctx :new-todo]]
    (when (sub> ctx :has-todos?)
      [:<>
       [:section.main
        [comp> ctx :toggle-todos]
        [comp> ctx :todo-list]]
       [comp> ctx :footer]])]

    [:div.export-panel
        [comp> ctx :export-txt {:title "💾 Export to text"
                                :sep "\t"
                                :eof "\n"
                                :ext ".txt"}]
        [comp> ctx :export-txt {:title "💾 Export to CSV"
                                :sep ";"
                                :eof "\n"
                                :ext ".csv"}]]
   [:footer.info
    [:p "Double-click to edit a Word"]
    [:p
     [:a {:href "https://keechma.com"} "Keechma"] " "
     [:a {:href "https://www.linkedin.com/in/buyn-max"} "Freeman"]]]])

(def component
  (<comp :renderer render
         :component-deps [:new-todo
                          :toggle-todos
                          :todo-list
                          :import-txt
                          :export-txt
                          :footer]
         :subscription-deps [:has-todos?]))
