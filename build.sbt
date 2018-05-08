name := """stocks_analyzer_core"""

version := "1.0.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe.play"         % "play-java-jdbc_2.11"           % "2.4.0",
  cache,
  javaWs,
  "com.stocks_analyzer"       % "stocks_analyzer_commons_2.11"  % "1.0.0",
  "ch.qos.logback"            % "logback-classic"               % "1.2.3",
  "org.slf4j"                 % "slf4j-api"                     % "1.7.25",
  "org.slf4j"                 % "jul-to-slf4j"                  % "1.7.25",
  "org.slf4j"                 % "jcl-over-slf4j"                % "1.7.25",
  "mysql"                     % "mysql-connector-java"          % "5.1.38",
  "net.sf.opencsv"            % "opencsv"                       % "2.3",
  "org.apache.httpcomponents" % "httpclient"                    % "4.5.2",
  "org.apache.httpcomponents" % "httpcore"                      % "4.4.6",
  "org.apache.commons"        % "commons-email"                 % "1.4",
  "commons-io"                % "commons-io"                    % "2.5",
  "com.google.apis"           % "google-api-services-calendar"  % "v3-rev180-1.22.0"
)

resolvers += "Maven Repository on Github" at "https://chotto-martini.github.io/stocks_analyzer_commons/repository"

// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile)