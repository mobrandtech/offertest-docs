package data

const (
	SYNC_API_URL  = "https://api.offertest.net/offertest"
	ASYNC_API_URL = "https://api.offertest.net/offertest?async=true"
	// NECESSARY
	MEDIA_TYPE_JSON = "application/json"
	POST_METHOD     = "POST"
	CONTENT_TYPE    = "Content-Type"
	AUTH_HEADER     = "Authorization"

	// Example Data
	URL_TEST           = "https://play.google.com/store/apps/details?id=com.facebook.katana&hl=pt_419"
	COUNTRY_TEST       = "pt"
	EXPECTED_BUNDLE_ID = "com.facebook.katana"

	// Replace Below fields with your data
	// CHECK https://www.mobrand.com/console/offertest/tools/integration/ for auth token (jwt)
	AUTH_TOKEN = "[AUTH_TOKEN]"
	USER_ID    = "[YOUR_USER_ID]"
	// Should be your API Endpoint
	// On how to build a simple server to receive postbacks, have a look at the "server.go" example
	EXAMPLE_CALLBACK = "http://api.example.com/result"
)

// For a description on what are the available platforms check the page below
// https://www.mobrand.com/console/offertest/tools/integration/
const (
	ANDROID = "android"
	IPHONE  = "iPhone"
	IPAD    = "iPad"
	DESKTOP = "Desktop"
)

// For a description on what each field means please check the page below
// https://www.mobrand.com/console/offertest/tools/integration/
type OffertestRequest struct {
	UserId           string `json:"userid"`
	URL              string `json:"url"`
	Country          string `json:"country"`
	Platform         string `json:"platform"`
	PlatformVersion  int32  `json:"platformVersion,omitempty"`
	Carrier          string `json:"carrier,omitempty"`
	City             string `json:"city,omitempty"`
	Mobile           bool   `json:"mobile,omitempty"`
	ExpectedBundleId string `json:"expectedBundleId,omitempty"`
	Callback         string `json:"callback,omitempty"`
}

// Minimal necessary data on sync request
func NewSyncOffertestRequest(userId string, url string, country string, platform string) OffertestRequest {
	request := OffertestRequest{}
	request.UserId = userId
	request.URL = url
	request.Country = country
	request.Platform = platform
	return request
}

// Minimal necessary data on async request
func NewAsyncOffertestRequest(userId string, url string, country string, platform string, callback string) OffertestRequest {
	request := OffertestRequest{}
	request.UserId = userId
	request.URL = url
	request.Country = country
	request.Platform = platform
	request.Callback = callback
	return request
}

// Minimal necessary data on sync request with a check on the identifier/app of the store
func NewExpectedBundleIdOffertestRequest(userId string, url string, country string, platform string, expectedBundleId string) OffertestRequest {
	request := OffertestRequest{}
	request.UserId = userId
	request.URL = url
	request.Country = country
	request.Platform = platform
	request.ExpectedBundleId = expectedBundleId
	return request
}

type RedirectChain struct {
	URL         string `json:"url"`
	Code        int32  `json:"code,omitempty"`
	ContentType string `json:"contentType,omitempty"`
}

// For a description on what each field means please check the page below
// https://www.mobrand.com/console/offertest/tools/integration/
type Payload struct {
	ID          string          `json:"id"`
	URLChain    []RedirectChain `json:"urls,omitempty"`
	ChainLength int32           `json:"nRedir"`
	BundleMatch bool            `json:"bundleIdMatch"`
}
