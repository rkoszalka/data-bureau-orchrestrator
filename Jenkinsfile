pipeline {
    agent any

    tools {
        jdk 'java11'
    }

    stages {
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
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
