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
