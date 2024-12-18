def call(String mavenToolName) {
    script {
        def mvnHome = tool mavenToolName
        sh "${mvnHome}/bin/mvn compile"
        
        // Generate the compilation report
        sh """
            echo "Compilation Report" > target/compile-report.txt
            echo "Maven compile phase completed successfully." >> target/compile-report.txt
            if [ -d target/classes ] && [ "$(ls -A target/classes)" ]; then
                echo "Compilation was successful. Classes are available." >> target/compile-report.txt
            else
                echo "Compilation failed. No compiled classes found." >> target/compile-report.txt
            fi
        """
    }
}
