name := "Todo"

version := "1.0"

scalaVersion := "2.9.1"

seq(webSettings : _*)

libraryDependencies ++= Seq(
  "org.springframework" % "spring-webmvc" % "3.1.0.RELEASE",
  "javax.validation" % "validation-api" % "1.0.0.GA",
  "org.hibernate" % "hibernate-validator" % "4.2.0.Final",
  "javax.servlet" % "javax.servlet-api" % "3.0.1",
  "org.codehaus.jackson" % "jackson-mapper-asl" % "1.9.2",
  "javax.inject" % "javax.inject" % "1",
  "org.springframework.data" % "spring-data-mongodb" % "1.0.0.RC1",
  "ch.qos.logback" % "logback-classic" % "1.0.0",
  "cglib" % "cglib-nodep" % "2.2"
)

resolvers ++= Seq(
  "release-springsource" at "http://repo.springsource.org/release/",
  "milestone-springframework" at "http://maven.springframework.org/milestone/"
)

libraryDependencies ++= Seq(
  "org.mortbay.jetty" % "servlet-api" % "3.0.20100224" % "provided",
  "org.eclipse.jetty" % "jetty-server" % "8.0.0.M3" % "container, compile",
  "org.eclipse.jetty" % "jetty-util" % "8.0.0.M3" % "container, compile",
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.0.M3" % "container, compile"
)
