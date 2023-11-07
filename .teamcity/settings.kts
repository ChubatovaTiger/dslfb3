import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.matrix
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot
/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2023.05"

project {

    vcsRoot(HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup)
vcsRoot(Repo3)

    buildType(Build1)
    buildType(Build3)
}

object Build1 : BuildType({
    name = "build1"

    vcs {
        root(DslContext.settingsRoot)
        root(HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup)
root(Repo3)
    }

    dependencies {
        snapshot(Build3) {
            reuseBuilds = ReuseBuilds.NO
        }
    }
})

object Build3 : BuildType({
    name = "build3"

    vcs {
        root(DslContext.settingsRoot)
        root(HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup)
        root(Repo3, "+:. => repo3")
    }
    steps {
        script {
            scriptContent = "ls repo3"
        }
    }
})

object HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup : GitVcsRoot({
    name = "https://github.com/ChubatovaTiger/ChubatovaGradleTestsBackup"
    url = "https://github.com/ChubatovaTiger/ChubatovaGradleTestsBackup"
    branch = "refs/heads/master"
})

object Repo3 : GitVcsRoot({
    name = "repo3"
    url = "git@github.com:ChubatovaTiger/repo3.git"
    branch = "refs/heads/main"
    authMethod = uploadedKey {
        uploadedKey = "rsaopensshnew"
        passphrase = "credentialsJSON:20cd5178-8721-46c5-a81a-e798deba3d65"
    }
})
