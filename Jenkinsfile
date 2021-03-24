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
                sh "./gradlew clean"
            }
        }
//         stage('Test') {
//             steps {
//                 sh './gradlew test'
//             }
//         }
        stage('Clean All Containers') {
            steps {
                sh 'docker ps -a -q --filter "name=/bureau-orchestrator"'
                sh 'docker image prune -a --force --filter "name=/bureau-orchestrator"'
            }
        }
        stage('Deploy container') {
            steps {
                sh './gradlew --no-daemon assemble docker dockerRun'
            }
        }
        stage('Check running image') {
            steps {
                sh 'docker images'
                sh 'docker ps'
            }
        }
    }
}
