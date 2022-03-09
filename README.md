# Hotel demo application rest api app using SPRINGBOOT 

## Set Up
* `mvn compile` (compile all the code)
* `mvn test` (compile and run the tests)
* `mvn package` (package the entire project)
* `mvn clean` (delete the compiled code and packages)
* `mvn clean package` (delete all, compile, run tests, package)

**I have created tunnel from dev.cs.smu.ca to local machine since database was not accessible from local machine.**
This application uses Springboot framework for developing the resp api for getting and creating the entries in the hotel details tables.
Below is the list of api end points 
Sample object : 
`{"hotelname":"TAJ",
"starrating":2.5,
"numberOfRooms":250,
"address":"Agra"
}`
1. GET : http://127.0.0.1:8081/demo/hoteldemo/all It will list all the hotel present in database.
2. http://127.0.0.1:8081/demo/hoteldemo/add    To all new hotel in database 
request body :
   `{
"hotelname":"TAJ",
"starrating":2.5,
"numberOfRooms":250,
"address":"Agra"
}`
response : `{
   "message": "New Hotel created successfully"
   }`
   
3. http://127.0.0.1:8081/demo/hoteldemo/update/{id}
example : http://127.0.0.1:8081/demo/hoteldemo/update/1
Sample object :
`{"hotelname":"TAJ",
"starrating":2.5,
"numberOfRooms":250,
"address":"Agra -1"
} ` 
4. http://127.0.0.1:8081/demo/hoteldemo/delete/{id} 
example : http://127.0.0.1:8081/demo/hoteldemo/delete/1





