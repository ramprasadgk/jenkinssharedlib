package org.paya.jenkinslib

String getBranch() {
    String branchName;

    // When Gitlab triggers the build, we can read the source branch from gitlab.
    if (env.gitlabSourceBranch != null) {
        branchName = env.gitlabSourceBranch
        echo 'Gitlab source branch: ' + branchName
    } else {
        sh "git show-ref | grep `git rev-parse HEAD` | grep remotes | grep -v HEAD | sed -e 's/.*remotes.origin.//' > branch.txt"
        branchName = readFile('branch.txt').trim()
    }

    echo 'Building branch \'' + branchName + '\'.'
    return branchName;
}

String getCommitId() {
    String commitId = bat(returnStdout: true, script: 'git.exe rev-parse HEAD').trim()
    return commitId;
}

boolean isBranchIndexingCause() {
    def isBranchIndexing = false
    if (!currentBuild.rawBuild) {
      return true
    }

    currentBuild.rawBuild.getCauses().each { cause ->
      if (cause instanceof jenkins.branch.BranchIndexingCause) {
        isBranchIndexing = true
      }
    }
    return isBranchIndexing
  }

return this;
