roman-numerals-service
----------------------

A java web service to convert integers to roman numeral strings

Does not support numbers greater than 10 million (10000000). Requests for conversion of numbers greater than 10 million will result in a 400 bad request with 
an informative error message.


Usage
------
The main service endpoint is /romannumeral and can be used as follows:

Request: GET http://localhost:8080/numerictoroman?query=12

Response: { numeral: 12, romanNumeral: "XII" }

Request: GET http://localhost:8080/romantonumeric?query=IX

Response: { number: 9 }



Project Layout
------------------
The main java  file is located in src/main/java/com/conversion/Roman
The Service files are located in src/main/java/com/conversion/Roman/Utility
Here I've defined a simple class to convert numbers to roman numerals
The controller is inside src/main/java/com/conversion/Roman/Controller
Test files are located in src/test/java/com/conversion/Roman
Application config is located in /src/main/resources/application.properties

