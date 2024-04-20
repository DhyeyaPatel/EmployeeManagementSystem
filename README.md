# Employee_Details


|Functionalities|End Points|
|:--:|:--:|
|Get Employee Details in company|/all|
|Get Employee Details by ID|/byId|
|Get Employee Name|/byName|
|Get Employee Location|/byLoc|
|Add Employee Details|/addDetails|
|Delete Employee Details|/deleteDetails|
|Update Employee Details|/updateDetails|
|Update Employee Name|/updatePatchName/{id}/{name}|
|Update Employee Location|/updatePatchLoc/{location}|

## Logging
![Logging](https://github.com/DhyeyaPatel/Employee_Details/blob/main/EmployeeManagementSystem/images/Screenshot%20(7).png)

#### Logging Feature -> All the logs that will be printed when the service will be up will be stored in a text file as per Particular Name followed by timestamp. 

## Custom Exceptional Handling
![Custom Exceptional Handling](https://github.com/DhyeyaPatel/Employee_Details/blob/main/EmployeeManagementSystem/images/Screenshot%20(8).png)

#### Exceptional Handling Feature -> Majorly exceptions are customly handled along with a custom handling and also there is one custom annotation used in the microservice.

## Docker Compose File
There is docker compose file for containerizing servvices used in the microservice.

