import Dependencies._

ThisBuild / scalaVersion     := "2.13.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "Sample docs project",
    libraryDependencies += scalaTest % Test
  )

lazy val docs = (project in file("docs"))
  .enablePlugins(
    ParadoxMaterialThemePlugin,
    ParadoxPlugin,
    ParadoxSitePlugin,
    GhpagesPlugin
  )
  .settings(
    name := "Documentation",
    git.remoteRepo := "https://github.com/harpocrates/sample-docs-project",
    Compile / paradoxMaterialTheme ~= {
      _
        .withColor("white", "blue")
        .withoutFont()
        .withRepository(uri("https://github.com/harpocrates/sample-docs-project"))
    },
    Compile / paradoxProperties ++= Map(
      "project.name" -> "Testing how easy docs are to edit",
      "github.base_url" -> "https://github.com/harpocrates/sample-docs-project"
    )
  )
// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
