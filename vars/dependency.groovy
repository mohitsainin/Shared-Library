def call(String mavenToolName) {
    script {
        def mvnHome = tool mavenToolName
        echo "Maven Home: ${mvnHome}"
        sh "${mvnHome}/bin/mvn compile"
        sh "${mvnHome}/bin/mvn org.owasp:dependency-check-maven:check -Dformat=HTML"
    }
}
