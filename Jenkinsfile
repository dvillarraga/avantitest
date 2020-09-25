pipeline {
  agent {
    dockerfile true
  }
  stages {
    stage('build'){
      steps{
        echo 'Building'
        sh './gradlew clean build'
      }
    }
  }
}