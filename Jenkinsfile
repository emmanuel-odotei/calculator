pipeline {
    agent any

    tools {
            jdk 'jdk17'
            maven 'maven3'
    }

    environment {
            DOCKER_IMAGE = "niicloud/mycalculatorapp"
            DOCKER_TAG = "1.0.0"
    }

    triggers {
            pollSCM('*/5 * * * *')
    }

    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', changelog: false, url: 'https://github.com/emmanuel-odotei/calculator.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build('${DOCKER_IMAGE}:${DOCKER_TAG}', '.') // Build the Docker image for your application
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-credentials') {
                        docker.image("${DOCKER_IMAGE}:${DOCKER_TAG}").push()
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
