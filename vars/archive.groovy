def call() {
       archiveArtifacts artifacts: 'target/dependency-check-report.html', allowEmptyArchive: true
    }
