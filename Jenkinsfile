import java.text.SimpleDateFormat
pipeline {
    agent any

     environment {
            registry = "fatmabe/devops-project"
            registryCredential = 'dockerHub'
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
   stage('MVN CLEAN'){
            steps{
                sh  'mvn clean'
            }
        }

        stage('MVN COMPILE'){
            steps{
                sh  'mvn compile'
            }
        }

        stage('MVN PACKAGE'){
              steps{
                  sh  'mvn package'
              }
        }
      
        stage('Building our image') {
               steps{
                        script {
                            dockerImage = docker.build registry + ":latest"
                        }
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

      
          stage('DOCKER COMPOSE') {
                steps {
                            sh 'docker-compose up -d --build'
                }
          }

         
     }


 }
