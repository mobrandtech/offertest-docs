# OfferTest Partner API

### Context
 * This documentation is intended to help you integrate Mobrand's OfferTest tool.
 * This API is similar very similar to OfferTest API, however it does not
 support async requests, all requests are blocked, and the client will wait for
 response.

### Example Body

``{"userid":"{YOURUSERID}", "subUserId": "{YOUR_CLIENT_ID}", "country":"us", "url":"http://www.google.pt/", "platform": "android"}``

## Example cURL request

### Request
`` curl -i -H "Authorization: Bearer {APIKEY}" -X POST -d'
{
    "userid": "{YOURUSERID}",
    "subUserId": "{YOUR_CLIENT_ID}",
    "country": "us",
    "url": "http://www.google.com/",
    "platform": "android"
}' -H "Content-type: application/json" https://api.offertest.net/offertest/partner ``

## Authorization Header

``Authorization: Bearer {APIKEY}``

## Code Samples

You can find multiple language projects and more details [here]. (https://github.com/mobrandtech/offertest-docs/tree/master/examples)

Those examples are for OfferTest API, not for OfferTest Partner API however they are similar and
therego may offer some insight.

## JSON Options

| Field         | Value         |
| ------------- |-------------|
| userid        | Your partner ID. |
| subUserId        | Your publisherid. |
| country       | An ISO 2 country code. |
| url | The URL you want to test. |
| userAgent | The User Agent to test with **(Optional)**. |
| platform | The platform you want to test. Possible values: ``android``or``ios``. |
| platformVersion | The platform version you want to test according to the list below **(Optional)**. Example: ``10``. By default the latest version is used |
| expectedBundleId | The expected bundleId for iTunes or Play Store app verifications **(Optional)**. |
| mobile | Request through a mobile carrier. Possible values: ``true`` or ``false`` **(Optional)** . |
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

Response example

``
{
    "id": "d6d880e6-09b5-48f5-9e91-74f4cd9670dd",
    "urls": [
        {
            "url": "http://www.google.com/",
            "code": 302,
            "loadTime": 161
        },
        {
            "url": "http://www.google.nl/?gfe_rd=cr&dcr=0&ei=JgQ5Ws3DAumE8QeuzqiIDw",
            "code": 200,
            "loadTime": 20134
        }
    ],
    "bundleIdMatch": false,
    "nRedir": 2
}``

|Field|Value|
|-|-|
|id|Our request id|
|url|the chain url|
|bundleIdMatch|true if the expectedBundleId matches the final URL bundle id (Works only for iTunes or Play Store). It will always be false if you don't set the expectedBundleId on request |
|nRedir| The number of redirects|
|screenshotUrl| The URL of the screenshot if requested.|


