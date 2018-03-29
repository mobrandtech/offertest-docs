**Offertest API Scheduler**
----
  API to manage the campaigns registered to be tested at some chosen period.

* **URL**

  /offertest/:userid/scheduler/campaigns/:campaignid

* **Method:**
  
  **/offertest/:userid/scheduler/campaign**

  `GET` | `POST` | `DELETE`

  **/offertest/:userid/scheduler/campaign/:campaignid**

  `GET` | `DELETE` | `PUT`

  **/offertest/:userid/scheduler/campaign/label/:label**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `userid=[alphanumeric]`

   **Optional:**
 
   `campaignid=[alphanumeric]`

   **Optional:**
 
   `label=[alphanumeric]`

* **Data Params**
  
  **/offertest/:userid/scheduler/campaign**

  * **ContentType:** application/json <br />

  ```json
  [
    {
      "url": "www.google.com",
      "label": "ANY_LABEL",
      "platform": "DESKTOP",
      "postback": "http://example.com/postback?id=exampleid",
      "period": 30,
      "expectedResult": "www.google.com",
      "country": "PT",
      "features": [
        "VIRUS_SCAN",
        "POSTBACK_ON_CHANGE",
        "STATUS_CODE_CHECK",
        "AUTO_DL",
        "SEND_MAIL"
      ]
    },
    {
      "url": "www.google.com",
      "label": "ANY_LABEL",
      "platform": "ANDROID",
      "postback": "http://example.com/postback?id=exampleid2",
      "period": 60,
      "expectedResult": "www.google.com",
      "country": "US",
      "features": [
        "VIRUS_SCAN",
        "POSTBACK_ON_CHANGE",
        "STATUS_CODE_CHECK",
        "AUTO_DL",
        "SEND_MAIL"
      ]
    },
  ]
  ```
  **/offertest/:userid/scheduler/campaign/:campaignid**

  * **ContentType:** application/json <br />

  ```json
    {
      "url": "www.google.com",
      "label": "ANY_LABEL",
      "platform": "ANDROID",
      "postback": "http://example.com/postback?id=exampleid2",
      "period": 90,
      "expectedResult": "www.google.com",
      "country": "US",
      "features": [
        "VIRUS_SCAN",
        "POSTBACK_ON_CHANGE",
        "STATUS_CODE_CHECK",
        "AUTO_DL",
        "SEND_MAIL"
      ]
    }
  ```

  **JSON Fields Description**
  
  | Field         | Description |
  | ------------- |-------------|
  | url        | Click URL  |
  | label       | It is anything you want to add to help you identify this campaign. It will be shown on emails. |
  | platform | The platform you want to test: ``ANDROID``or``IOS`` or ``DESKTOP`` |
  | postback | This field is OPTIONAL |
  | expectedResult | The expected result - landing page domain or in case of CPI the expected bundleid. This is OPTIONAL |
  | country | An ISO country where the test / crawl will be run |
  | features | Features you want to include on the test |
  | period | Periodicity of the test in minutes. (30 minutes, 60 minutes, 90 minutes, 360 and 720 minutes ) |

* **Success Response:**
  
  * **Code:** 204 <br />
    **Content:** NONE
 
* **Error Response:**

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** NONE

  OR

  * **Code:** 400 BADREQUEST <br />
    **Content:** NONE

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
