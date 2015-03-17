khs-tdd-rest-demo
======================
An automated testing demo for a simple REST service.

My Environment
======================
I used Apache Maven 3.2.5 (local), Java 1.8.0_40 x64 (local), and Tomcat 8.0.20 (local).

The Projects
======================
awesome-api contains the RESTful API code and unit tests, while awesome-api-system-tests contains system tests.

Local Setup
======================
If using Eclipse IDE, run "mvn eclipse:clean eclipse:eclipse" to generate Eclipse artifacts.  Then import them into your workspace.
Note that you must change the Tomcat deployment directory in the awesome-api pom.xml if using "mvn package" to deploy!
For the awesome-api project, build and deploy using "mvn clean compile package".
If not already done, start Tomcat using "$CATALINA_HOME/bin/startup.sh" (shutdown.sh to stop).
