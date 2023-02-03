pipeline 
{
    agent any
    
    tools{
    	maven 'maven'
        }

    stages 
    {
        stage('Build') 
        {
            steps{
                echo("Build project")
            }
            
        }
                   
        
        stage("Deploy to QA"){
            steps{
                echo("deploy to qa")
            }
        }
                
        stage('Regression Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/badwenikita/jenkins_AWS.git'
                    sh "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/Test Runners/testng_regression.xml"
                    
                }
            }
        }
                
     
        stage('Publish Allure Reports') {
           steps {
                echo("Publishing Allure Reports")
            }
        }
        
        
        stage('Publish Extent Report'){
            steps{
                    echo("Publishing Extent Reports")
            }
        }
        
        stage("Deploy to Stage"){
            steps{
                echo("deploy to Stage")
            }
        }
        
        stage('Sanity Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/badwenikita/jenkins_AWS.git'
                    sh "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/Test Runners/testng_sanity.xml"
                    
                }
            }
        }
        
        stage('Publish sanity Extent Report'){
            steps{
                     echo("Publishing sanity Extent Report")
            }
        }
        
        
    }
}
