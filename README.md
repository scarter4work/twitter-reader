# twitter-reader
Twitter Reader application pulling the ten most recent tweets from the @salesforce user feed.

Uses Spring Boot, Spring Social for twitter integration, Spring MVC, and AngularJS 1.x.

In order to build the project, install the latest version of java version 8, and maven version 3.  See other pages explaining how to do this. 

When installation of maven is complete, pull down the source code for the repository.

Perform a clean install using maven from the directory that you cloned the twitter-reader repository into.

>mvn clean install

This will run all unit tests for spring boot/java classes.

Change directory to the target directory where you will see the twitter-reader-1.0-SNAPSHOT.jar file.

Run the application:

>java -jar twitter-reader-1.0-SNAPSHOT.jar

You will get several lines of console output.  When it finishes loading (should only take about 10-15 seconds), then open a browser to http://localhost:8080/index.html.

The page will open with a header while the backend of the application queries twitter for the top 10 results from the salesforce twitter history.  The results are displayed on the page and will udpate every minute.

Use the filter textbox on the web page to limit the number of results displayed.

IF THE BUILD FAILS, use the included "fat jar" produced from my build by running the java jar command above and continue with the following steps.
