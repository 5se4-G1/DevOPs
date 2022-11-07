import java.text.SimpleDateFormat
pipeline {
    agent any

     environment {
            registry = "fatmabe/devops-project"
            registryCredential = 'dockerhub'
            dockerImage = ''
     }

    stages {

        stage('Checkout GIT') {
            steps {
                echo 'Pulling...';
                git branch: 'fatma',
                url : 'https://github.com/5se4-G1/DevOPs.git'
            }
        }

        stage('Date') {
                steps {
                     script{
                     def date = new Date()
                     sdf = new SimpleDateFormat("MM/dd/yyyy")
                     println(sdf.format(date))
                             }
                             }
                             }

      
        stage('Building our image') {
               steps{
                        script {
                            dockerImage = docker.build registry + ":$BUILD_NUMBER"
                        }
               }
        }

       stage('Docker images'){
               steps{
                        sh 'docker images'
               }
        }


         stage('Deploy our image') {
               steps {
                        script {
                            docker.withRegistry( '', registryCredential ) {
                                dockerImage.push()
                            }
                        }
               }
         }

         stage('Cleaning up') {
               steps {
                         sh "docker rmi $registry:$BUILD_NUMBER"
               }
         }

          stage('DOCKER COMPOSE') {
                steps {
                            sh 'docker-compose up -d --build'
                }
          }

         
     }


 }
