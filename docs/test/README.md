# Тестування працездатності системи

Для тестування проєкту був використаний Postman – HTTP-клієнт для тестування API.

# Операції з Task
## Початкове наповнення БД
![Початкове наповнення БД](img/start_task.png)
## Додати Task
![Додати Task](https://github.com/witchkaa/databases-course-work/blob/master/docs/test/img/post_task1.png)
## Отримати усі Task
![Отримати усі Task](img/get_tasks2.png)
## Відредагувати Task
![Відредагувати Task](img/patch_task3.png)
## Отримати Task за ID
![Отримати Task за ID](img/get_task_by_id_4.png)
## Видалити Task
![Видалити Task](img/delete_task5.png)
## Після видалення Task з ID 4 більше нема у таблиці
![Після видалення Task з ID 4 більше нема у таблиці](img/no_task_4_after_delete6.png)

# Операції з Tag
## Початкове наповнення БД
![Початкове наповнення БД](img/start_tag.png)
## Додати Tag
![Додати Tag](img/post_tag7.png)
## Отримати усі Tag
![Отримати усі Tag](img/get_tags8.png)
## Отримати Tag за ID
![Отримати Tag за ID](img/get_tag_by_id9.png)
## Відредагувати Tag
![Відредагувати Tag](img/patch_tag10.png)
## Отримаємо щойно відредагований Tag
![Отримаємо щойно відредагований Tag](img/get_tag_after_patch11.png)
## Видалити Tag
![Видалити Tag](img/delete_tag12.png)
## Після видалення тегу з ID 3 більше немає
![Після видалення тегу з ID 3 більше немає](img/no_tag3_after_delete13.png)

# Операції з Label
## Початкове наповнення БД
![Початкове наповнення БД](img/start_label.png)
## Додати Label
![Додати Label](img/post_label14.png)
## Отримати всі Label
![Отримати всі Label](img/get_labels15.png)
## Отримати усі Label за Task_ID
![Отримати усі Label за Task_ID](img/getLabelsByTask16.png)
## Отримати усі Label за Tag_ID
![Отримати усі Label за Tag_ID](img/getLabelsByTag17.png)
## Отримати Label за Task_ID та Tag_ID
![Отримати Label за Task_ID та Tag_ID](img/getLavelByTaskAndTag18.png)
## Відредагувати Label
![Відредагувати Label](img/patch_label19.png)
## Видалити Label
![Видалити Label](img/delete_label20.png)