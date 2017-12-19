# Offertest API

``http://api.offertest.net/offertest[?async=true]``


### JSON Body

``{"userid":"YOURUSERID", "country":"us", "url":"http://www.google.pt/", "platform": "android", "callback":"http://api.offertest.net/mcat/h_rZwbUlTTC1RGeVHTzXQg/postbackecho"}``

## JSON Options

| Field         | Value         |
| ------------- |:-------------:|
| userid        | Your publisherid.  |
| country       | An ISO country code      |
| url | The URL you want to test      |
| platform | The platform you want to test: ``android``or``ios``|

