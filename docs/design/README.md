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
@startuml

skinparam entity {
BackgroundColor #f7f711
}

package UserAdministration {
entity User {
isBanned: TINYINT
nickname: TEXT
email: TEXT
password: TEXT
photo: IMAGE
id: INT
}
}

entity Member {
id: NUMBER
}

entity Project {
id: UUID
name: TEXT
description: TEXT
}

entity Team {
id: NUMBER
name: TEXT
motto: TEXT
}

package AccessControl {
entity Role {
id: NUMBER
name: TEXT
description: TEXT
}

entity Grant {
id: NUMBER
action: TEXT
}

object developer
object teamlead
object administrator

developer .u.> Role :instanceOf
teamlead .u.> Role :instanceOf
administrator .u.> Role :instanceOf
}

package TaskManagement {
entity Assignment {
id: NUMBER
datetime: DATETIME
}

entity Task {
id: NUMBER
name: TEXT
description: TEXT
deadline: DATETIME
}

entity Tag {
id: NUMBER
name: TEXT
description: TEXT
}

entity Task_comment {
id: NUMBER
subject: TEXT
text: TEXT
datetime: DATETIME
}

entity Sprint {
id: NUMBER
name: TEXT
goal: TEXT
startdate: DATE
enddate: DATE
}

object done
object in_progress
object todo
object in_review

todo .d.> Tag :instanceOf
in_progress .d.> Tag :instanceOf
done .d.> Tag :instanceOf
in_review .d.> Tag :instanceOf
}

Member "0,*" -d-> "1,1" User
Member "0,*" -r-> "1,1" Project
Team "0,1" --> "1,*" Member
Team "0,*" -d-> "1,1" Project
Member "0,*" --> "1,1" Role
Role "0,*" -l-> "1,*" Grant
Assignment "0,*" -d-> "1,1" Member
Assignment "0,*" -u-> "1,1" Task
Task "0,*" -u-> "1,1" Tag
Task_comment "0,*" -d-> "1,1" Member :author
Sprint "0,1" -> "1,*" Task

@enduml
## Реляційна схема

![Реляційна схема](https://github.com/Yana-Koroliuk/databases-course-work/assets/59470968/e63ec3a6-0e09-4572-948c-4d60da68793b)



