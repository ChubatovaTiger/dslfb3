import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.matrix
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot


version = "2023.05"

project {

    vcsRoot(HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup)
vcsRoot(Repo3)

    buildType(Build1)

}

object Build1 : BuildType({
    name = "build1"

    vcs {
        root(DslContext.settingsRoot)
        root(HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup)
root(Repo3)
    }
    steps {
        script {
            scriptContent = "ls repo3"
        }
    }
features {
    matrix {
        param("par1", listOf(
            value("12"),
            value("13")
        ))
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
branchSpec = "refs/heads/(*)"
    authMethod = uploadedKey {
        uploadedKey = "rsaopensshnew"
        passphrase = "credentialsJSON:20cd5178-8721-46c5-a81a-e798deba3d65"
    }
})
