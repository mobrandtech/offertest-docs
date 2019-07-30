**Offertest On Demand API Tester**
----
  API to test on demand your offers from your 3rd party platform ( Affise / Axonite / HasOffers / Orangegear ).

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
  | BATCH_MAIL | Send a digest mail report after your batch test is done  |
  | ONLY_ONE_COUNTRY | On campaign ids with multiple countries, it will only test one country  |
