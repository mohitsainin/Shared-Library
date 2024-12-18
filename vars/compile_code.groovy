def call(String mavenToolName) {
    script {
        def mvnHome = tool mavenToolName
        sh """
            ${mvnHome}/bin/mvn compile > compilation-report.txt
            echo "Report generated:"
            cat compilation-report.txt
        """
    }
}
