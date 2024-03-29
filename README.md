# Курс Алгоритмы и структуры данных

## [Семинар 1 - Алгоритмы. Сложность алгоритмов](seminar_1/Seminar.java)
### Задание 1
Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N. Согласно свойствам линейной сложности, количество итераций цикла будет линейно изменяться относительно изменения размера N.
### Задание 2
Написать алгоритм поиска простых чисел (делятся только на себя и на 1) в диапазоне от 1 до N. В алгоритме будет использоваться вложенный for, что явно говорит о квадратичной сложности, на этом стоит акцентировать внимание
### Задание 3
1. Необходимо написать алгоритм поиска всех доступных комбинаций (посчитать количество) для количества кубиков K с количеством граней N.
2. У вас есть 2 варианта на выбор – количество кубиков может быть строго ограничено (4 кубика, например), либо их количество будет динамическим. Выбор за вами. 
3. Если вы реализуете простой вариант, обращает внимание, что данное решение имеет сложность O(n4), но если количество кубиков сделать переменной, то она трансформируется в O(nk), что будет представлять собой экспоненциальную сложность. Для второго решения очевидно, что его сложность O(nk) с самого начала.
### Задание 4
1. Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
2. Считаем, что 1 и 2 значения последовательности равны 1. 
3. Искать будем по формуле On=On-1+On-2 что предполагает использовать рекурсивного алгоритма.

## [Семинар 2 - Структуры данных. Массивы. Алгоритмы массивов.](seminar_2/Seminar2.java)
### Задание 1
1. Необходимо написать один из простых алгоритмов сортировки, имеющий сложность O(n2).
2. Можно выбрать из пузырьковой сортировки, сортировки вставками и сортировки выбором. 
3. Следует обратить внимание на сложность данных алгоритмов и указать признаки квадратичной сложности для каждого из них.
### Задание 2
1. Написать алгоритм быстрого поиска (quicksort).
### Задание 3
1. Пишем тесты для сравнения производительности сортировки больших массивов. 
2. Для наглядного результата стоит сравнивать массивы до 100 000 элементов. При таком подходе будет явно видно, какая из сортировок окажется быстрее.
### Задание 4
1. После успешной сортировки массива на нем можно использовать бинарный поиск. Необходимо реализовать алгоритм бинарного поиска по элементам. 
2. Стоит акцентировать внимание, что т.к. алгоритм использует подход «разделяй и властвуй», его удобно писать с помощью рекурсии.
3. Так что стоит акцентировать внимание на алгоритмическую сложность данного алгоритма, что его выполнение многократно быстрее простого перебора на больших массивах

## [Домашнее задание 2](seminar_2/HW_2.java)
Реализовать алгоритм пирамидальной сортировки (сортировка кучей).

## [Семинар 3 - Структуры данных. Связный список.](seminar_3)
### [Задание 1](seminar_3/ListUno.java)
1. Реализуем простой односвязный список
2. Реализуем метод добавления новых элементов в начало списка и удаление первого элемента связного списка.
3. Реализуем метод поиска элемента в односвязном списке для проверки наличия элемента внутри списка.
4. Реализуем метод добавления новых элементов в конец списка и удаление последнего элемента связного списка.
### [Задание 2](seminar_3/ListDuo.java)
1. Расширяем структуру связного списка до двухсвязного.
2. Обновляем методы согласно новой структуре.

## Домашнее задание 3
Необходимо реализовать метод разворота связного списка ([двухсвязного](seminar_3/ListDuo.java) или [односвязного](seminar_3/ListUno.java)).

## [Семинар 4 - Структуры данных дерево и хэш-таблица.](seminar_4)
### [Задание 1](seminar_4/HashTable.java)
1. Начинаем реализацию хэш таблицы с подготовки структуры и необходимых классов
2. Давайте напишем реализацию односвязного списка, в котором мы и будем хранить пары ключ значение
3. Добавляем массив связных списков с фиксированным размером (массив бакетов), либо передаваемым в конструкторе.
4. Реализуем метод поиска данных по ключу в хэш таблице.
5. Теперь, когда у нас есть базовая структура нашей хэш таблицы, можно написать алгоритм поиска элементов, включающий в себя поиск нужного бакета и поиск по бакету.
6. Необходимо реализовать методы добавления элементов в связный список, если там еще нет пары с аналогичным ключом и удаления элемента с аналогичным ключом из списка.
7. Реализуем алгоритм добавления и удаления элементов из хэш таблицы по ключу.
8. Добавляем информацию о размере хэш таблицы, а также алгоритм увеличения количества бакетов при достижении количества элементов до определенного размера относительно количества бакетов (load factor). Чтобы хэш таблица сохраняла сложность поиска близкой к O(1), нам необходимо контролировать количество бакетов, чтобы в них не
скапливалось слишком много элементов, которые способны увеличить длительность операции поиска и добавления.
### [Задание 2](seminar_4/BinaryTree.java)
Реализуем структуру бинарного дерева. Для бинарного дерева характерно наличии двух потомков, где левый меньше родителя, а правый больше.

## [Домашнее задание 4](seminar_4/RedBlackBinaryTree.java)
1. Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно черное дерево. И реализовать в нем метод добавления новых элементов с балансировкой.
2. Красно черное дерево имеет следующие критерии:
* Каждая нода имеет цвет (красный или черный)
* Корень дерева всегда черный
* Новая нода всегда красная
* Красные ноды могут быть только левым ребенком
* У красной ноды все дети черного цвета
2. Соответственно, чтобы данные условия выполнялись, после добавления элемента в дерево необходимо произвести балансировку, благодаря которой все критерии выше станут валидными.
3. Для балансировки существует 3 операции левый малый поворот, правый малый поворот и смена цвета.
