pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDENTIALS = 'dockerhub-credentials'
        DOCKER_IMAGE_NAME = 'niicloud/calculator'
    }

    tools {
        maven 'maven_3'
    }

    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', changelog: false, url: 'https://github.com/emmanuel-odotei/calculator.git'
            }
        }
        stage('Build Docker Image') {
            steps {
               sh 'docker build -t ${DOCKER_IMAGE_NAME} .'
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                     // Login to Docker Hub
                    withCredentials([usernamePassword(credentialsId: DOCKER_HUB_CREDENTIALS, passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
                        sh "docker login -u $DOCKER_HUB_USERNAME -p $DOCKER_HUB_PASSWORD"
                    }

                    // Push the Docker image to Docker Hub
                    sh "docker push $DOCKER_IMAGE_NAME"
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
