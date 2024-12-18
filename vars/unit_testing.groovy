def call(String mavenToolName) {
    script {
       
        def mvnHome = tool mavenToolName
             
        sh "${mvnHome}/bin/mvn compile"
              
        sh "${mvnHome}/bin/mvn test | tee unit-test-report.txt"
    }
}
