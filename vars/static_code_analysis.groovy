def call(String sonarServerName) {
    withSonarQubeEnv(sonarServerName) {
        def scannerHome = tool name: 'Sonar', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
        sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=salary \
            -Dsonar.projectName=Salary-api \
            -Dsonar.host.url=http://100.25.17.63:9000 \
            -Dsonar.login=squ_4f371ade2db48dafec85157cda9d3d07e6a5c456 \
            -Dsonar.java.binaries=target/classes \
            -Dsonar.issue.types=CODE_SMELL \
            -Dsonar.report.export.path=target/static-code-analysis-report.json
        """
        
        waitForQualityGate()  
    }
}
