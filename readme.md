Тестовое задание по поиску википедии
Дукуев Умалат

В файле AppTest.java поменять путь к файлу msedgedriver.exe 
# System.setProperty("webdriver.edge.driver", "ваш путь");

запуск одного теста: mvn -Dtest=AppTest#testWikipediaPage_1 test

запуск нескольких тестов: mvn -Dtest=AppTest#testWikipediaPage_1,AppTest#testWikipediaPage_2 test

запуск всех тестов: mvn test