pipeline {

agent any

stages {


stage('Build Artifact - Maven') {
steps {
sh "mvn clean package -Dmaven.test.skip=true"
archive 'target/*.jar'
}
}

  stage('Nexus Stage') {
steps {
	
	
sh 'mvn clean deploy -DskipTests'
sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
	
	
}
}  
}
}
