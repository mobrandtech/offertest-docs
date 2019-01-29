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

## Credits

Each request, depending on the features or target you enable will consume credits according to the table below.

| Feature | Cost |
| - | - |
| Default | 1 Credit |
| Mobile | 10 credits |

## JSON Options

| Field         | Value         |
| ------------- |-------------|
| userid        | Your publisherid.  |
| country       | An ISO country code      |
| url | The URL you want to test      |
| platform | The platform you want to test. Possible values: ``android``or``ios``|
| platformVersion | The platform version you want to test according to the list below. Example: ``10`` |
| callback | This field MUST be passed when using async request|
| expectedBundleId | The expected bundleId for iTunes or Play Store app verifications|
| mobile | Request through a mobile carrier **(Consumes 10 credits)**. Possible values: ``true`` or ``false``.|
| carrier | Select one pair of the table below (you must select the corresponding country). If ``carrier`` is omited the exit mobile carrier will be automatically selected. Example: ``att`` |



### Supported Carriers

| Carrier | Country | 
| ------------- |-------------| 
| att| US| 20057| 
| att| MX| 28469| 
| telefonica| ES| 3352| 
| telefonica| PE| 6147| 
| telefonica| VE| 6306| 
| telefonica| DE| 6805| 
| telefonica| GT| 12127| 
| telefonica| GT| 13682| 
| telefonica| PA| 14709| 
| telefonica| UY| 19422| 
| telefonica| AR| 22927| 
| telefonica| CR| 262202| 
| telefonica| SV| 263783| 
| tmobile| AT| 8412| 
| tmobile| PL| 12912| 
| tmobile| CZ| 13036| 
| tmobile| US| 21928| 
| tmobile| NL| 31615| 
| vodafone| NZ| 9500| 
| vodafone| PT| 12353| 
| vodafone| GR| 12361| 
| vodafone| NL| 15480| 
| vodafone| IE| 15502| 
| vodafone| TR| 15897| 
| vodafone| CZ| 16019| 
| vodafone| HU| 21334| 
| vodafone| GB| 25135| 
| vodafone| GH| 29614| 
| vodafone| IT| 30722| 
| vodafone| EG| 36935| 
| vodafone| IN| 38266| 
| vodafone| FJ| 38442| 
| vodafone| QA| 48728| 
| vodafone| TR| 62211| 
| vodafone| AU| 133612| 
| dt| DE| 3320| 
| reliance_jio| IN| 55836| 
| airtel| TZ| 37133| 
| airtel| IN| 45609| 
| airtel| LK| 132045| 
| claro| BR| 22085| 
| claro| CL| 27995| 
| claro| PA| 262227| 
| verizon| US| 22394| 
| orange| FR| 3215| 
| orange| PL| 5617| 
| orange| RO| 8953| 
| orange| ES| 12479| 
| orange| SK| 15962| 
| orange| MD| 25454| 
| orange| DO| 28118| 
| orange| CI| 29571| 
| orange| CM| 36912| 
| orange| MA| 36925| 
| orange| NE| 37233| 
| orange| GN| 37461| 
| orange| TN| 37492| 
| orange| BF| 37577| 
| orange| BE| 47377| 
| orange| RE| 199140| 
| telstra| AU| 1221| 
| sprint| US| 10507| 
| chinamobile| HK| 9231| 
| etisalat| LK| 17470| 
| etisalat| EG| 36992| 
| etisalat| BJ| 37136| 
| etisalat| AF| 131284| 
| etisalat| SA| 35819| 
| tigo| SN| 37649| 
| tigo| GH| 37030| 
| mtn| CM| 30992| 
| mtn| RW| 36890| 
| mtn| ZM| 36962| 
| mtn| SD| 36972| 
| mtn| AF| 132471| 
| dtac| TH| 24378| 
| docomo| JP| 9605| 
| mts| RU| 8359| 
| mts| RU| 28884| 
| mts| RU| 39811| 
| megafon| RU| 31133| 
| vimpelcom| RU| 16345| 
| tim| IT| 16232| 
| tim| BR| 26615| 
| meo| PT| 42863| 
| idea| IN| 45271| 
| vodacomza| ZA| 29975| 
| vodacomza| MZ| 37223| 
| mtnza| ZA| 2905| 
| robi| BD| 24432| 
| kyivstar| UA| 15895| 
| celcom| MY| 10030| 
| digi| MY| 4818| 
| vivo| BR| 26599| 
| zain| BH| 31452| 
| zain| KW| 42961| 
| zain| SA| 43766| 
| vivabo| BO| 28024| 
| telenormyanmar| MM| 133385| 
| swisscom| CH| 3303| 
| singtel| SG| 45143| 
| asiacell| IQ| 51684| 
| windit| IT| 24608| 
| cellc| ZA| 37168| 
| ooredoo| MM| 132167| 
| ooredoo| TN| 37693| 
| ooredoo| MV| 55944| 
| drei| AT| 25255| 
| umobile| MY| 38466| 
| tele2| EE| 1257| 
| tele2| NL| 13127| 
| tele2| RU| 15378| 
| tele2| KZ| 48503| 
| mobitel| SD| 36998| 
| mobitel| GE| 41738| 
| mobitel| LK| 45356| 
| o2| CZ| 5610| 
| o2| GB| 29180| 
| bsnl| IN| 9829| 
| bouygues| FR| 5410| 
| free| FR| 51207| 
| sfr| FR| 15557| 
| mobiltel| BG| 12716| 
| digicel| KY| 13771| 
| digicel| SV| 27903| 
| digicel| FJ| 45355| 
| three| IE| 34218| 
| three| IE| 13280| 
| three| GB| 60339| 
| cosmote| GR| 29247|

### Supported Platform Versions
#### iOS

* 11
* 12

#### Android

* 7
* 8
* 9

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


