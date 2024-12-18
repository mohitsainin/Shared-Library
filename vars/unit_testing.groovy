def call(String mavenToolName) {
    script {
       
        def mvnHome = tool mavenToolName
             
        sh "${mvnHome}/bin/mvn compile"
        sh "${mvnHome}/bin/mvn test | tee target/unit-test-report.txt"      
        
    }
}
