// Simple example of Async Client Request for Offertest API
package main

import (
	"bytes"
	"encoding/json"
	"io/ioutil"
	"log"
	"net/http"
	"offertest_example/data"
)

func asyncRequest() {
	// On Async CALLBACK is Mandatory
	// We suggest using ngrok (https://ngrok.com/) to test links locally. The CALLBACK_URL must be accessible from Internet.
	asyncRequest := data.NewAsyncOffertestRequest(data.USER_ID, data.URL_TEST, data.COUNTRY_TEST, data.ANDROID, data.EXAMPLE_CALLBACK)
	requestBody, err := json.Marshal(asyncRequest)

	if err != nil {
		log.Fatal(err)
	}

	request, err := http.NewRequest(data.POST_METHOD, data.ASYNC_API_URL, bytes.NewBuffer(requestBody))
	if err != nil {
		log.Fatal(err)
	}

	request.Header.Add(data.CONTENT_TYPE, data.MEDIA_TYPE_JSON)
	request.Header.Add(data.AUTH_HEADER, data.AUTH_TOKEN)

	client := &http.Client{}
	resp, err := client.Do(request)
	if err != nil {
		log.Println("Error on response.\n -", err)
	}

	// If unmarshal/read fails close the response buffer
	defer resp.Body.Close()

	body, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		log.Fatal(err)
	}

	log.Println("Id of the async request [" + string(body) + "]" + " which will also be on the response payload")
}

func main() {
	asyncRequest()
}
