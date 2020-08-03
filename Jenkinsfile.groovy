pipeline {

    agent any

    stages {
        stage('Очистка') {
            cleanWs notFailBuild: true
        }
        stage('Build process') {
            withMaven(jdk: 'jdk8', maven: 'maven') {
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