name := "akka-http-jackson"

organization := "com.github.takezoe"

version := "1.0.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.fasterxml.jackson.module" %% "jackson-module-scala"   % "2.7.2",
  "com.typesafe.akka"            %% "akka-http-experimental" % "2.4.6"
)

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
  else                             Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

scalacOptions := Seq("-deprecation")

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/takezoe/scala-jdbc</url>
  <licenses>
    <license>
      <name>The Apache Software License, Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/takezoe/akka-http-jackson</url>
    <connection>scm:git:https://github.com/takezoe/akka-http-jackson.git</connection>
  </scm>
  <developers>
    <developer>
      <id>takezoe</id>
      <name>Naoki Takezoe</name>
      <email>takezoe_at_gmail.com</email>
      <timezone>+9</timezone>
    </developer>
  </developers>
)
