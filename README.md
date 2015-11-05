# sale-store-api

Инструкция по сборке приложения.

CODE/backend - REST сервиса (Spring+ Hibernate)

CODE/frontend - Vaadin клиент

Для backend части настроить базу данных в файле
CODE\backend\src\main\resources\beans.xml

1. Собрать backend и frontend war приложения с помощью Maven
2. Установить на Tomcat (Apache Tomcat/8.0.27)
3. Настроить ContextRoot

Сервиса:

список продуктов
http://localhost:8080/salestoreapi-backend-1.0/salestoreapi/product/list

для добавления нового продукта не нужно указывать id (/product/save/&name&price)
http://localhost:8080/salestoreapi-backend-1.0/salestoreapi/product/save/&PRODUCT_NAME&345

для обновления существующего продукта нужно указать id (/product/save/id&name&price)
http://localhost:8080/salestoreapi-backend-1.0/salestoreapi/product/save/567&PRODUCT_NAME_1&1000







