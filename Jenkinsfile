pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDENTIALS = 'dockerhub-credentials'
    }

    tools {
        maven 'maven_3'
    }

    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', changelog: false, url: 'https://github.com/emmanuel-odotei/calculator.git'

                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
               sh 'docker build -t calculator:latest .'
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                     // Login to Docker Hub
                    withDockerRegistry(credentialsId: DOCKER_HUB_CREDENTIALS) {
                    // Push the Docker image to Docker Hub
                    sh "docker push niicloud/calculator:latest"
                    }
                }
            }
        }
        stage('Clean Up') {
            steps {
                script {
                    docker.image("${DOCKER_IMAGE}:${DOCKER_TAG}").remove()
                }
            }
        }
    }
}
