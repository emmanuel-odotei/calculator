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
        stage('Maven Install') {
            agent {
                docker  {
                    image 'maven:3.9.6-sapmachine-17'
                }
            }
        }

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

//         stage('Push Docker Image') {
//             steps {
//                 script {
//                     docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-credentials') {
//                         docker.image("${DOCKER_IMAGE}:${DOCKER_TAG}").push()
//                     }
//                 }
//             }
//         }

//         stage('Clean Up') {
//             steps {
//                 script {
//                     docker.image("${DOCKER_IMAGE}:${DOCKER_TAG}").remove()
//                 }
//             }
//         }
    }
}
