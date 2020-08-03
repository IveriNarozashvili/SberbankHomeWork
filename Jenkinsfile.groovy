pipeline {

    agent any

    stages {
        stage('Build process') {
            steps{
                withMaven(jdk: 'jdk', maven: 'maven') {
                    // some block
                    bat "mvn clean test -Dtags=${PARAM}"
                }
            }

        }
        stage('Allure report generation') {
            steps{
                allure includeProperties: false,
                        jdk: 'jdk',
                        report: 'target/allure-report',
                        results: [[path: 'target/allure-results']]
            }
            }

    }
}