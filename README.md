khs-tdd-rest-demo
======================
An automated testing demo for a simple REST service.

My Environment
======================
I used Apache Maven 3.0.4 (local), Java 1.7.0_55 x64 (local), and Tomcat 8.0.15 (local)

The Projects
======================
awesome-api contains the RESTful API code and unit tests, while awesome-api-system-tests contain system tests.

Deploy the web service
======================
From the awesome-api directory, deploy to Tomcat using:
  mvn clean package
Note that the deployment path within Tomcat is specified in this project's pom.xml.  Change if needed.

Create Eclipse artifacts
======================
For both projects, create Eclipse files using:
  mvn eclipse:clean eclipse:eclipse
Now you will be able to run the system tests by right-clicking on AllTests suite and choosing Run As -> JUnit Test