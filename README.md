# Selenide + Allure + Cucumber web tests

## Allure installation
1. Download the latest version as zip archive from Maven Central or https://github.com/allure-framework/allure2/releases/latest.
2. Unpack the archive to allure-commandline directory.
3. Navigate to bin directory.
4. Use allure.bat for Windows or allure for other Unix platforms.
5. Add allure to system PATH.
or
` curl -o allure-2.13.0.tar.gz -Ls https://github.com/allure-framework/allure2/archive/2.13.0.tar.gz   
 sudo tar -zxvf allure-2.13.0.tar.gz -C /opt/   
 sudo ln -s /opt/allure-2.13.0/bin/allure /usr/bin/allure
`
## Maven installation (Linux)
* First, change your working directory to the /opt/ directory: cd /opt/
* You can download the latest stable version of Apache Maven from the official website:
`
sudo wget https://www-us.apache.org/dist/maven/maven-3/3.6.0/binaries/apache-maven-3.6.0-bin.tar.gz
`
* Once the download has completed, extract the downloaded archive:
`
sudo tar -xvzf apache-maven-3.6.0-bin.tar.gz
`
* Next, rename the extracted directory:
 `sudo mv apache-maven-3.6.0 maven` 
##Setup environment variables(Linux)
* Next, you will need to setup the environment variables such as M2_HOME,
JAVA_HOME and PATH. You can do this by creating a mavenenv.sh file inside of the /etc/profile.d/ directory: 
`
sudo vi /etc/profile.d/mavenenv.sh
`
* Add the following lines:

`export JAVA_HOME=/usr/lib/jvm/default-java`

`export M2_HOME=/opt/maven`

`export PATH=${M2_HOME}/bin:${PATH}`

* Save and close the file, and make it executable:
sudo chmod +x /etc/profile.d/mavenenv.sh
* Now you can load the environment variables: 
`
source /etc/profile.d/mavenenv.sh
`
###Verify installation
Once everything has been successfully configured, check the version of Apache Maven:
`mvn --version`

## Test running process

### Run a Single Unit Test by Maven
`
mvn "-Dtest=javaClassName#firstTestMethodNameByTag"  test '- running tests by method name (for related test class)
`
### Run a list of jUnit tests by Maven
`
mvn "-Dtest=javaClassName#firstTestMethodName+secondTestMethodName+...."  test '- running tests by method name (for related test class)
`
### To run jUnit tests and generate Allure report use:

For all tests in the module:
`
mvn clean test
`
### To run Cucumber tests and generate Allure report provide CucumberRunner class name as attribute :

For all tests in the module:
`
 mvn clean test "-Dtest=CucumberRunner" 
`
 
For generating project site:
run `mvn site`

### To see a report:

### To generate and see a Allure report
run `allure serve allure-results`

### Headless mode 
`mvn test -Dselenide.headless=true` 
or add 
`
Configuration.headless = true;
`

