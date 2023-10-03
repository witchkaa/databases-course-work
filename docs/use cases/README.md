# Модель прецедентів

## Загальна схема

<center style="
   border-radius:4px;
   border: 1px solid #cfd7e6;
   box-shadow: 0 1px 3px 0 rgba(89,105,129,.05), 0 1px 1px 0 rgba(0,0,0,.025);
   padding: 1em;"
>


@startuml

    skinparam noteFontColor white

    actor "Робітник" as Collaborator


    usecase "<b>SignIn</b>\nЗареєструватися" as SignIn
    usecase "<b>LogIn</b>\nУвійти в систему" as LogIn
    usecase "<b>TaskManage</b>\nКерувати завданнями" as TaskManage
    usecase "<b>EditUser</b>\nРедагувати дані користувача" as EditUser


    Collaborator -r-> SignIn
    Collaborator -u-> LogIn
    Collaborator -l-> TaskManage
    Collaborator -u-> EditUser




    note bottom of Collaborator  #4e4e4e

       Робітник може у повній мірі керувати лише <b>власними завданнями</b>
       та на призначених йому завданнях він має можливість тільки
       <b>змінювати статус</b> (todo/in progress/done/in rewiew).
       <b>Фільтрувати</b> та <b>коментувати</b> робітник може <b>всі</b>
       <b>завдання проекту</b>.
       Робітник може у повній мірі виконувати дії над всіма Task'ами у випадку,
       коли в проєкті <b>НЕМАЄ ТІМЛІДА</b>

    end note

actor "Тімлід" as Teamlead

    usecase "<b>ProjectManage</b>\nКерувати проектом" as ProjectManage
    usecase "<b>SprintManage</b>\nКерувати спринтом" as SprintManage
    usecase "<b>TeamManage</b>\nКерувати командою" as TeamManage


    Teamlead -> ProjectManage
    Teamlead -d-> SprintManage
    Teamlead -l-> TeamManage
    Teamlead -u-|> Collaborator

    actor "Адміністратор системи" as Admin

    usecase "<b>DataManage</b>\nКерувати даними системи" as DataManage

    Admin --> DataManage
    Admin -u-|> Teamlead

@enduml


</center>

## Робітник

<center style="
   border-radius:4px;
   border: 1px solid #cfd7e6;
   box-shadow: 0 1px 3px 0 rgba(89,105,129,.05), 0 1px 1px 0 rgba(0,0,0,.025);
   padding: 1em;"
>


@startuml

    skinparam noteFontColor white

    actor "Робітник" as Collaborator

    usecase "<b>SignIn</b>\nРеєстрація" as SignIn
    usecase "<b>UserSignIn</b>\nРеєстрація користувача" as UserSignIn
    usecase "<b>UserGitHubSignIn</b>\nРеєстрація користувача за допомогою GitHub" as UserGitHubSignIn
    usecase "<b>LogIn</b>\nВхід" as LogIn
    usecase "<b>UserLogIn</b>\nВхід користувача" as UserLogIn
    usecase "<b>UserGitHubLogIn</b>\nВхід користувача за допомогою GitHub" as UserGitHubLogIn
    usecase "<b>EditUser</b>\nРедагувати дані користувача" as EditUser
    usecase "<b>TaskManage</b>\nКерувати завданнями" as TaskManage
    usecase "<b>CreateTask</b>\nСтворити завдання" as CreateTask
    usecase "<b>EditTask</b>\nРедагувати завдання" as EditTask
    usecase "<b>DeleteTask</b>\nВидалити завдання" as DeleteTask
    usecase "<b>FilterTask</b>\nВідфільтрувати завдання" as FilterTask
    usecase "<b>CommentTask</b>\nКоментувати завдання" as CommentTask

    Collaborator -l-> SignIn
    SignIn <.u. UserGitHubSignIn:extends
    SignIn <.d. UserSignIn:extends
    Collaborator -r-> LogIn
    LogIn <.u. UserGitHubLogIn:extends
    LogIn <.d. UserLogIn:extends
    Collaborator --d-> EditUser
    Collaborator -u-> TaskManage
    TaskManage <.u. CommentTask:extends
    TaskManage <.u. FilterTask:extends
    TaskManage <.u. DeleteTask:extends
    TaskManage <.u. EditTask:extends
    TaskManage <.u. CreateTask:extends

    note bottom of Collaborator #4e4e4e

       Робітник може у повній мірі керувати лише <b>власними завданнями</b>
       та на призначених йому завданнях він має можливість тільки
       <b>змінювати статус</b> (todo/in progress/done/in rewiew).
       <b>Фільтрувати</b> та <b>коментувати</b> робітник може <b>всі</b>
       <b>завдання проекту</b>.
       Робітник може у повній мірі виконувати дії над всіма Task'ами у випадку,
       коли в проєкті <b>НЕМАЄ ТІМЛІДА</b>

    end note

@enduml


</center>

## Тімлід

## Адміністратор системи

<center style="
   border-radius:4px;
   border: 1px solid #cfd7e6;
   box-shadow: 0 1px 3px 0 rgba(89,105,129,.05), 0 1px 1px 0 rgba(0,0,0,.025);
   padding: 1em;"
>


@startuml

    actor "Адміністратор системи" as Admin
    usecase "<b>DataManage</b>\nКерувати даними системи" as DataManage
    usecase "<b>BanUser</b>\nЗаблокувати користувача" as BanUser
    usecase "<b>UnBanUser</b>\nРозблокувати користувача" as UnBanUser
    usecase "<b>UserSupport</b>\nВирішити проблему користувача" as UserSupport

    Admin -d-> DataManage
    Admin -u-> UserSupport
    BanUser .u.> DataManage:extends
    UnBanUser .u.> DataManage:extends

@enduml

</center>


**Діаграма прецедентів**

яка буде відображена наступним чином


<center style="
    border-radius:4px;
    border: 1px solid #cfd7e6;
    box-shadow: 0 1px 3px 0 rgba(89,105,129,.05), 0 1px 1px 0 rgba(0,0,0,.025);
    padding: 1em;"
>

@startuml

    right header
        <font size=24 color=black>Package: <b>UCD_3.0
    end header

    title
        <font size=18 color=black>UC_8. Редагувати конфігурацію порталу
        <font size=16 color=black>Діаграма прецедентів
    end title


    actor "Користувач" as User #eeeeaa
    
    package UCD_1{
        usecase "<b>UC_1</b>\nПереглянути список \nзвітів" as UC_1 #aaeeaa
    }
    
    usecase "<b>UC_1.1</b>\nЗастосувати фільтр" as UC_1.1
    usecase "<b>UC_1.2</b>\nПереглянути метадані \nзвіту" as UC_1.2  
    usecase "<b>UC_1.2.1</b>\nДати оцінку звіту" as UC_1.2.1  
    usecase "<b>UC_1.2.2</b>\nПереглянути інформацію \nпро авторів звіту" as UC_1.2.2
    
    package UCD_1 {
        usecase "<b>UC_4</b>\nВикликати звіт" as UC_4 #aaeeaa
    }
    
    usecase "<b>UC_1.1.1</b>\n Використати \nпошукові теги" as UC_1.1.1  
    usecase "<b>UC_1.1.2</b>\n Використати \nрядок пошуку" as UC_1.1.2
    usecase "<b>UC_1.1.3</b>\n Використати \nавторів" as UC_1.1.3  
    
    
    
    User -> UC_1
    UC_1.1 .u.> UC_1 :extends
    UC_1.2 .u.> UC_1 :extends
    UC_4 .d.> UC_1.2 :extends
    UC_1.2 .> UC_1.2 :extends
    UC_1.2.1 .u.> UC_1.2 :extends
    UC_1.2.2 .u.> UC_1.2 :extends
    UC_1 ..> UC_1.2.2 :extends
    
    
    UC_1.1.1 -u-|> UC_1.1
    UC_1.1.2 -u-|> UC_1.1
    UC_1.1.3 -u-|> UC_1.1
    
    right footer
        Аналітичний портал. Модель прецедентів.
        НТУУ КПІ ім.І.Сікорського
        Киів-2020
    end footer

@enduml

**Діаграма прецедентів**

</center>

