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

``{"userid":"{YOURUSERID}", "country":"us", "url":"http://www.google.pt/", "platform": "android", "callback":"http://yourexampleurl.com/offertest/examplecampaignid/result"}``

## Example cURL request

### Async Request
``https://api.offertest.net/offertest[?async=true]``

`` curl -i -H "Authorization: Bearer {APIKEY}" -X POST -d '{"userid":"{YOURUSERID}", "country":"us", "url":"http://www.google.com/","platform": "android", "callback":"http://yourexampleurl.com/offertest/examplecampaignid/result"}' -H "Content-type: application/json" https://api.offertest.net/offertest?async=true ``

### Sync Request
`` curl -i -H "Authorization: Bearer {APIKEY}" -X POST -d '{"userid":"{YOURUSERID}", "country":"us", "url":"http://www.google.com/","platform": "android" }' -H "Content-type: application/json" https://api.offertest.net/offertest ``

## Authorization Header

``Authorization: Bearer {APIKEY}``

## Code Samples

You can find multiple language projects and more details [here](https://github.com/mobrandtech/offertest-docs/tree/master/examples).

## Credits

Each request, depending on the features or target you enable will consume credits according to the table below.

| Feature | Cost |
| - | - |
| Default | 1 Credit |
| Mobile | 10 credits |
| City | 10 credits |
| Screenshot | 10 credits |
| City + Mobile | 20 credits |
| City + Mobile + Screenshot | 30 credits |

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
| screenshot | If ``true`` a screenshot of the final URL will be taken. **(Optional)** **(Consumes Additional Credits)**. Possible values: ``true`` or ``false``. |




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
* 13

#### Android

* 7
* 8
* 9
* 10

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
|screenshotUrl| The URL of the screenshot if requested.|


**Offertest On Demand API Tester**
----
  API to test on demand your offers from your 3rd party platform ( Affise / Axonite / HasOffers / Orangegear / Trackier ).

  This API is asynchronous so it will immediately respond.

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

  * **ContentType:** application/json

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
  | advertiserIds   | Filters offers that match the list of advertiserIds provided. (Optional) |
  | status          | Filters offers that match the list of status provided. (Optional) |
  | fields | Adds parameters so the system can communicate with your platform API |

  **Status Field Description**

  Status can have only two possible values "active" / "paused"
  If omitted "active" is the default value

  **Fields Description**

  | Field         | Description |
  | ------------- |-------------|
  | apiDomain     | In case you are using AFFISE insert your api domain |
  | apiToken      | API token used to fetch your campaigns ( used on Affise / Trackier ) |
  | networkId      | In case of HasOffers you have to insert your networkId  |
  | redirectSizeLimit | Adds a limit to the redirect size of a campaign, such that for instance if 10, all campaigns that has a redirect chain of 11 hops or more, will be considered not working, and that will be reflected on  the report and also on postback ( auto pause ) |

  **Fields Platform Matrix Requirements**


  | Platform / Fields | apiDomain | apiToken | networkId |
  | - | - | - | - |
  | AXONITE         | |✓ | | 
  | AFFISE          |✓ |✓ || 
  | TRACKIER        | |✓ || 
  | HASOFFERS       | |✓ |✓ | 
  | ORANGE_GEAR     |✓ |✓ | | 

* **Success Response:**
  
  * **Code:** 200

    **Content:** **Json Body**

  ```json
    {
        "platform": "HasOffers Integration",
        "platformId": 5,
    }
  ```
 
* **Error Response:**

  * **Code:** 401 UNAUTHORIZED

    **Content:** NONE

  OR

  * **Code:** 400 BADREQUEST

    **Content:** NONE

* **PlatformID**

  | ID          | Platform |
  | ------------- |-------------|
  | 1 | AXONITE |
  | 4 | AFFISE |
  | 5 | HasOffers |
  | 6 | OrangeGear |
  | 8 | Trackier |

* **Test Features**

  | Features          | Description |
  | ------------- |-------------|
  | SEND_POSTBACK | Auto pause campaigns (Only for Affise / Axonite / Trackier ) |
  | BATCH_MAIL | Send a digest mail report after your batch test is done (All platforms) |
  | ONLY_ONE_COUNTRY | On campaign ids with multiple countries, it will only test one country (All platforms)  |

* **Auto Pause Feature**

Auto pause is enabled by sending "SEND_POSTBACK" on the request.

Auto pause will either pause the offers or resume the offers.

To pause an offer it has to match the following conditions:

  * It does not go to an app store
  * It goes to an app store but the app id is incorrect
  * It's redirect chain is higher than the one sent on request ( Optional )

To resume an offer it has to match the following condition:

  * It goes to the correct app store, which is defined by the offer's preview
  url, including the appid.
  * It's redirect chain is lesser or equal than the one sent on request ( Optional )


## Examples

Request which filters offers that it's advertiserId matches the list sent on
the request.

At the end it will send an report to the user's email

```
curl -i -H "Authorization: {APIKEY}" -XPOST -H "Content-type: application/json" -d'
{
    "features": [
        "BATCH_MAIL",
        "ONLY_ONE_COUNTRY"
    ],
    "countries": [],
    "offerIds": [],
    "advertiserIds": ["A_VALID_ADVERTISER_ID"],
    "status": ["paused", "active"],
    "fields": [
        {
            "name": "apiToken",
            "value": "A_VALID_API_TOKEN"
        },
        {
            "name": "redirSizeLimit",
            "value": "5"
        }
    ]
}' https://api.offertest.net/{YOUR_MOBRAND_USER_ID}/api/platforms/ondemand/8
```

Request which filters offers for only OFFER1 and OFFER2 and thus only those two
are tested if they are in "active" status, and have one of the countries - "pt"
or "us".

At the end it will send an report to the user's email and it will auto pause the
offers.


```
curl -i -H "Authorization: {APIKEY}" -XPOST -H "Content-type: application/json" -d'
{
    "features": [
        "BATCH_MAIL",
        "ONLY_ONE_COUNTRY",
        "SEND_POSTBACK"
    ],
    "countries": ["pt", "us"],
    "offerIds": ["OFFER1", "OFFER2"],
    "status": ["active"],
    "fields": [
        {
            "name": "apiToken",
            "value": "A_VALID_API_TOKEN"
        },
        {
            "name": "redirSizeLimit",
            "value": "5"
        }
    ]
}' https://api.offertest.net/{YOUR_MOBRAND_USER_ID}/api/platforms/ondemand/8
```
