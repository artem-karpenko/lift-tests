seq(webSettings :_*)

name := "lift-tests"

version := "1.0"

scalaVersion := "2.9.2"

libraryDependencies ++= Seq("org.eclipse.jetty" % "jetty-distribution" % "8.1.7.v20120910" % "container",
"net.liftweb" %% "lift-webkit" % "2.5-M2" % "compile->default"
)