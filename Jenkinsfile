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

         
    }
}