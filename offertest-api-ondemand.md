**Offertest API Scheduler**
----
  API to test on demand your offers from your 3rd party platform ( Affise / Axonite ).

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
            "BATCH_MAIL"
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
  | apiToken      | apiToken so we can fetch your campaigns  |

* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** <br />

  ```json
    {
        "platform": "3",
        "platformId": 4,
        "platformOffers": [
            {
                "id": "59fd7906-0780-425a-8f3f-0d41e584807b",
                "name": "dgt - recargapay - br - cpr",
                "url": "http://example.com",
                "country": "br",
                "platform": "ANDROID",
                "iconUrl": ""
            },
            {
                "id": "68ff1f8f-24a1-4148-9bed-7f7f5c93bb70",
                "name": "dgt - recargapay - br - ios - cpr",
                "url": "http://your_tracking_url.com",
                "country": "br",
                "platform": "IPHONE",
                "iconUrl": ""
            },
            {
                "id": "142a0f2e-05d8-4d69-8ef6-129a20b73d25",
                "name": "BR - UBER_Android_CPT (live) (Must Pass Names)",
                "url": "http://your_tracking_url.com",
                "country": "br",
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
  | 2 | AXONITE |
  | 3 | AFFISE |

* **Test Features**

  | Features          | Description |
  | ------------- |-------------|
  | VIRUS_SCAN | For each url in the chain from the beginning to the end will be check for viruses/malware. |
  | POSTBACK_ON_CHANGE | Postbacks and Emails will only be sent in case of a change on the campaign output test |
  | STATUS_CODE_CHECK | Checks if the last link / landing page is a dead link (ex: 4xx, 5xx, ... ) |
  | AUTO_DL | Checks if the last link / landing page auto downloads  |
  | LAST_DOMAIN_MATCH | Given an expectedResult checks if the last link matches the domain  |
  | BUNDLE_ID | In case of CPI offer test and given an expectedResult runs for iTunes or Play Store app verifications  |
  | SEND_MAIL | To send mail report after the test is done. The mail address will be the one defined on the Mobrand's console users profile  |
  | SEND_POSTBACK | The test result will be postbacked at the specified postback url  |
  | BATCH_MAIL | Send a digest mail report after your batch test is done  |
