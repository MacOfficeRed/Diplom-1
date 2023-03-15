# Дипломный проект Задание 1
## Юнит-тесты
Представь: нужно протестировать программу, которая помогает заказать бургер в Stellar Burgers. Тебе предстоит покрыть её юнит-тестами.
Здесь пригодятся моки, стабы и параметризация: где именно их использовать, реши самостоятельно.

Что нужно сделать
Склонируй репозиторий с заготовкой кода.
Подключи библиотеки: Jacoco, Mockito, JUnit 4.
Покрой тестами классы Bun, Burger, Ingredient, IngredientType. Используй моки, стабы и параметризацию там, где нужно.
Процент покрытия должен быть не ниже 70%.

## Технологии, используемые в данном проекте
В данном проекте тесты написаны на **Java 11** с использованием фреймворка для тестирования **Selenide**. 
**JUnit5** задействован в качестве фреймворка модульного тестирования. Запуск тестов выполняется из **Jenkins**. **Selenoid** используется для запуска браузеров в контейнерах **Docker**.
Для сборки проекта используется **Maven**.
Процент покрытия кода тестами рассчитывается с помощью **Jacoco**

## Запуск тестов
Для запуска тестов в консоли, нужно выполнить команду
``mvn clean test``

## Просмотр отчёта
Статистики покрытия кода тестами находится в файле
_target/site/jacoco/index.html_


