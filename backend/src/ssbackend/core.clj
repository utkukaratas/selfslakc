(ns ssbackend.core
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.data.json :as json])
  (:gen-class))

(def sample-discovery-data (atom {
  :channels [
    {:name "general"}
    {:name "random"}
  ],
  :directMessages [
    {:username "utku"}
    {:username "ensar"}
    {:username "esma"}
  ],
  :profile {
    :username "utku",
    :profilePic "https://picsum.photos/id/871/100/100?grayscale&blur=2"
  }
}))

(defn discovery [req]
        {:status  200
         :headers {"Content-Type" "text/json"}
         :body    (str (json/write-str @sample-discovery-data))})

(def sample-conversation-data (atom {
  :prevPage 555
  :conversationId 123,
  :items [
    {:text "text 123...", :timestamp 1605635173, :user {:username "utku" :profilePic "https://picsum.photos/id/871/100/100?grayscale&blur=2"}}
    {:text "text 123...", :timestamp 1605635173, :user {:username "esma" :profilePic "https://picsum.photos/id/870/100/100?grayscale&blur=2"}}
    {:text "text 123...", :timestamp 1605635173, :user {:username "utku" :profilePic "https://picsum.photos/id/871/100/100?grayscale&blur=2"}}
    {:text "text 123...", :timestamp 1605635173, :user {:username "utku" :profilePic "https://picsum.photos/id/871/100/100?grayscale&blur=2"}}
  ]
}))

(defn conversation [req]
        {:status  200
         :headers {"Content-Type" "text/json"}
         :body    (str (json/write-str @sample-conversation-data))})

(defroutes app-routes
  (GET "/api/discovery" [] discovery)
  (GET "/api/conversation" [] conversation)
  (route/not-found "Error, page not found!"))

(defn -main
  "This is our main entry point"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "4999"))]
    ; Run the server with Ring.defaults middleware
    (server/run-server (wrap-defaults #'app-routes site-defaults) {:port port})
    ; Run the server without ring defaults
    ; (server/run-server #'app-routes {:port port})
    (println (str "Running ssbackend at http://127.0.0.1:" port "/"))))

; (ns ssbackend.core
;   (:gen-class))

; (defn -main
;   "I don't do a whole lot ... yet."
;   [& args]
;   (println "Hello, World!"))
