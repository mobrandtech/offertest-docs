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
| City | 10 credits |
| City + Mobile | 20 credits |

## JSON Options

| Field         | Value         |
| ------------- |-------------|
| userid        | Your publisherid. |
| country       | An ISO country code. |
| url | The URL you want to test. |
| userAgent | The User Agent to test with **(Optional)**. |
| platform | The platform you want to test. Possible values: ``android``or``ios``. |
| platformVersion | The platform version you want to test according to the list below **(Optional)**. Example: ``10``. |
| callback | This field MUST be passed when using async request. |
| expectedBundleId | The expected bundleId for iTunes or Play Store app verifications **(Optional)**. |
| mobile | Request through a mobile carrier. Possible values: ``true`` or ``false`` **(Optional)** **(Consumes Additional Credits)**. |
| carrier | Select one pair of the table below (it should match the given country or it will be ignored) **(Optional)**. If ``carrier`` is omited the exit mobile carrier will be automatically selected for the country. Example: ``att``. |
| city | Select one city value from this file [csv](https://raw.githubusercontent.com/mobrandtech/offertest-docs/cities/cities.csv) (it should match the given country or an error will return) **(Optional)** **(Consumes Additional Credits)**. If ``city`` is omited the exit city will be automatically selected for the country. Example: ``lasvegas``. |



### Supported Carriers

If you need a carrier that is not in the list please send an email to support@mobrand.net

| Carrier | Country |
| ------------- |-------------|
| att| US|
| att| MX|
| telefonica| ES|
| telefonica| PE|
| telefonica| VE|
| telefonica| DE|
| telefonica| GT|
| telefonica| PA|
| telefonica| UY|
| telefonica| AR|
| telefonica| CR|
| telefonica| SV|
| tmobile| AT|
| tmobile| PL|
| tmobile| CZ|
| tmobile| US|
| tmobile| NL|
| vodafone| NZ|
| vodafone| PT|
| vodafone| GR|
| vodafone| NL|
| vodafone| IE|
| vodafone| TR|
| vodafone| CZ|
| vodafone| HU|
| vodafone| GB|
| vodafone| GH|
| vodafone| IT|
| vodafone| EG|
| vodafone| IN|
| vodafone| FJ|
| vodafone| QA|
| vodafone| TR|
| vodafone| AU|
| dt| DE|
| reliance_jio| IN|
| airtel| TZ|
| airtel| IN|
| airtel| LK|
| claro| BR|
| claro| CL|
| claro| PA|
| verizon| US|
| orange| FR|
| orange| PL|
| orange| RO|
| orange| ES|
| orange| SK|
| orange| MD|
| orange| DO|
| orange| CI|
| orange| CM|
| orange| MA|
| orange| NE|
| orange| GN|
| orange| TN|
| orange| BF|
| orange| BE|
| orange| RE|
| telstra| AU|
| sprint| US|
| chinamobile| HK|
| etisalat| LK|
| etisalat| EG|
| etisalat| BJ|
| etisalat| AF|
| etisalat| SA|
| tigo| SN|
| tigo| GH|
| mtn| CM|
| mtn| RW|
| mtn| ZM|
| mtn| SD|
| mtn| AF|
| dtac| TH|
| docomo| JP|
| mts| RU|
| megafon| RU|
| vimpelcom| RU|
| tim| IT|
| tim| BR|
| meo| PT|
| idea| IN|
| vodacomza| ZA|
| vodacomza| MZ|
| mtnza| ZA|
| robi| BD|
| kyivstar| UA|
| celcom| MY|
| digi| MY|
| vivo| BR|
| zain| BH|
| zain| KW|
| zain| SA|
| vivabo| BO|
| telenormyanmar| MM|
| swisscom| CH|
| singtel| SG|
| asiacell| IQ|
| windit| IT|
| cellc| ZA|
| ooredoo| MM|
| ooredoo| TN|
| ooredoo| MV|
| drei| AT|
| umobile| MY|
| tele2| EE|
| tele2| NL|
| tele2| RU|
| tele2| KZ|
| mobitel| SD|
| mobitel| GE|
| mobitel| LK|
| o2| CZ|
| o2| GB|
| bsnl| IN|
| bouygues| FR|
| free| FR|
| sfr| FR|
| mobiltel| BG|
| digicel| KY|
| digicel| SV|
| digicel| FJ|
| three| IE|
| three| GB|
| cosmote| GR|

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
|bundleIdMatch|true if the expectedBundleId matches the final URL bundle id (Works only for iTunes or Play Store) |
|nRedir| The number of redirects|


# **Offertest On Demand API Tester**
----
  API to test on demand your offers from your 3rd party platform (Affise / Axonite / HasOffers / Orangegear).

* **URL**

  /:userid/api/platforms/ondemand/:platformid

* **Method:**
  
  /:userid/api/platforms/ondemand/:platformid

  `POST`

*  **URL Params**

   **Required:**
    
    *Your account's userid*
    
   `userid=[alphanumeric]`

    *Look on the table below for your platformid*

   `platformid=[numeric]`


* **Data Params**
  
  /:userid/api/platforms/ondemand/:platformid

  * **ContentType:** application/json <br />

  ```json
    {
        "features": [
            "BATCH_MAIL",
            "ONLY_ONE_COUNTRY",
            "SEND_POSTBACK"
        ],
        "countries": ["br","us","gb", "GEOS"],
        "offerIds": [],
        "fields": [
            {
                "name": "apiDomain",
                "value": "[IN_CASE_OF_USING_AFFISE_INSERT_YOUR_API_DOMAIN]"
            },
            {
                "name": "apiToken",
                "value": "[YOUR_API_TOKEN]"
            },
            {
                "name": "redirectSizeLimit",
                "value": "10"
            }
        ]
    }

  ```

  **JSON Fields Description**
  
  | Field         | Description |
  | ------------- |-------------|
  | features        | Adds or removes functionalities to tests. (Optional)  |
  | countries       | Filters offers that match the list of countries provided. (Optional) |
  | offerIds        | Filters offers that match the list of offerIds provided. (Optional) |
  | fields | Adds parameters so the system can communicate with your platform API |

  **Fields Description**

  | Field         | Description |
  | ------------- |-------------|
  | apiDomain     | In case you are using AFFISE insert your api domain |
  | apiToken      | API token used to fetch your campaigns  |
  | networkId      | In case of HasOffers you have to insert your networkId  |
  | redirectSizeLimit      | Adds a limit to the redirect size of a campaign, such that for instance if 10, all campaigns that has a redirect chain of 11 hops or more, will be considered not working, and that will be reflected on the report and also on postback  |

  **Fields Platform Matrix Requirements**


  | Platform / Fields | apiDomain | apiToken | networkId |
  | - | - | - | - |
  | AXONITE         | |✓ | | 
  | AFFISE          |✓ |✓ || 
  | HASOFFERS       | |✓ |✓ | 
  | ORANGE_GEAR     |✓ |✓ | | 

* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** <br />

    **Json Body**

  ```json
    {
        "platform": "HasOffers Integration",
        "platformId": 5,
        "numberOfOffers": 3,
        "numberUniqueOffers": 3,
        "platformOffers": [
            {
                "id": "86708035-0d40-42f5-b807-9f938023b723",
                "offerId": "11111111",
                "name": "Amazon India Online Shopping and Payments",
                "url": "http://www.track.example.com/aff_c?offer_id=11111111&aff_id=3026",
                "country": "ae",
                "platform": "ANDROID",
                "iconUrl": ""
            },
            {
                "id": "95f05f7b-7df4-465e-a7da-c7062c5231a1",
                "offerId": "222222",
                "name": "Dostavista_Ru_iOS_Non-Incent_CPA",
                "url": "http://www.track.example.com/aff_c?offer_id=222222&aff_id=3026",
                "country": "ru",
                "platform": "IPHONE",
                "iconUrl": ""
            },
            {
                "id": "8a3934f3-8cc5-4079-801a-d89940b6488b",
                "offerId": "33333",
                "name": "NNNOW - Online Fashion Shopping App",
                "url": "http://www.track.example.com/aff_c?offer_id=33333&aff_id=3026",
                "country": "in",
                "platform": "ANDROID",
                "iconUrl": ""
            }
        ]
    }
  ```
 
* **Error Response:**

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** NONE

  OR

  * **Code:** 400 BADREQUEST <br />
    **Content:** NONE

* **PlatformID**

  | ID          | Platform |
  | ------------- |-------------|
  | 1 | AXONITE |
  | 4 | AFFISE |
  | 5 | HasOffers |
  | 6 | OrangeGear |

* **Test Features**

  | Features          | Description |
  | ------------- |-------------|
  | SEND_POSTBACK | Auto pause campaigns (Only for Affise / Axonite) |
  | BATCH_MAIL | Send a digest mail report after your batch test is done (All platforms) |
  | ONLY_ONE_COUNTRY | On campaign ids with multiple countries, it will only test one country (All platforms)  |

* **Example cURL Request**

    ``https://api.offertest.net/{YOURUSERID}/api/platforms/ondemand/4``

    `` curl -i -H "Authorization: Bearer {APIKEY}" -X POST -d '
		{
			"features": [
				"BATCH_MAIL"
			],
			"countries": ["jp","br"],
			"offerIds": [],
			"advertiserNames": [],
			"advertiserIds": [],
			"fields": [
				{
					"name": "apiDomain",
					"value": "api-example.affise.com"
				},
				{
					"name": "apiToken",
					"value": "apiTokenExample"
				},
				{
					"name": "redirSizeLimit",
					"value": "10"
				}
			]
		}' 
    -H "Content-type: application/json"  https://api.offertest.net/{YOURUSERID}/api/platforms/ondemand/4``

