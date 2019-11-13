# Iteration #1
-------------------
Note: We began working in a different repository in order to test some things out with branches and such and simply continued there and transferred the work.
In this iteration our group implemented three important aspects of our application.
First, we implemented our Main Screen user story, which was hamburger/navigation bar that linked all of our pages together and allows for a more user-friendly interface.
We then implemented our Swipes Information user story, which created a food page that lists a variety of places where swipes are accepted around campus. To do this we made use of a JSON file. This was so we did not have to make a class for each food location regarding its information, instead we were just able to parse the JSON file and pull the information into a single class called FoodInformation.
Similarly, we integrated the events page by parsing the JSON file and pulling event details in the EventInformation class and this was a part of our Finding Events user story
Finally we also implemented a splash screen that pops up with a vcu logo which then transitions to the main screen.

We have yet to implement some other key user stories, such as Creating Events, which will allow users to submit events to the page for others to view, or our Home Screen user story, which will create a more personalized experience for users. We also planned on cleaning up the way the swipe locations and events (aka buttons) were presented.

Some challenges we faced in this user story, included parsing the JSON file and presenting the information like we wanted, as well as setting up some of the layouts of our pages.
We also had some difficulties with espresso testing, as we began getting failing tests without understanding what exactly failed. These issues were ultimately resolved.

--------------------------
Reference to Final Completed Commit For Iteration [d13b82a](https://github.com/vcu-cmsc355-fall2018/fall-19-project-group-21/commit/d13b82abd4f20755e6ca04ef99e07011a1dceb2f)

SDK Related ERRORS `E/Surface: getSlotFromBufferLocked: unknown buffer: 0xb40bcd00`
###### Test Files 

+ [SwipeInformationS1.java](https://github.com/vcu-cmsc355-fall2018/fall-19-project-group-21/blob/master/app/src/androidTest/java/edu/vcu/beyep/group21test/SwipeInformationS1.java)
+ [SwipeInformationS2.java](https://github.com/vcu-cmsc355-fall2018/fall-19-project-group-21/blob/master/app/src/androidTest/java/edu/vcu/beyep/group21test/SwipeInformationS2.java)     
+ [SwipeInformationS3.java](https://github.com/vcu-cmsc355-fall2018/fall-19-project-group-21/blob/master/app/src/androidTest/java/edu/vcu/beyep/group21test/SwipeInformationS3.java)
- [FindingEventsS1.java](https://github.com/vcu-cmsc355-fall2018/fall-19-project-group-21/blob/master/app/src/androidTest/java/edu/vcu/beyep/group21test/FindingEventsS1.java)
- [FindingEventsS2.java](https://github.com/vcu-cmsc355-fall2018/fall-19-project-group-21/blob/master/app/src/androidTest/java/edu/vcu/beyep/group21test/FindingEventsS2.java)
- [FindingEventsS3.java](https://github.com/vcu-cmsc355-fall2018/fall-19-project-group-21/blob/master/app/src/androidTest/java/edu/vcu/beyep/group21test/FindingEventsS3.java)
+ [MainScreenS1.java](https://github.com/vcu-cmsc355-fall2018/fall-19-project-group-21/blob/master/app/src/androidTest/java/edu/vcu/beyep/group21test/MainScreenS1.java)
- [MainScreenS2.java](https://github.com/vcu-cmsc355-fall2018/fall-19-project-group-21/blob/master/app/src/androidTest/java/edu/vcu/beyep/group21test/MainScreenS2.java)
+ [MainScreenS3.java](https://github.com/vcu-cmsc355-fall2018/fall-19-project-group-21/blob/master/app/src/androidTest/java/edu/vcu/beyep/group21test/MainScreenS3.java)
+ [MainScreenS4.java](https://github.com/vcu-cmsc355-fall2018/fall-19-project-group-21/blob/master/app/src/androidTest/java/edu/vcu/beyep/group21test/MainScreenS4.java)


