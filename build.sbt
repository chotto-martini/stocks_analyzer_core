name := """stocks_analyzer_core"""

version := "1.0.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "com.stocks_analyzer" % "stocks_analyzer_commons_2.11" % "1.0.0"
)

resolvers += "Maven Repository on Github" at "https://chotto-martini.github.io/stocks_analyzer_commons/repository"

// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile)