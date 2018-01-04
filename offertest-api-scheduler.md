**Offertest API Scheduler**
----
  API to manage the campaigns registered to be tested at some chosen period.

* **URL**

  /:userid/scheduler/campaigns/:campaignid

* **Method:**
  
  **/:apikey/scheduler/campaign**

  `GET` | `POST` 

  **/:userid/scheduler/campaign/:campaignid**

  `GET` | `DELETE` | `PUT`
  
*  **URL Params**

   **Required:**
 
   `userid=[alphanumeric]`

   **Optional:**
 
   `campaignid=[alphanumeric]`

* **Data Params**
  
  **/:apikey/scheduler/campaign**

  * **ContentType:** application/json <br />

  ```json
  [
    {
      "url": "www.google.com",
      "label: "ANY_LABEL",
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
      "label: "ANY_LABEL",
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
  **/:apikey/scheduler/campaign/:campaignid**

  * **ContentType:** application/json <br />

  ```json
    {
      "url": "www.google.com",
      "label: "ANY_LABEL",
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

* **Success Response:**
  
  * **Code:** 204 <br />
    **Content:** NONE
 
* **Error Response:**

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** NONE

  OR

  * **Code:** 400 BADREQUEST <br />
    **Content:** NONE

