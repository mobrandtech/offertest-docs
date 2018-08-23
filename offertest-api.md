# OfferTest API

### Context
 * This documentation is intended to help you integrate Mobrand's OfferTest tool.
 * You will find instructions on how to integrate Mobrand's OfferTest tool in Async and Sync request modes.
 
| Async         | Sync        |
| ------------- |-------------|
| Requests are queue based and results are sent to the callback.| Resquests can take up to 2 minutes before time out.|
| Good for bulk testing.       | Good for small scale testing.|
| Limited only by your available credit.| Limited to 50 concurrent requests.|
 
###### Note: If you are an Account Manager and you are reading this, please do not be scared and pass it to a tech guy as they will for sure understand it.

### Example Body

``{"userid":"{YOURUSERID}", "country":"us", "url":"http://www.google.pt/", "platform": "android", "callback":"http://{YOURAPIURL}/offertest/{YOURCAMPAIGNID}/result"}``

## Example cURL request

### Async Request
``https://api.offertest.net/offertest[?async=true]``

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

If you need courtesy tests in order to integrate with us please use the following promocode: ```INTEGRATION```.
