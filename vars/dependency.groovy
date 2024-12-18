def call(String mavenToolName) {
    script {
      
        def mvnHome = tool mavenToolName            
        sh "${mvnHome}/bin/mvn org.owasp:dependency-check-maven:check -Dformat=HTML"      
        archiveArtifacts artifacts: 'target/dependency-check-report.html', allowEmptyArchive: true
    }
}
