pipeline{
    environment{
    registry = "skillassure/firstimage"
    registryCredential = "Docker-Hub-Auth"
    dockerImage = ''
  }
    agent any
    
     stages {
       stage('Gitlab'){                
                steps{
			git branch: 'main', credentialsId: 'my_personal_git_hub', url: 'https://github.com/basavarajbhavi/Mobile-Store-.git'		
            }
        }
      stage('build the project') {
         steps {
          echo 'building the project'
          sh 'mvn clean install -DskipTests'
        //sh 'mvn clean install'
       
      }
    }
     stage('Build docker image'){
      steps{
        echo "Building docker image"
        script{
          dockerImage = docker.build registry + ":$BUILD_NUMBER" 
        }
      }
    }
    stage('Push docker image'){
      steps{
        echo "Pushing docker image"
        script{
           docker.withRegistry('',registryCredential) {
            dockerImage.push()
            dockerImage.push('latest')
          }
        }
      }      
    }
         
     }
     
}
