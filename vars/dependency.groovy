def call(String mavenToolName) {
    script {
        // Get Maven home directory
        def mvnHome = tool mavenToolName
        
        // Print Maven home for debugging
        echo "Maven Home: ${mvnHome}"
        
        // Ensure Maven commands are executed correctly
        sh "${mvnHome}/bin/mvn -version"
        sh "${mvnHome}/bin/mvn compile"
        sh "${mvnHome}/bin/mvn org.owasp:dependency-check-maven:check -Dformat=HTML"
    }
}
