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
            sh 'docker build -t mobilestore:$BUILD_NUMBER .'
        }
        }
        stage('Deploy to dev'){
            steps{
                echo "Deploying to dev environment"
                sh 'docker rm -f mobile || true'
                sh 'docker run -d --name=mobile -p 8097:8099 mobilestore:$BUILD_NUMBER'
            }
        }
         
    }
}