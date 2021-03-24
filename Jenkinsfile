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
                def doc_containers = sh(returnStdout: true, script: 'docker container ps -aq').replaceAll("\n", " ")
                if (doc_containers) {
                    sh "docker stop ${doc_containers}"
                }
                sh 'docker system prune --all --force --volumes'
            }
        }
        stage('Deploy container') {
            steps {
                sh './gradlew --no-daemon assemble docker dockerRun'
            }
        }
    }
}
