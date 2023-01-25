A java web service to convert integers to roman numeral strings

Does not support numbers greater than 10 million (10000000). Requests for conversion of numbers greater than 10 million will result in a 400 bad request with an informative error message.


Usage
The main service endpoint is /romannumeral and can be used as follows:

Request: GET http://localhost:9090/romantonumeral?query=12

Response: { numeral: 12, romanNumeral: "XII" }

Request: GET http://localhost:9090/numeraltoroman?query=X

Response: {"romanNumeral":10}
