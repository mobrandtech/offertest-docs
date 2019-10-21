// Simple example of Sync Client Request for Offertest API
package main

import (
	"bytes"
	"encoding/json"
	"io/ioutil"
	"log"
	"net/http"
	"offertest_example/data"
	"strconv"
)
func syncRequestWithExpectedBundleId() {
	syncRequest := data.NewExpectedBundleIdOffertestRequest(data.USER_ID, data.URL_TEST, data.COUNTRY_TEST, data.ANDROID, data.EXPECTED_BUNDLE_ID)
	requestBody, err := json.Marshal(syncRequest)

	if err != nil {
		log.Fatal(err)
	}

	request, err := http.NewRequest(data.POST_METHOD, data.SYNC_API_URL, bytes.NewBuffer(requestBody))
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

	log.Println("Raw Body Json.\n", string(body))

	var payload data.Payload
	json.Unmarshal(body, &payload)
	log.Println("JsonBodyParsed.\n", payload)

	// It will be always false false if not set on request
	log.Println("ExpectedBundleId - " + strconv.FormatBool(payload.BundleMatch))
}

func syncRequest() {
	syncRequest := data.NewSyncOffertestRequest(data.USER_ID, data.URL_TEST, data.COUNTRY_TEST, data.ANDROID)
	requestBody, err := json.Marshal(syncRequest)

	if err != nil {
		log.Fatal(err)
	}

	request, err := http.NewRequest(data.POST_METHOD, data.SYNC_API_URL, bytes.NewBuffer(requestBody))
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

	log.Println("Raw Body Json.\n", string(body))

	var payload data.Payload
	json.Unmarshal(body, &payload)
	log.Println("JsonBodyParsed.\n", payload)
}

func main() {
	syncRequestWithExpectedBundleId()
}
