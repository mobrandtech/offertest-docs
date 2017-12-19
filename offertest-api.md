# Offertest API

``https://api.offertest.net/offertest[?async=true]``

Async flag means we will do the test and then send the result to the callback you passed.

Non-async requests will be limited to 50 concurrent requests.


### Example Body

``{"userid":"YOURUSERID", "country":"us", "url":"http://www.google.pt/", "platform": "android", "callback":"http://api.offertest.net/mcat/h_rZwbUlTTC1RGeVHTzXQg/postbackecho"}``

## Example cURL request

`` curl -i -H "Authorization: Bearer {YOUR API KEY}" -X POST -d '{"userid":"YOURID", "country":"us", "url":"http://www.google.com/","platform": "android", "callback":"http://{YOURAPIURL}/offertest/{YOURCAMPAIGNID}/result"}' -H "Content-type: application/json" https://api.offertest.net/offertest  ``

## Authorization Header

``Authorization: Bearer {APIKEY}``

## JSON Options

| Field         | Value         |
| ------------- |:-------------:|
| userid        | Your publisherid.  |
| country       | An ISO country code      |
| url | The URL you want to test      |
| platform | The platform you want to test: ``android``or``ios``|
| callback | This field MUST be passed when using async request|
