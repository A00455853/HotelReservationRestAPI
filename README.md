# Hotel demo application rest api app using SPRINGBOOT 

## Set Up
* `mvn compile` (compile all the code)
* `mvn test` (compile and run the tests)
* `mvn package` (package the entire project)
* `mvn clean` (delete the compiled code and packages)
* `mvn clean package` (delete all, compile, run tests, package)


This application uses Springboot framework for developing the rest api for hotel reservation system.
Below is the list of api end points 
Sample object : Hotel 
`{
"hotelname": "Waynad in",
"starrating": 5.0,
"city": "Waynad",
"country": "India",
"address": "street no 39 waynad"
}`
1. **GET** : http://127.0.0.1:8081/demo/hoteldemo/all It will list all the hotel present in database.
   ![alt text](https://github.com/A00457310/HotelReservationSystem/blob/main/create_hotel.png)
2. **POST** : http://127.0.0.1:8081/demo/hoteldemo/add    To all new hotel in database 
request body :
   `{
   "hotelname": "Waynad in",
   "starrating": 5.0,
   "city": "Waynad",
   "country": "India",
   "address": "street no 39 waynad"
   }`
response : `{
   "message": "New Hotel created successfully"
   }`
   
3. **PUT** : http://127.0.0.1:8081/demo/hoteldemo/update/{id}
example : http://127.0.0.1:8081/demo/hoteldemo/update/1
Sample object :
`{
   "hotelname": "Waynad INN",
   "starrating": 5.0,
   "city": "Waynad",
   "country": "India",
   "address": "street no 39 waynad"
   } ` 
4. **DELETE**:  http://127.0.0.1:8081/demo/hoteldemo/delete/{id} 
example : http://127.0.0.1:8081/demo/hoteldemo/delete/1
   
5. **POST** : http://127.0.0.1:8081/demo/hoteldemo/addRooms/{hotelid}
   Example : http://127.0.0.1:8081/demo/hoteldemo/addRooms/7
   requestbody sample object :
   `{
   "number":"126",
   "price":2000.00
   }`
   Sample response :
   `{
   "id": 7,
   "hotelname": "Mariot Hotel",
   "starrating": 5.0,
   "city": "Halifax",
   "country": "Canada",
   "address": "Darthmouth",
   "rooms": [
   {
   "id": 17,
   "number": "109",
   "price": 2000.0
   },
   {
   "id": 18,
   "number": "110",
   "price": 2000.0
   },
   {
   "id": 19,
   "number": "119",
   "price": 2000.0
   },
   {
   "id": 20,
   "number": "120",
   "price": 2000.0
   },
   {
   "id": 21,
   "number": "121",
   "price": 2000.0
   },
   {
   "id": 22,
   "number": "126",
   "price": 2000.0
   }
   ]
   }`


6. **GET** : http://127.0.0.1:8081/demo/hoteldemo/hoteRoomlListForBooking
Sample object :
   ``{
   "city":"Lucknow",
   "hotelName":"kanpur  Hotel",
   "hotelid":16,
   "checkindate":"2022-03-17",
   "checkoutDate":"2022-03-19"
   }``
   
Sample response : 
`{
"id": 16,
"hotelname": "kanpur  Hotel",
"starrating": 5.0,
"numberOfRooms": 20,
"city": "Lucknow",
"country": "INDIA",
"address": "Agar",
"rooms": [
{
"id": 9,
"number": "101",
"price": 2000.0,
"available": 20
},
{
"id": 10,
"number": "102",
"price": 3000.0,
"available": 20
},
{
"id": 14,
"number": "107",
"price": 7000.0,
"available": 20
}
]
}`


7. **POST** : http://127.0.0.1:8081/demo/hoteldemo/bookRoom
Sample request body:
   `{"room_id":13,
   "userid":7,
   "date_from":"2022-03-15",
   "date_to":"2022-03-20",
   "total_price":20000.00,
   "guestList":[{
   "name":"NITIN User1",
   "gender":"MALE",
   "age":20,
   "email":"email@gmail.com",
   "mobile":"9886122987"
   },
   {
   "name":"NITIN User2",
   "gender":"FEMALE",
   "age":21,
   "email":"email1@gmail.com",
   "mobile":"9886122997"
   },
   {
   "name":"NITIN User3",
   "gender":"MALE",
   "age":20,
   "email":"email2@gmail.com",
   "mobile":"9886122984"
   }]
   }`
   
Sample response body : 
`{
"id": 43,
"user_id": 7,
"room_id": 13,
"date_from": "2022-03-15",
"date_to": "2022-03-20",
"total_price": 20000.0,
"book_ref_num": "e70adcbdebdc4f32a50a10837ff46f9c",
"guests": [
{
"id": 44,
"name": "NITIN User1",
"gender": "MALE",
"age": 20,
"email": "email@gmail.com",
"mobile": "9886122987"
},
{
"id": 45,
"name": "NITIN User2",
"gender": "FEMALE",
"age": 21,
"email": "email1@gmail.com",
"mobile": "9886122997"
},
{
"id": 46,
"name": "NITIN User3",
"gender": "MALE",
"age": 20,
"email": "email2@gmail.com",
"mobile": "9886122984"
}
]
}`


