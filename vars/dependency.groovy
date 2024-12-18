def call(String mavenToolName) {
    script {
        // Get the Maven tool path
        def mvnHome = tool name: mavenToolName, type: 'Maven'
        
        // Check if the tool is found
        if (mvnHome == null) {
            error "Maven tool not found. Please ensure the tool is configured in Jenkins."
        }

        // Compile the project
        sh "${mvnHome}/bin/mvn compile"
        
        // Run the OWASP dependency check and generate the report
        sh "${mvnHome}/bin/mvn org.owasp:dependency-check-maven:check -Dformat=HTML"
        
        // Archive the generated dependency check report
        archiveArtifacts artifacts: 'target/dependency-check-report.html', allowEmptyArchive: true
    }
}
