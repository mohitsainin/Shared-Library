def call() {
       
       sh 'mvn org.owasp:dependency-check-maven:check -Dformat=HTML'
       archiveArtifacts artifacts: 'target/dependency-check-report.html', allowEmptyArchive: true
       
    }
