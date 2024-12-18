def call(String mavenToolName = 'Maven') {
    script {
       
        def mvnHome = tool mavenToolName
        echo "Maven Home: ${mvnHome}"
        sh "${mvnHome}/bin/mvn compile"
       
        sh "${mvnHome}/bin/mvn org.owasp:dependency-check-maven:check -Dformat=HTML -DoutputDirectory=target/dependency-check-report"
   
        sh 'ls -R target'
      
        archiveArtifacts artifacts: 'target/dependency-check-report/dependency-check-report.html', allowEmptyArchive: false
        echo "Dependency check report archived successfully."
    }
}
