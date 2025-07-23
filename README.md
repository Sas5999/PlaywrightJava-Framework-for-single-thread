# PlaywrightJava-Framework-for-single-thread
Web automations framework - Playwright . For single thread execution
rm -rf target/allure-results target/allure-report
mvn clean test -Dallure.results.directory=target/allure-results
allure serve target/allure-results