Spring 3.1 & Scala & BackboneJS todo example
====================================

This small example application uses the following stack :

 * XML free Spring MVC 3.1 backend (no applicationContext.xml)
 * Spring Data based MongoDB persistence
 * Scala & SBT setup
 * BackboneJS todo example application

In order to run it :

 * Install SBT and MongoDB
 * Create /data/db directory in order to allow MongoDB to store its data
 * Run mongod daemon
 * Run the following command : "sbt container:start"
 * Open your browser and go to [http://localhost:8080/index.html](http://localhost:8080/index.html)


Code is rewrite of [scala-spring-mvc-3](https://github.com/robertrolandorg/scala-spring-mvc-3/) Project in Scala.
