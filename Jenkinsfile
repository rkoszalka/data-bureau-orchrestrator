pipeline {
    agent any

    tools {
        jdk 'java11'
    }

    stages {
        stage('Clean') {
            sh "gradle clean"
        }
        stage('Make Gradle Executable') {
            sh "chmod +x gradlew"
        }
//         stage('Build') {
//             steps {
//                 sh './gradlew build'
//             }
//         }
//         stage('Test') {
//             steps {
//                 sh './gradlew test'
//             }
//         }
//         stage('Docker image') {
//             steps {
//                 sh './gradlew assemble docker'
//             }
//         }
        stage('Deploy container') {
            steps {
                sh './gradlew --no-daemon assemble docker dockerRun'
            }
        }
    }
}
