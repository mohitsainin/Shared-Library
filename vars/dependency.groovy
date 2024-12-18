def call(String mavenToolName) {
    script {
        // Validate the mavenToolName to avoid NullPointerException
        if (mavenToolName == null || mavenToolName.trim().isEmpty()) {
            error "Maven tool name is not configured or passed correctly!"
        }
        
        // Get the Maven tool path
        def mvnHome = tool mavenToolName
        
        // Run the OWASP Dependency Check
        sh "${mvnHome}/bin/mvn org.owasp:dependency-check-maven:check -Dformat=HTML"
        
        // Archive the generated OWASP dependency check report
        archiveArtifacts artifacts: 'target/dependency-check-report.html', allowEmptyArchive: true
    }
}
