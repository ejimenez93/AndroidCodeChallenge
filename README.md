# AndroidCodeChallenge
Code Challenge Submission for G2i

# Problem
Create an Android application that displays information received over the network from a specific API Endpoint.
The server at the following url responds with JSON formatted data:
```(GET) https://guidebook.com/service/v2/upcomingGuides/```

The response represents a list of “Guide” objects:

```json
{
  "data": [
  {
    "startDate": "<date>",
    "endDate": "<date>",
    "name": "<name>",
    "url": "<url>",
    "venue": {"city": "<city>", "state": "<state>"},
    "icon": "<url to png image>"
    },
    … <more objects>
    ]
  }
  ```

# Solution
Libraries Used:

Retrofit - used for making network requests

Picasso - used for loading remote images from URLs

Butterknife - used for connecting views (to avoid using findViewById() repeatedly)

GSON + Retrofit Converter GSON - used to facilitate interacting with JSON from the API Endpoint above

All milestones required from the project description were achieved in this code submission

# Choices made
I used a simple GuideApi interface implementation with Retrofit [(see: GuideApi.java)](https://github.com/ejimenez93/AndroidCodeChallenge/blob/master/app/src/main/java/co/g2i/androidcodechallenge/api/GuideApi.java)

All of the response from the API endpoint was used in this challenge, in a production environment -- it would be best to paginate and implement some sort of endless scrolling (using a scroll listener that I previously used on a separate project [here](https://github.com/ejimenez93/DiscountAsciiWarehouse/blob/master/app/src/main/java/com/edisonjimenez/discountasciiwarehouse/EndlessRecyclerViewScrollListener.java). With some fooling around, it seems that the API is able to accept query parameters such as ``page`` and ``offset`` which would allow for more results.

Click event listeners weren't added into each item for the sake of time. Ideally, given that the app might need a future "in-detail" screen, adding a click event listener to load more information about a "Guide" would be ideal
The response from the API above doesn't include "Venues" but a mock "Venue" object was made in the case that the response included the referenced venue. The code will show a Guide's city and state if it exists within the response, otherwise we hide it [(see: GuideViewHolder.java)](https://github.com/ejimenez93/AndroidCodeChallenge/blob/master/app/src/main/java/co/g2i/androidcodechallenge/adapters/GuideViewHolder.java#L46)

If more time was allowed, I would also revamp the UI a bit with more branding colors and specific fonts used by a company's brand. Same goes for implementing a more appropriate app name + icon.

# Code Organization
![alt tag](http://edisonjimenez.com/images/Screen%20Shot%202017-07-05%20at%206.32.29%20PM.png)

# Final product
![alt tag](http://edisonjimenez.com/images/Screenshot%20(Jul%205,%202017%206_31_52%20PM).png)
