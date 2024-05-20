pipeline {
    agent any

    environment {
            DOCKER_IMAGE = "niicloud/calculator"
            DOCKER_TAG = "latest"
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
                    sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} . " // Build the Docker image for your application
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable:
                    'docker-credentialsPassword', usernameVariable: 'docker-credentialsUser')]) {
                              sh "docker login -u ${env.docker-credentialsUser} -p ${env.docker-credentialsPassword}"
                              sh 'docker push niicloud/calculator:latest'
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
