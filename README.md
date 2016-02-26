#AirFare

A simple Flight ticket Management system built using Java Remote Method Invocation concept where there is a server which is handling all the transactions and database management while the client systems are used to call the functions of the server. 
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

####Initial Collaborators

[Abhishek Jyotishi](https://www.linkedin.com/in/abhishek-jyotishi-a1b10b97?authType=name&authToken=bav3&trk=prof-proj-cc-name)

[Monica Tripathy](https://www.linkedin.com/in/monica-tripathy-53867477?authType=name&authToken=RKl5&trk=prof-proj-cc-name)

###The MIT License (MIT)

Copyright (c) 2016 Hemansu Kumar Tanty

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.