seq(webSettings :_*)

name := "lift-tests"

version := "1.0"

scalaVersion := "2.10.0-RC1"

libraryDependencies ++= Seq("org.eclipse.jetty" % "jetty-distribution" % "8.1.7.v20120910" % "container",
"net.liftweb" % "lift-webkit_2.9.2" % "2.5-M2" % "compile->default",
"com.typesafe" % "slick_2.10.0-RC1" % "0.11.2",
"org.slf4j" % "slf4j-nop" % "1.6.4",
"mysql" % "mysql-connector-java" % "5.1.9"
)