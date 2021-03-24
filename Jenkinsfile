pipeline {
    agent any

    tools {
        jdk 'java11'
    }

    stages {
        stage('Build') {
            steps {
                sh './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Docker image') {
            steps {
                sh './gradlew assemble docker'
            }
        }
        stage('Deploy container') {
            steps {
                sh './gradlew assemble docker dockerRun'
            }
        }
    }
}
