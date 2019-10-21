// Simple example on how to have a http server API to receive offertest's async response

package main

import (
	"encoding/json"
	"fmt"
	"github.com/gorilla/mux"
	"io/ioutil"
	"log"
	"net/http"
)

import "offertest_example/data"

func offertestPostHandler(w http.ResponseWriter, r *http.Request) {
	var payload data.Payload;
	reqBody, err := ioutil.ReadAll(r.Body)
	if err != nil {
		fmt.Fprintf(w, "Invalid Request Body")
	}

	params := mux.Vars(r)
	id := params["id"]
	if len(id) > 0 {
		fmt.Printf("%+v\n", string(id))
	}
	json.Unmarshal(reqBody, &payload)
	w.WriteHeader(http.StatusCreated)
	json.NewEncoder(w).Encode(payload)

}

func main() {
	router := mux.NewRouter()
	router.HandleFunc("/offertest/{id}/result", offertestPostHandler).Methods("POST")
	log.Fatal(http.ListenAndServe(":8080", router))
}
