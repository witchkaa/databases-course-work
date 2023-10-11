# Проєктування бази даних

## Модель бізнес-об'єктів 

@startuml

entity User

entity User.nickname
entity User.email
entity User.photo
entity User.password
entity User.isBanned

User.nickname -d-* User
User.email -u-* User
User.photo -r-* User
User.password -d-* User
User.isBanned -u-* User

entity Member
Member "0,*" -l- "1,1" User

entity Role
Member "0,*" -d- "1,1" Role

entity Grant
Grant "1,*" -u- "0,*" Role

entity Team
Team "0,1" -u- "1,*" Member

entity Project
Project "1,1" -d- "0,*" Team
Project "1,1" -l- "0,*" Member

entity Project.name
entity Project.description

Project.name -d-* Project
Project.description -d-* Project
Project "0,*" -o "0,1" Project

entity Task
entity Assignment

Task "1,1" -d- "0,*" Assignment
Member "1,1" -u- "0,*" Assignment

entity Task.name
entity Task.description
entity Task.deadline
entity Tag
entity Task.comment

Task.name -d-* Task
Task.description -d-* Task
Task.deadline -d-* Task

Tag "1,1" -l- "0,*" Task

Task.comment "0,*" -l- "1,1" Task
Task.comment "0,*" - "1,1" Member :author

entity Sprint

Sprint "0,1" -r- "1,*" Task

entity Sprint.name
entity Sprint.goal
entity Sprint.startdate
entity Sprint.enddate

Sprint.name -d-* Sprint
Sprint.goal -d-* Sprint
Sprint.startdate -d-* Sprint
Sprint.enddate -d-* Sprint

@enduml

## ER-модель
## Реляційна схема

![Реляційна схема](https://github.com/Yana-Koroliuk/databases-course-work/assets/59470968/e63ec3a6-0e09-4572-948c-4d60da68793b)



