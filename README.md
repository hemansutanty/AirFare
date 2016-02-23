#AirFare

This is simple Flight Ticket Management system which is built based on Java RMI. 
The GUI is built using Java Swing.


###Steps to Execute the AirFare App(Windows)

1. Download Postgres Sql database.Keep Default configurations and set password as password.(database-postgres,user-postgres,port-5432,password-password)
2. Run the Create table scripts on the postgres shell. Run the Insert Statement scripts on Postgres shell.
3. Download the App zip and Extract it.
4. Navigate inside server folder and open a command prompt there.(Shift+Right Click).
5. Type "start rmiregistry" and press Enter.
6. Minimize the popped up window.
7. Type "java -cp .;postgresql-9.4.1208.jre6.jar AirlinesMain" and press Enter. Minimize this commandprompt too.
8. Navigate inside the client folder and open a command prompt there.(Shift+Right Click).
9. Type java Welcome.
10. Follow the steps accordingly on the Interface to book tickets.