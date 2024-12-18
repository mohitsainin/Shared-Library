def call() {
    withSonarQubeEnv('Sonar') {
        def scannerHome = tool name: 'Sonar', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
        sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=salary-api \
            -Dsonar.sources=. \
            -Dsonar.host.url=http://65.2.175.160:9000
        """
    }
}
