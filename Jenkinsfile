pipeline {
    agent any

    tools {
        jdk 'java11'
    }

    stages {
        stage('Make Gradle Executable') {
            steps {
                sh "chmod +x gradlew"
            }
        }
        stage('Clean') {
            steps {
                sh "gradle clean"
            }
        }
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
