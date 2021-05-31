pipeline {
    agent any

    stages {
        stage('Execution rights') {
            steps {
                sh 'chmod +x gradlew'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew clean test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}