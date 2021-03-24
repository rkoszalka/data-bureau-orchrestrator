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
        stage('Clean All Containers') {
            steps {
                sh 'docker container kill $(docker ps -q)'
                sh 'docker rm $(docker ps -q)'
            }
        }
        stage('Deploy container') {
            steps {
                sh './gradlew --no-daemon assemble docker dockerRun'
            }
        }
    }
}
