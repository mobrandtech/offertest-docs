# OfferTest Affise Integration

### Context

 * This documentation is intended to help you integrate Mobrand's OfferTest tool into your Affise Platform.
 * You will find instructions on how to find the required token, and what are the required configurations.
 
### How it works
 
 * Offertest will read your offers by using Affise API and will test them.
 * You can choose to have automatic testing on your campaigns, configuring the scheduler's time periods, or you can do On Demand testing on your campaigns.
 * It is mandatory to insert your API token and your API domain, for either use case you wish to use.
 * The API token can be Sales Manager or ADMIN, if you wish to use status filter or advertiser filter it has to be ADMIN token.
 * After the test on your campaigns is done, you can select to either, send an email containing a report with all the information regarding your campaigns, or to auto pause non leading App Store campaigns, or both. 
 * Choosing the email report, will only get you the information about your campaigns and no changes will be done to them.
 
#### Email Report

 * Preface 
    * Broken - Means that the campaign is not leading to App Store correctly
    * Success / Green - Means that the campaign is leading correctly to App Store

 * The email will contain the following columns & information:
    * ***Adid***
    * ***Name***
    * ***Country***
    * ***Payout***
    * ***Advertiser Name*** ( Only with ADMIN Token )
    * ***Leads To App Store*** ( If the campaign ends on the correct App Store )
    * ***Rule Result*** ( If you have added rules they will be applied, if the campaign leads to App Store, and the result will be either PASS or FAIL )
    * ***PreviewLink***
    * ***Last Test Date*** ( Last time it was tested )
    * ***Last Success Date*** ( Last time it was green )
    * ***Last Broken Date*** ( Last time it was broken )
    * ***Number Of Redirects/Hops*** ( Number of Redirects the campaign has )
    * ***Number Of Brokens*** ( Number of times the result is broken since the first time it was tested )
    * ***Number Of Greens*** ( Number of times the result is green since the first time it was tested )a
    * ***Redirect Domains*** ( Contains the chain redirection of the campaign  )
     
#### Rules

 * Rules allow you to auto stop campaigns on certain conditions you may wish for instance, you don't want to run campaigns that have a redirect chain higher than 6, and want them paused.
 * At the moment the only rule we have available is the MaxNumberOfRedirects, which considers that an offer shall not have a redirect chain higher than a limit.
 * For illustration purpose consider the following different scenarios:
    * Let's say that we have campaign A and a MaxNumberOfRedirects=6
    * If after the test campaign A ***Leads To App Store*** and has ***Number Of Redirects*** of 6 then ***Rule Result*** will be PASS
    * If after the test campaign A ***Leads To App Store*** and has ***Number Of Redirects*** of 5 then ***Rule Result*** will be PASS
    * If after the test campaign A ***Leads To App Store*** and has ***Number Of Redirects*** of 3 then ***Rule Result*** will be PASS
    * If after the test campaign A ***Leads To App Store*** and has ***Number Of Redirects*** of 10 then ***Rule Result*** will be FAIL
 * If no rule is specified then "Rule Result" will only consider "Leads To App Store"

#### Auto Pause

 * Offertest will change the campaign status according to the following ***Rule Result***
    * Status: "stopped" if FAIL
    * Status: "active" if PASS
 * Which means that offertest can reactivate a campaign if it is "stopped"

### Where to find, or create, your API Token 

 * Go to your Affise's platform and follow steps on the screenshots below
 
 ![alt text](http://static.mobrand.net/ss_offertest/affise_1.png "")
 ![alt text](http://static.mobrand.net/ss_offertest/affise_2.png "")
 ![alt text](http://static.mobrand.net/ss_offertest/affise_3.png "")
 ![alt text](http://static.mobrand.net/ss_offertest/affise_4.png "")
 ![alt text](http://static.mobrand.net/ss_offertest/affise_5.png "")
 ![alt text](http://static.mobrand.net/ss_offertest/affise_6.png "")



