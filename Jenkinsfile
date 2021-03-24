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
                sh """
                  docker ps -a \
                    | awk '{ print \$1,\$2 }' \
                    | grep /bureau-orchestrator \
                    | awk '{print \$1 }' \
                    | xargs -I {} docker rm -f {}
                  """
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
