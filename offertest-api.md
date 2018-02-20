# Offertest API

``https://api.offertest.net/offertest[?async=true]``

Async flag means we will do the test and then send the result to the callback you passed.

Non-async requests will be limited to 50 concurrent requests. Async tests will be limited only by your available credit.


### Example Body

``{"userid":"{YOURUSERID}", "country":"us", "url":"http://www.google.pt/", "platform": "android", "callback":"http://{YOURAPIURL}/offertest/{YOURCAMPAIGNID}/result"}``

## Example cURL request

### Async Request
`` curl -i -H "Authorization: Bearer {APIKEY}" -X POST -d '{"userid":"{YOURUSERID}", "country":"us", "url":"http://www.google.com/","platform": "android", "callback":"http://{YOURAPIURL}/offertest/{YOURCAMPAIGNID}/result"}' -H "Content-type: application/json" https://api.offertest.net/offertest?async=true ``

### Sync Request
`` curl -i -H "Authorization: Bearer {APIKEY}" -X POST -d '{"userid":"{YOURUSERID}", "country":"us", "url":"http://www.google.com/","platform": "android" }' -H "Content-type: application/json" https://api.offertest.net/offertest ``

## Authorization Header

``Authorization: Bearer {APIKEY}``

## JSON Options

| Field         | Value         |
| ------------- |-------------|
| userid        | Your publisherid.  |
| country       | An ISO country code      |
| url | The URL you want to test      |
| platform | The platform you want to test: ``android``or``ios``|
| callback | This field MUST be passed when using async request|
| expectedBundleId | The expected bundleId for iTunes or Play Store app verifications|

## Response Object

Response for Sync Request. For the Async Request this object will be sent as POST to the callback you specified in the request.

`` {"id":"d6d880e6-09b5-48f5-9e91-74f4cd9670dd","urls":[{"url":"http://www.google.com/","type":"INITIAL","loadTime":161},{"url":"http://www.google.nl/?gfe_rd=cr&dcr=0&ei=JgQ5Ws3DAumE8QeuzqiIDw","type":"HTTP_3XX","loadTime":20134}],"bundleIdMatch":false,"nRedir":2} ``

|Field|Value|
|-|-|
|id|Our request id|
|url|the chain url|
|type|HTTP Redirection type|
|bundleIdMatch|true if the expectedBundleId matches the final URL bundle id (Works only for iTunes or Play Store)
|nRedir| The number of redirects|

## Free tests

If you need courtesy tests in order to integrate with us please use the following promocode ```INTEGRATION```.
