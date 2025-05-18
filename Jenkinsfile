pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/your-user/springboot-react-ci-cd.git'
            }
        }

        stage('Build React Frontend') {
            steps {
                dir('frontend') {
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }

        stage('Build Spring Boot Backend') {
            steps {
                dir('backend') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Deploy') {
            steps {
                sh 'cp -r frontend/build/* /home/ec2-user/app/frontend/'
                sh 'cp backend/target/*.jar /home/ec2-user/app/backend/app.jar'
                sh 'nohup java -jar /home/ec2-user/app/backend/app.jar --server.port=8081 > /home/ec2-user/app/backend/log.txt 2>&1 &'
            }
        }
    }
}