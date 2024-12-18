def call() {
       sh 'mvn test' | tee unit-test-report.txt'
    }
