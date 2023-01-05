pipeline{
    agent any
    stages{
        stage ('building the project'){
            steps{
                echo 'Building the mobilestore application'
                sh 'mvn clean install'
            }
        }
        stage ('buiding the docker image'){
             steps{
            echo 'Docker image Build'
            sh 'docker build -t mobilestore .'
        }
        }
        stage('Sonarqube'){
      steps{
        echo "Sonarqube codequality"
        sh '''
	     	mvn clean verify sonar:sonar \
                -Dsonar.projectKey=Mobilestore \
                -Dsonar.host.url=http://40.122.113.201:9000 \
                -Dsonar.login=sqp_6a5faccb812c93f281cc14bbcf82cf9b27000170
		    '''  
      }
    } 
        stage('Deploy to dev'){
            steps{
                echo "Deploying to dev environment"
                sh 'docker rm -f mobile || true'
                sh 'docker run -d --name=mobile -p 9001:8099 mobilestore'
            }
        }

         
    }
}