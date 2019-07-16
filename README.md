# Celebrity Finder
This app shows the implementation of the algorithm used to find a celebrity in a party, where everybody knows the celebrity, but the celebrity knows no one.

The app also shows several topics regarding the challenge, such as patterns, good practices, etc.

## Prerequisistes

The app was tested with Java 8 and it uses Gradle with its wrapper.

## Run

Clone the repository and change directory to the folder cloned. To build the app type:

> ./gradlew clean build

The app download all dependencies, make tests and build a Jar. To run the app type

> cd build/libs

> java -jar CelebrityFinder.jar

It should show:

> Celebrity ID 1

The Test uses Junit, but it is downloaded with Gradle, and Test the fail case where the celebrity doesn't match with the ID, and test the reading of a File (data.csv) containing a Celebrity with ID 7.   


## Design

The algorithm used receives an 2-D array of integers where the row indicates the ID of the person starting in zero, and the column indicates if he knows another person, in this case, the celebrity. So, for example:

{0,1,0,0}

{0,0,0,0}

{0,**1**,0,0} -> This is the person with ID 2, and the bold 1 indicates that he knows the person with the ID 1

{0,1,0,0}


So, the first step is go through the array asking each person, let's say Person A if he doesn't know Person B. If yes add to a queue of probable celebrities, assuming that there's only one. Then it walks through the queue asking if the persons knows somebody, to verify if the person is really an celebrity.

The cost of the algorithm is O(n)