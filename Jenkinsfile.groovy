pipeline {

    agent any

    stages {
        stage('Передаваемый параметр') {
            steps {
                echo "${BRANCH}"
            }
        }
        stage('Build process') {
            steps {
                withMaven(jdk: 'jdk8', maven: 'maven') {
                    sh "mvn clean test ${PARAM}"
                }
            }
        }
        stage('Allure report generation') {
            steps {
                allure includeProperties: false,
                        jdk: 'jdk',
                        report: 'target/allure-report',
                        results: [[path: 'target/allure-results']]
                }
            }
        }
    }