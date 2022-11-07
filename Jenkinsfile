pipeline {

agent any

stages {


stage('Build Artifact - Maven') {
steps {
sh "mvn clean package -DskipTests=true"
archive 'target/*.jar'

}
}
	
     /*stage ('SonarQuality') {
		steps {
			
                sh "mvn clean verify sonar:sonar -Dsonar.projectKey=SeyfSpring -Dsonar.host.url=http://20.38.35.181:9000 -Dsonar.login=sqp_1f7791e16a0e777c978d531fcb63848bd7e33c6c"
	
		}
	}*/
	
	
	
/*stage('Nexus Stage') {
steps {
	
	
sh 'mvn clean deploy -DskipTests'
sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
	
	
	
}
}  */
	
	
              /*stage('Unit test - Junit and jacoco') {
            steps {
              sh "mvn test"
            }

	      }*/
	
      

stage('Docker Compose') {
       steps {
               sh 'docker-compose up --d --force-recreate '
       }
     }

	
	
  
}                   

}  


