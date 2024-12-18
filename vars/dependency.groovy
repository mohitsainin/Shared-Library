def call(String mavenToolName) {
    script {
        // Get the Maven tool path
        def mvnHome = tool mavenToolName
        
        // Compile the project
        sh "${mvnHome}/bin/mvn compile"
        
        // Run the OWASP dependency check and generate the report
        sh "${mvnHome}/bin/mvn org.owasp:dependency-check-maven:check -Dformat=HTML"
        
        // Archive the generated dependency check report
        archiveArtifacts artifacts: 'target/dependency-check-report.html', allowEmptyArchive: true
    }
}
