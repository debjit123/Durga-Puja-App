pipeline {
    agent any

    environment {
        BACKEND_DIR = "backend"
        FRONTEND_DIR = "frontend"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/debjit123/Durga-Puja-App'
            }
        }

        stage('Build Backend') {
            steps {
                dir("${BACKEND_DIR}") {
                   sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Frontend') {
            steps {
                dir("${FRONTEND_DIR}") {
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }

        stage('Deploy') {
            steps {
                // kill running app if exists
                sh 'pkill -f "springboot-react-app" || true'

                // run backend
                sh 'nohup java -jar backend/target/*.jar > springboot-react-app.log 2>&1 &'

                // copy React build to nginx (assumes /var/www/html is nginx root)
                sh 'sudo cp -r frontend/build/* /var/www/html/'
            }
        }
    }
}
