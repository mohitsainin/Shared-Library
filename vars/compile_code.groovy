def call(String mavenToolName) {
    script {
       
        def mvnHome = tool mavenToolName
        sh "${mvnHome}/bin/mvn compile"
    }
}
