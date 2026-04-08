pipeline {
    agent any

    stages {

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat '"C:\\Program Files\\Docker\\Docker\\resources\\bin\\docker.exe" build -t greeting-api .'
            }
        }

        stage('Stop Old Container') {
            steps {
                bat 'docker stop greeting-api || exit 0'
                bat 'docker rm greeting-api || exit 0'
            }
        }

        stage('Run Container') {
            steps {
                bat 'docker run -d -p 8085:8080 greeting-api'
            }
        }
    }
}
