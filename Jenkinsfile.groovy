pipeline {

    agent any

    stages {
        stage('Очистка') {
            cleanWs()
        }
        stage('Build process') {
            withMaven(jdk: 'jdk', maven: 'maven') {
                // some block
                sh "mvn clean test -Dtags=${PARAM}"
            }
        }
        stage('Allure report generation') {
            allure includeProperties: false,
                    jdk: 'jdk',
                    report: 'target/allure-report',
                    results: [[path: 'target/allure-results']]
        }
    }
}